import java.util.ArrayList;
public class AutoboxingCollection {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); // Autoboxing int -> Integer
        System.out.println(list);
    }
}