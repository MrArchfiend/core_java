
import java.util.*;
public class RemoveDuplicates{
    public static <T> List<T> remove(List<T> l){
        Set<T> s=new LinkedHashSet<>(l);
        return new ArrayList<>(s);
    }
}
