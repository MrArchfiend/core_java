public class ThrowVsThrowsDemo {
    static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0)
            throw new IllegalArgumentException("Invalid input");
        return (amount * rate * years) / 100;
    }
    public static void main(String[] args) {
        try {
            double result = calculateInterest(10000, 5, 2);
            System.out.println("Interest: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}