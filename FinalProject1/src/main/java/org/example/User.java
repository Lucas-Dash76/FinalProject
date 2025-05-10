package org.example;

import java.util.Objects;

public abstract class User {
    protected String name;
    protected int id;
    protected Gender gender;

    public User() {
        this.name = "";
        this.id = 0;
    }

    public User(String name, int id, Gender gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    public abstract void displayDashboard();

    public abstract boolean searchItems(String keyword);

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, gender);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gender=" + gender +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
