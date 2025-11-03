public class BankMain {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(10000);
        try {
            acc.withdraw(12000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}