package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LibrarySystem {
    private static final String LIBRARY_FILE = "library_items.txt";
    private static final String RENTED_FILE = "rented_items.txt";

    /**
     * writes library items to a file
     * @param items the items to be written to a file
     */
    public void writeLibraryItems(Map<Item, Integer> items) {
        try (FileWriter writer = new FileWriter(LIBRARY_FILE)) {
            for (Map.Entry<Item, Integer> entry : items.entrySet()) {
                Item item = entry.getKey();
                int count = entry.getValue();
                if (item instanceof Book) {
                    Book book = (Book) item;
                    writer.write("Book," + book.getName() + "," + book.getAuthor() + "," +
                            book.getPublicationYear() + "," + book.getBookNumber() + "," + count + "\n");
                } else if (item instanceof Magazine) {
                    Magazine mag = (Magazine) item;
                    writer.write("Magazine," + mag.getName() + "," + mag.getAuthor() + "," +
                            mag.getPublicationYear() + "," + mag.getMagazineNumber() + "," + count + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing library items: " + e.getMessage());
        }
    }

    /**
     * loads library items from a file
     * @return
     */
    public Map<Item, Integer> loadLibraryItems() {
        Map<Item, Integer> items = new TreeMap<>();
        try (FileReader reader = new FileReader(LIBRARY_FILE)) {
            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                if (ch != '\n') {
                    sb.append((char) ch);
                } else {
                    parseItemLine(sb.toString(), items);
                    sb.setLength(0);
                }
            }
            if (sb.length() > 0) {
                parseItemLine(sb.toString(), items);
            }
        } catch (IOException e) {
            System.out.println("Error reading library items: " + e.getMessage());
        }
        return items;
    }

    private void parseItemLine(String line, Map<Item, Integer> items) {
        String[] parts = line.split(",");
        if (parts.length < 6) return;
        String type = parts[0];
        String name = parts[1];
        String author = parts[2];
        int year = Integer.parseInt(parts[3]);
        int uniqueNumber = Integer.parseInt(parts[4]);
        int count = Integer.parseInt(parts[5]);

        if (type.equals("Book")) {
            items.put(new Book(name, author, year, uniqueNumber), count);
        } else if (type.equals("Magazine")) {
            items.put(new Magazine(name, author, year, uniqueNumber), count);
        }
    }

    /**
     * writes the rneted items by the user to a file
     * @param items
     */
    public void writeRentedItems(List<Item> items) {
        try (FileWriter writer = new FileWriter(RENTED_FILE)) {
            for (Item item : items) {
                if (item instanceof Book) {
                    Book book = (Book) item;
                    writer.write("Book," + book.getName() + "," + book.getAuthor() + "," +
                            book.getPublicationYear() + "," + book.getBookNumber() + "\n");
                } else if (item instanceof Magazine) {
                    Magazine mag = (Magazine) item;
                    writer.write("Magazine," + mag.getName() + "," + mag.getAuthor() + "," +
                            mag.getPublicationYear() + "," + mag.getMagazineNumber() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing rented items: " + e.getMessage());
        }
    }

    /**
     * loads rented items from a file
     * @return the rented items
     */
    public List<Item> loadRentedItems() {
        List<Item> items = new ArrayList<>();
        try (FileReader reader = new FileReader(RENTED_FILE)) {
            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                if (ch != '\n') {
                    sb.append((char) ch);
                } else {
                    parseRentedLine(sb.toString(), items);
                    sb.setLength(0);
                }
            }
            if (sb.length() > 0) {
                parseRentedLine(sb.toString(), items);
            }
        } catch (IOException e) {
            System.out.println("Error reading rented items: " + e.getMessage());
        }
        return items;
    }

    private void parseRentedLine(String line, List<Item> items) {
        String[] parts = line.split(",");
        if (parts.length < 5) return;
        String type = parts[0];
        String name = parts[1];
        String author = parts[2];
        int year = Integer.parseInt(parts[3]);
        int uniqueNumber = Integer.parseInt(parts[4]);

        if (type.equals("Book")) {
            items.add(new Book(name, author, year, uniqueNumber));
        } else if (type.equals("Magazine")) {
            items.add(new Magazine(name, author, year, uniqueNumber));
        }
    }
}