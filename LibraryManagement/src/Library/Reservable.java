package Library;

public interface Reservable {
    String reserveItem(String borrowerName); // borrowerName input
    boolean checkAvailability();
}
