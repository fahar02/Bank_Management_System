
package bankmanagementsystem;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conn 
{
    Connection c;
    Statement stat;
    public void con()throws ClassNotFoundException,SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","fahar");
        stat=c.createStatement();
    }
    
    
}
