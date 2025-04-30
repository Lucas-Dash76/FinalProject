package org.example;

public interface Borrowable {
        /**
         * Borrows the item for the given user.
         *
         * @param user the user borrowing the item
         * @return true if borrowing is successful, false otherwise
         */
        boolean borrowItem(User user);
}
