package animals;
import java.util.List;
public class AnimalUtils {
    public static void printAnimals(List<? extends Animal> animals) {
        animals.forEach(a -> System.out.println(a.getClass().getSimpleName()));
    }
}
