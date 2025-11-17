package warehouse;
import java.util.*;
public class Storage<T extends WarehouseItem> {
    private List<T> list = new ArrayList<>();
    public void addItem(T item) { list.add(item); }
    public static void displayAll(List<? extends WarehouseItem> items) {
        items.forEach(i -> System.out.println(i.getClass().getSimpleName()));
    }
}
