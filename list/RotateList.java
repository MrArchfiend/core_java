
import java.util.*;
public class RotateList{
    public static <T> List<T> rotate(List<T> list,int k){
        int n=list.size();
        List<T> r=new ArrayList<>();
        for(int i=0;i<n;i++) r.add(list.get((i+k)%n));
        return r;
    }
}
