package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener
{
    
    JPasswordField pin,repin;
    String pinno;
    JButton change,back;
    public PinChange(String pinno)
    {
        setLayout(null);
        this.pinno=pinno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text=new JLabel("change your pin");
       text.setForeground(Color.WHITE);
       text.setFont(new Font("Raleway",Font.BOLD,16));
       text.setBounds(250,280,500,35);
       image.add(text);
       
       JLabel pintext=new JLabel("New pin");
       pintext.setForeground(Color.WHITE);
       pintext.setFont(new Font("Raleway",Font.BOLD,16));
       pintext.setBounds(165,320,180,30);
       image.add(pintext);
       
       pin=new JPasswordField();
       pin.setFont(new Font("Raleway",Font.BOLD,20));
       pin.setBounds(330,320,180,25);
       image.add(pin);
       
         JLabel repintext=new JLabel("Re-Enter new Pin:");
       repintext.setForeground(Color.WHITE);
       repintext.setFont(new Font("Raleway",Font.BOLD,16));
      repintext.setBounds(165,360,180,30);
       image.add(repintext);
       
       repin=new JPasswordField();
       repin.setFont(new Font("Raleway",Font.BOLD,20));
       repin.setBounds(330,360,180,25);
       image.add(repin);
       
       JButton  change=new JButton("Change");
       change.setBounds(355,485,150,30);
       change.addActionListener(this);
       image.add(change);
       
        back=new JButton("Back");
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
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==change)
        {
         try
        {
            String npin=pin.getText();
            String rpin=repin.getText();
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null,"enter pin does not match");
                return;
            }
             if(!npin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"please enter new pin");
                return;
            }
             if(!rpin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"please Re-enter new pin");
                return;
            }
             Conn con=new Conn();
             String query1="upadte bank set pinno='"+rpin+"' where pinno='"+pinno+"'";
             String query2="upadte login set pinno='"+rpin+"' where pinno='"+pinno+"'";
             String query3="upadte signup3 set pinno='"+rpin+"' where pinno='"+pinno+"'";
             
             con.stat.executeUpdate(query1);
             con.stat.executeUpdate(query2);
             con.stat.executeUpdate(query3);
             
             JOptionPane.showMessageDialog(null,"pin change Successfully");
             setVisible(false);
             new Transactions(rpin).setVisible(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
        else
        {
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
        
    }
    
}
