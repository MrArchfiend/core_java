package Library;

import java.util.Date;

public abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    // Encapsulation: fields are private; accessed via getters
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // abstract method to be implemented by each subclass
    public abstract Date getLoanDuration();

    // concrete method common to all library items
    public String getItemDetails() {
        return "Item ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
}
