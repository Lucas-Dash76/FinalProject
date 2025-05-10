package org.example;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Librarian extends User implements Borrowable{
    private Map<Item, Integer> LibraryItems;

    public Librarian(Map<Book, Integer> libraryItems) {
        LibraryItems = new TreeMap<>();
    }

    public Librarian(String name, int id, Gender gender, Map<Item, Integer> libraryItems) {
        super(name, id, gender);
        LibraryItems = libraryItems;
    }

    /**
     * adds item to librayItems
     * @param item
     */
    @Override
    public boolean borrowItem(Item item) {
        if (LibraryItems.containsKey(item) && LibraryItems.get(item) > 0) {
            int count = LibraryItems.get(item);
            LibraryItems.put(item, count - 1);
            return true;
        }
        return false;
    }

    /**
     * removes item from libraryitems
     * @param item
     */
    @Override
        public boolean returnItem(Item item, int i) {
            LibraryItems.put(item, i);
            return true;
    }

    /**
     * searches library items for keyword
     * @param keyword
     * @return if the keyword is in on of the library items
     */
    @Override
    public boolean searchItems(String keyword) {
        return LibraryItems.keySet().stream()
                .anyMatch(i -> i.getName()
                        .toLowerCase()
                        .contains(keyword.toLowerCase()));
    }

    /**
     * calls the method in LibrarySytem thta writes library books to a file
     */
    public void logout() {
        new LibrarySystem().writeLibraryItems(LibraryItems);
    }

    /**
     * calls the method in LibrarySytem that takes library books from a file
     */
    public void signin() {
        LibraryItems = new LibrarySystem().loadLibraryItems();
    }

    @Override
    public void displayDashboard() {
        System.out.println("Welcome" + this.name);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Librarian librarian = (Librarian) o;
        return Objects.equals(LibraryItems, librarian.LibraryItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), LibraryItems);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "LibraryItems=" + LibraryItems +
                '}';
    }

    public Map<Item, Integer> getLibraryItems() {
        return LibraryItems;
    }

    public void setLibraryItems(Map<Item, Integer> libraryItems) {
        LibraryItems = libraryItems;
    }
}
