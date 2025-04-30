package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Student extends User {
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
     * @param item
     */
    public void borrowItem(Item item) {
        //TODO implemnt add mehtod that checks if the item is borrowable
    }

    /**
     * removes item from rentedItems
     * @param item
     */
    public void returnItem(Item item) {
        //TODO implemnt remove mehtod that returns a book to the library
    }

    /**
     * searches rented books for keyword
     * @param keyword
     * @return if the keyword is in on of the rented items
     */
    public boolean searchRentedItems(String keyword) {
        //TODO implement stream mehtod that checks if rentedItems has a item with the keyword
    }
    /**
     * displays the name of the user
     */
    @Override
    public void displayDashboard() {
        System.out.println("welcome" + this.name);
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
