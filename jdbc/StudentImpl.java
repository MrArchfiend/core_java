package src;
import java.sql.*;
import java.util.List;

public class StudentImpl implements IStudent {
    private Connection con;

    public StudentImpl(IConnection connection){
        con = connection.getConnection();
    }

    public void insertStudent(int id, String name, int age){
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES(?,?,?)");
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,age);
            ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace(); }
    }

    public void insertMultiple(List<Student> students){
        for(Student s : students) insertStudent(s.id,s.name,s.age);
    }

    public void updateStudent(int id, String name, int age){
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE students SET name=?, age=? WHERE id=?");
            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setInt(3,id);
            ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace(); }
    }

    public void updateMultiple(List<Student> students){
        for(Student s : students) updateStudent(s.id,s.name,s.age);
    }

    public void deleteStudent(int id){
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace(); }
    }

    public void deleteMultiple(List<Integer> ids){
        for(Integer id : ids) deleteStudent(id);
    }

    public void showStudents(){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
            }
        } catch(Exception e){ e.printStackTrace(); }
    }
}
