package org.example;

public interface Borrowable {
        /**
         * Borrows the item for the given user.
         * @param item the item that will be chekced to borrow
         * @return true if borrowing is successful, false otherwise
         */
        boolean borrowItem(Item item);

        /**
         * Returns a borrowed item.
         * @param item the item to return
         * @return true if return is successful, false otherwise
         */
        boolean returnItem(Item item, int i);
}
