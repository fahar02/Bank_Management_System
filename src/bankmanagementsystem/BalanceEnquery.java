
package bankmanagementsystem;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class BalanceEnquery extends JFrame implements ActionListener
{
    JButton back;   
    String pinno;
    public BalanceEnquery(String pinno)
    {
        setLayout(null);
        this.pinno=pinno;
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
       add(image);
        
      
       int bal=0;
        try
           {
               Conn co=new Conn();
               co.con();
               ResultSet resultset=co.stat.executeQuery("select * from bank where pinno='"+pinno+"'");
                      
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
                        
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
       JLabel text=new JLabel("your current balance is rs:"+bal);
       text.setForeground(Color.WHITE);
       text.setBounds(170,300,400,30);
       image.add(text);
       
        back=new JButton("back");
       back.setBounds(355,520,150,30);
       back.addActionListener(this);
       image.add(back);
       
       
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new BalanceEnquery("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
        
    }
}
