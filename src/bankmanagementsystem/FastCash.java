
package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
     String pinno;
    JButton deposit,fastcash,withdrawl,ministatement,pinchange,benquery,exit;
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
        else
        {
            String amount=((JButton)ae.getSource()).getText().substring(3);
           Conn co=new Conn();
           
           try
           {
               co.con();
               ResultSet resultset=co.stat.executeQuery("select * from bank where pinno='"+pinno+"'");
                      int bal=0;
                      while(resultset.next())
                      {
                          if(resultset.getString("type").equals("deposite"))
                          {
                              bal+=Integer.parseInt(resultset.getString("amount"));
                          }
                          else
                          {
                               bal-=Integer.parseInt(resultset.getString("amount"));
                          }
                      }
                        if(ae.getSource()!=exit && bal<Integer.parseInt(amount))
                        {
                            JOptionPane.showMessageDialog(null,"insufficient balance");
                        }
                        Date date=new Date();
                        co.stat.executeQuery("insert into bank values( '"+pinno+"','"+date+"','withdrawl','"+amount+"')");
                         JOptionPane.showMessageDialog(null,"rs"+amount+"debited Successfully");
                        setVisible(false);
                         new Transactions(pinno).setVisible(true);
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
        }
       
    }
    public FastCash(String pino)
    {
        setLayout(null);
        this.pinno=pinno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
       add(image);
       
       
       JLabel text=new JLabel("select withdrawl amount");
       text.setBounds(210,300,700,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("Raleway",Font.BOLD,20));
       image.add(text);
       
        deposit=new JButton("Rs.100");
       deposit.setBounds(170,415,150,30);
       deposit.addActionListener(this);
       image.add(deposit);
       
        fastcash=new JButton("Rs.500");
       fastcash.setBounds(170,450,150,30);
       fastcash.addActionListener(this);
       image.add(fastcash);
       
        withdrawl=new JButton("Rs.1000");
       withdrawl.setBounds(355,415,150,30);
       withdrawl.addActionListener(this);
       image.add(withdrawl);
       
        ministatement=new JButton("Rs.2000");
       ministatement.setBounds(355,450,150,30);
       ministatement.addActionListener(this);
       image.add(ministatement);
       
       pinchange=new JButton("Rs.5000");
       pinchange.setBounds(170,485,150,30);
       pinchange.addActionListener(this);
       image.add(pinchange);
       
         benquery=new JButton("Rs.10000");
       benquery.setBounds(355,485,150,30);
       benquery.addActionListener(this);
       image.add(benquery);
       
        exit=new JButton("back");
       exit.setBounds(355,520,150,30);
       exit.addActionListener(this);
       image.add(exit);
       
       
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new FastCash("");
    }
    
    
}
