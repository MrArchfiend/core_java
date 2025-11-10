import java.util.Scanner;
public class StringToIntegerSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        String s = sc.nextLine();
        Integer num = Integer.parseInt(s);
        System.out.println("Square: " + (num * num));
    }
}