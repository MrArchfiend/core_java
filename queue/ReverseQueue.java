
import java.util.*;
public class ReverseQueue{
    public static <T> Queue<T> reverse(Queue<T> q){
        Stack<T> st=new Stack<>();
        while(!q.isEmpty()) st.push(q.remove());
        while(!st.isEmpty()) q.add(st.pop());
        return q;
    }
}
