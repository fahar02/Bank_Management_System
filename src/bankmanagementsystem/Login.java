
package bankmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
        
{
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
   public  Login()
    {
        setTitle("Automatic Teller Machine");
        setLayout(null);
        ImageIcon i1=new  ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        //first label
        JLabel text=new JLabel("welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));  
        text.setBounds(200,40,400,40);
        add(text);
        //second label
         JLabel cardNo=new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,38));  
        cardNo.setBounds(120,150,400,30);
        add(cardNo);
         cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
         cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        //third label
         JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,38));  
        pin.setBounds(120,220,250,30);
        add(pin);
         pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        //button first
        login=new JButton("login in");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        //button second
        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
         clear.addActionListener(this);
        add(clear);
        //button third
        signup=new JButton("SIGN-UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
            
        }
        else if(ae.getSource()==login)
        {
            try
            {
               
            String cardnumber=cardTextField.getText();
            String pin=pinTextField.getText();
              Conn c=new Conn();
              c.con();
            String query="select * from login where cardno='"+cardnumber+"' and pinno='"+pin+"'";
             ResultSet resultSet= c.stat.executeQuery(query);
            if(resultSet.next())
            {
                setVisible(false);
                new Transactions(pin);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"incorrect card number and pin");
            }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new Signup();
        }
        
    }
        
    public static void main(String args[])
    {
        new Login();
        
        
    }
}
