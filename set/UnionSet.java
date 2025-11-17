
import java.util.*;
public class UnionSet{
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        Set<T> r=new HashSet<>(a);
        r.addAll(b);
        return r;
    }
}
