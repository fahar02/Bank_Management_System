package bankmanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.sql.ResultSet;
public class MiniStatement  extends JFrame
{
    
    public MiniStatement(String pinno)
    {
        setLayout(null);
        setTitle("mini statment");
        
        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,30);
        add(mini);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,30);
        add(balance);
        
        JLabel bank=new JLabel("Iadian Bank");
        bank.setBounds(20,80,300,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        try
        {
           
            Conn con=new Conn();
            con.con();
            ResultSet resultSet=con.stat.executeQuery("select * from login where pinno='"+pinno+"'");
            while(resultSet.next())
            {
                card.setText("card number"+resultSet.getString("cardno").substring(0,4)+"XXXXXXX"+resultSet.getString("cardno").substring(12));
         
            }
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
             int bal=0;
            Conn con=new Conn();
            con.con();
            ResultSet rs=con.stat.executeQuery("select * from bank where pinno='"+pinno +"'");
            while(rs.next())
            {
                mini.setText(mini.getText()+ "<html>" +rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"</html>");
            if(rs.getString("type").equals("deposite"))
                          {
                              bal+=Integer.parseInt(rs.getString("amount"));
                          }
                          else
                          {
                               bal-=Integer.parseInt(rs.getString("amount"));
                          }
            }
           
            balance.setText("Your current account balance is rs"+bal);
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                }
        
        
        
        
        
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
public static void main(String args[])
{
    new MiniStatement("").setVisible(true);
}
}
