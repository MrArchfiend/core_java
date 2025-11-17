
import java.util.*;
public class Library{
    List<Book> books=new ArrayList<>();
    public void add(Book b){books.add(b);}
    public List<Book> search(String k){
        List<Book> r=new ArrayList<>();
        for(Book b:books) if(b.getTitle().contains(k)) r.add(b);
        return r;
    }
}
