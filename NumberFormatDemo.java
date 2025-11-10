public class NumberFormatDemo {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("abc123");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format!");
        }
    }
}