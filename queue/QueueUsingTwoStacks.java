
import java.util.*;
public class QueueUsingTwoStacks<T>{
    Stack<T> s1=new Stack<>();
    Stack<T> s2=new Stack<>();
    public void add(T x){
        s1.push(x);
    }
    public T remove(){
        if(s2.isEmpty()) while(!s1.isEmpty()) s2.push(s1.pop());
        return s2.pop();
    }
    public boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }
}
