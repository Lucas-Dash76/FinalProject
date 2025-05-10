package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Student extends User implements Borrowable{
    private List<Item> rentedItems;

    public Student(List<Item> rentedItems) {
        this.rentedItems = new ArrayList<>();
    }

    public Student(String name, int id, Gender gender, List<Item> rentedItems) {
        super(name, id, gender);
        this.rentedItems = rentedItems;
    }

    /**
     * adds item to rentedItems
     *
     * @param item
     * @return
     */
    @Override
    public boolean borrowItem(Item item) {
        Map<Item, Integer> libraryItems = new LibrarySystem().loadLibraryItems();
        if (libraryItems.containsKey(item) && libraryItems.get(item) > 0) {
            rentedItems.add(item);
            int count = libraryItems.get(item);
            libraryItems.put(item, count - 1);
            new LibrarySystem().writeLibraryItems(libraryItems);
            return true;
        }
        return false;
    }

    /**
     * removes item from rentedItems
     * @param item
     */
    @Override
    public boolean returnItem(Item item, int i) {
        if (rentedItems.remove(item)) {
            Map<Item, Integer> libraryItems = new LibrarySystem().loadLibraryItems();
            libraryItems.put(item, i);
            new LibrarySystem().writeLibraryItems(libraryItems);
            return true;
        }
        return false;
    }

    /**
     * searches rented items for keyword
     * @param keyword
     * @return if the keyword is in on of the rented items
     */
    @Override
    public boolean searchItems(String keyword) {
        return rentedItems.stream()
                .anyMatch(i -> i.getName()
                        .toLowerCase()
                        .contains(keyword.toLowerCase()));
    }

    /**
     * displays the name of the user
     */
    @Override
    public void displayDashboard() {
        System.out.println("welcome" + this.name);
    }

    /**
     * calls the method in LibrarySytem thta writes rented items to a file
     */
    public void logout() {
        new LibrarySystem().writeRentedItems(rentedItems);
    }
    /**
     * calls the method in LibrarySytem that takes rented items from a file
     */
    public void signIn() {
        rentedItems = new LibrarySystem().loadRentedItems();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(rentedItems, student.rentedItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rentedItems);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rentedItems=" + rentedItems +
                '}';
    }

    public List<Item> getRentedItems() {
        return rentedItems;
    }

    public void setRentedItems(List<Item> rentedItems) {
        this.rentedItems = rentedItems;
    }
}
