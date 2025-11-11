package Library;

import java.util.Calendar;
import java.util.Date;

public class DVD extends LibraryItem implements Reservable {

    private boolean available = true;
    private String borrower;

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public Date getLoanDuration() {
        // DVDs can be borrowed for 3 days
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 3);
        return cal.getTime();
    }

    @Override
    public String reserveItem(String borrowerName) {
        if (available) {
            available = false;
            this.borrower = borrowerName;
            return "DVD reserved for " + borrowerName;
        } else {
            return "DVD is already reserved/issued.";
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
