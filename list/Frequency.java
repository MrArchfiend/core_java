
import java.util.*;
public class Frequency{
    public static Map<String,Integer> freq(List<String> l){
        Map<String,Integer> m=new HashMap<>();
        for(String s:l) m.put(s,m.getOrDefault(s,0)+1);
        return m;
    }
}
