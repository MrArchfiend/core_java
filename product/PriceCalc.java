package product;
import java.util.List;
public class PriceCalc {
    public static double calculateTotal(List<? extends Product> items) {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
}
