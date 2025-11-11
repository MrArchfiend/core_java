package Library;

import java.util.Calendar;
import java.util.Date;

public class Book extends LibraryItem implements Reservable {

    private boolean available = true;
    private String borrower;  // Encapsulation of borrower info

    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public Date getLoanDuration() {
        // Books can be borrowed for 14 days
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 14);
        return cal.getTime();
    }

    @Override
    public String reserveItem(String borrowerName) {
        if (available) {
            available = false;
            this.borrower = borrowerName;
            return "Book reserved for " + borrowerName;
        } else {
            return "Book is already reserved/issued.";
        }
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }

    // Encapsulation: Only provide a secure method to get borrower info
    public String getBorrower() {
        return borrower;
    }
}
