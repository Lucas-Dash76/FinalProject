package org.example;

import java.util.Objects;

public class Book extends Item {
    private int bookNumber;

    public Book(String name, String author, int publicationYear, int bookNumber) {
        super(name, author, publicationYear);
        this.bookNumber = bookNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return bookNumber == book.bookNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bookNumber);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNumber=" + bookNumber +
                '}';
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }
}
