
import java.util.*;
public class StudentRecord{
    Map<Integer,Student> map=new HashMap<>();
    public void add(Student s){map.put(s.getRoll(),s);}
    public Student get(int r){return map.get(r);}
    public Collection<Student> all(){return map.values();}
}
