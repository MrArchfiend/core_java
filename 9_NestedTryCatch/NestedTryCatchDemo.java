public class NestedTryCatchDemo {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        int divisor = 0;
        try {
            try {
                int val = arr[2];
                System.out.println("Result: " + (val / divisor));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}