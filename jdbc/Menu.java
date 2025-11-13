package src;
import java.util.*;

public class Menu implements IMenu {
    public void display(){
        Scanner sc = new Scanner(System.in);
        IStudent s = new StudentImpl(new ConnectionImpl());

        while(true){
            System.out.println("1.Insert a student\n2.Update a student\n3.Delete a student\n4.Show Students\n5.Exit");
            int ch = sc.nextInt();
            if(ch==1){
                System.out.print("ID: "); int id=sc.nextInt();
                System.out.print("Name: "); String name=sc.next();
                System.out.print("Age: "); int age=sc.nextInt();
                s.insertStudent(id,name,age);
            }
            else if(ch==2){
                System.out.print("ID: "); int id=sc.nextInt();
                System.out.print("Name: "); String name=sc.next();
                System.out.print("Age: "); int age=sc.nextInt();
                s.updateStudent(id,name,age);
            }
            else if(ch==3){
                System.out.print("ID: "); int id=sc.nextInt();
                s.deleteStudent(id);
            }
            else if(ch==4){
                s.showStudents();
            }
            else break;
        }
    }
}
