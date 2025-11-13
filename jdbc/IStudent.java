package src;
import java.util.List;

public interface IStudent {
    void insertStudent(int id, String name, int age);
    void insertMultiple(List<Student> students);
    void updateStudent(int id, String name, int age);
    void updateMultiple(List<Student> students);
    void deleteStudent(int id);
    void deleteMultiple(List<Integer> ids);
    void showStudents();
}
