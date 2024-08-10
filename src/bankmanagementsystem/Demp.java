
package bankmanagementsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.SQLException;
public class Demp {
    public static void main(String args[])throws SQLException, ClassNotFoundException
    {
       
       String data="";
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","fahar");
       Statement statement=connection.createStatement();
    ResultSet  resultSet= statement.executeQuery("select * from bank where pinno='"+5608+"'");
        while(resultSet.next())
        {
            //System.out.println(resultSet.getString(1));
             //System.out.println(resultSet.getString(2));
              //System.out.println(resultSet.getString(3));
               data=resultSet.getString(4);
        }
        System.out.println(data);
        connection.close();
       
        
        
       
    }
        
    }
    
    