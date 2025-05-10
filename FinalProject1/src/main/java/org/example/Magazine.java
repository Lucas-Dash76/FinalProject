package org.example;

import org.example.Item;

import java.util.Objects;

public class Magazine extends Item {
    private int magazineNumber;

    public Magazine(String name, String author, int publicationYear, int magasineNumber) {
        super(name, author, publicationYear);
        this.magazineNumber = magasineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return magazineNumber == magazine.magazineNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magazineNumber);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "magazineNumber=" + magazineNumber +
                '}';
    }

    public int getMagazineNumber() {
        return magazineNumber;
    }

    public void setMagazineNumber(int magazineNumber) {
        this.magazineNumber = magazineNumber;
    }
}
