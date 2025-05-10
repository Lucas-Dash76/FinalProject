package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestStudent {
    private Student student;
    private Book book;

    @BeforeEach
    public void setUp() {
        student = new Student("Bob", 202, User.Gender.MALE, new ArrayList<>());
        book = new Book("Brave New World", "Aldous Huxley", 1932, 2);
    }

    @Test
    public void borrowItemTest() {
        LibrarySystem system = new LibrarySystem() {
            @Override
            public Map<Item, Integer> loadLibraryItems() {
                Map<Item, Integer> map = new HashMap<>();
                map.put(book, 1);
                return map;
            }

            @Override
            public void writeLibraryItems(Map<Item, Integer> items) {
                // Do nothing for test
            }
        };

        boolean success = student.borrowItem(book);
        assertTrue(success);
        assertTrue(student.getRentedItems().contains(book));
    }

    @Test
    public void returnItemTest() {
        student.getRentedItems().add(book);

        LibrarySystem system = new LibrarySystem() {
            @Override
            public Map<Item, Integer> loadLibraryItems() {
                return new HashMap<>();
            }

            @Override
            public void writeLibraryItems(Map<Item, Integer> items) {
                // Do nothing
            }
        };

        boolean success = student.returnItem(book, 1);
        assertTrue(success);
        assertFalse(student.getRentedItems().contains(book));
    }
}
