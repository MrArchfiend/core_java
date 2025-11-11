package Library;

import java.util.Calendar;
import java.util.Date;

public class Magazine extends LibraryItem implements Reservable {

    private boolean available = true;
    private String borrower;

    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public Date getLoanDuration() {
        // Magazines can be borrowed for 7 days
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 7);
        return cal.getTime();
    }

    @Override
    public String reserveItem(String borrowerName) {
        if (available) {
            available = false;
            this.borrower = borrowerName;
            return "Magazine reserved for " + borrowerName;
        } else {
            return "Magazine is already reserved/issued.";
        }
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }

    public String getBorrower() {
        return borrower;
    }
}
