package fruits;
import java.util.*;
public class FruitBox<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();
    public void addFruit(T fruit) { fruits.add(fruit); }
    public void displayFruits() { fruits.forEach(f -> System.out.println(f.getClass().getSimpleName())); }
}
