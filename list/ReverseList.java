
import java.util.*;
public class ReverseList{
    public static <T> List<T> reverse(List<T> list){
        List<T> r=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--) r.add(list.get(i));
        return r;
    }
}
