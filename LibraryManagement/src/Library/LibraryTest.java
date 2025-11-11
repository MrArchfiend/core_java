package Library;

import java.util.Date;

public class LibraryTest {
    public static void main(String[] args) {
        // Polymorphism: LibraryItem reference to different item types
        LibraryItem[] items = new LibraryItem[3];

        items[0] = new Book(101, "Java Programming", "James Gosling");
        items[1] = new Magazine(102, "National Geographic", "Various");
        items[2] = new DVD(103, "Inception Movie", "Christopher Nolan");

        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration Ends On: " + item.getLoanDuration());

            // Reservable check
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println(reservableItem.reserveItem("Kunal Gupta"));
                System.out.println("Availability after reserve: " + reservableItem.checkAvailability());
            }

            System.out.println("-----------------------------------");
        }
    }
}
