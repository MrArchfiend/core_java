
import java.util.*;
public class IntersectionSet{
    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> r=new HashSet<>(a);
        r.retainAll(b);
        return r;
    }
}
