
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener
{
    JTextField amount;
    JButton deposite,back;
    String pinno;
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==deposite)
        {
            String number=amount.getText();
            Date date=new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"pls enter the amount you want to deposite");
            }
            else
            {
                try{
                    Conn c=new Conn();
                    c.con();
                c.stat.execute("insert into bank values('"+pinno+"','"+date+"','deposite','"+number+"')");
               JOptionPane.showMessageDialog(null,"rs"+number+"Deposite Successfylly");
               setVisible(false);
               new Transactions(pinno).setVisible(true);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
            
    }
    public Deposit( String pinno)
    {
        this.pinno=pinno;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(0,0,900,900);
            add(image);
            
            JLabel text=new JLabel("Enter the amount you want to deposit");
            text.setForeground(Color.WHITE);
            text.setFont(new Font("Raleway",Font.BOLD,16));
            text.setBounds(170,300,400,20);
            image.add(text);
            
             amount=new JTextField();
            amount.setFont(new Font("Raleway",Font.BOLD,22));
            amount.setBounds(170,350,320,30);
            add(amount);
        
       deposite=new JButton("Deposite");
        deposite.setBounds(355,480,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
            
       back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new Deposit("");
    }
}
