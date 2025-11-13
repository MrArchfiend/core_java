package src;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionImpl implements IConnection {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
