package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class TestLibrarian {
    private Librarian librarian;
    private Book book;
    private int i;

    @BeforeEach
    public void setUp() {
        Map<Item, Integer> items = new TreeMap<>();
        librarian = new Librarian("Alice", 101, User.Gender.FEMALE, items);
        book = new Book("1984", "George Orwell", 1949, 1);
    }

    @Test
    public void addItemTest() {
        librarian.returnItem(book, i);
        assertTrue(librarian.getLibraryItems().containsKey(book));
        assertEquals(3, librarian.getLibraryItems().get(book));
    }

    @Test
    public void removeItemTest() {
        librarian.returnItem(book, 3);
        librarian.borrowItem(book);
        assertFalse(librarian.getLibraryItems().containsKey(book));
    }

    @Test
    public void borrowItemTest() {
        librarian.returnItem(book, 2);
        boolean success = librarian.borrowItem(book);
        assertTrue(success);
        assertEquals(1, librarian.getLibraryItems().get(book));
    }

    @Test
    public void returnItemTest() {
        librarian.returnItem(book, 1);
        librarian.borrowItem(book);
        librarian.returnItem(book,3);
        assertEquals(1, librarian.getLibraryItems().get(book));
    }
}
