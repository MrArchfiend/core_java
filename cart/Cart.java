package cart;
import java.util.*;
public class Cart<T> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) { items.add(item); }
    public void removeItem(T item) { items.remove(item); }
    public void displayItems() { items.forEach(System.out::println); }
}
