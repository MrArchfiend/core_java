/*
 Library Management System
 - Abstract LibraryItem; subclasses Book, Magazine, DVD
 - Interface Reservable
*/
import java.util.*;

public class Project5_LibraryManagementSystem {
    public static abstract class LibraryItem {
        private String itemId;
        private String title;
        private String author;

        public LibraryItem(String itemId, String title, String author) {
            this.itemId = itemId;
            this.title = title;
            this.author = author;
        }

        public String getItemId() { return itemId; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }

        public String getItemDetails() {
            return String.format("%s - %s by %s", itemId, title, author);
        }

        public abstract int getLoanDuration(); // days
    }

    public interface Reservable {
        boolean reserveItem(String userId);
        boolean checkAvailability();
    }

    public static class Book extends LibraryItem implements Reservable {
        private boolean available = true;
        public Book(String id, String title, String author) { super(id,title,author); }

        @Override
        public int getLoanDuration() { return 21; }

        @Override
        public boolean reserveItem(String userId) {
            if (!available) return false;
            available = false;
            return true;
        }

        @Override
        public boolean checkAvailability() { return available; }
    }

    public static class Magazine extends LibraryItem {
        public Magazine(String id, String title, String author) { super(id,title,author); }
        @Override
        public int getLoanDuration() { return 7; }
    }

    public static class DVD extends LibraryItem {
        public DVD(String id, String title, String author) { super(id,title,author); }
        @Override
        public int getLoanDuration() { return 5; }
    }

    public static void main(String[] args) {
        List<LibraryItem> items = Arrays.asList(
            new Book("B100","Clean Code","Robert C. Martin"),
            new Magazine("M200","Nature - Aug", "Various"),
            new DVD("D300","Inception","Christopher Nolan")
        );

        for (LibraryItem it : items) {
            System.out.println(it.getItemDetails() + " | Loan days: " + it.getLoanDuration());
        }

        Book b = (Book)items.get(0);
        System.out.println("Available before reserve: " + b.checkAvailability());
        b.reserveItem("user123");
        System.out.println("Available after reserve: " + b.checkAvailability());
    }
}
