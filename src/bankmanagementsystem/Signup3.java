
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Signup3 extends JFrame implements ActionListener
{
    JRadioButton  r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancle; 
    String formno;
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accounttype=null;
            if(r1.isSelected())
            {
                accounttype="saving account";
            }
            else if(r2.isSelected())
            {
                accounttype="Current account";
            }
            else if(r3.isSelected())
            {
                accounttype="Fixed Deposit account";
            }
            else if(r4.isSelected())
            {
            accounttype="recurring Account";
            }
            Random random=new Random();
         String cardnumber=""+Math.abs(random.nextLong()%90000000+5040936000000000L);
         String pinnumber=""+Math.abs(random.nextLong()%9000L+1000L);
         String facility="";
         boolean flag[]={c1.isSelected(),c2.isSelected(),c3.isSelected(),c4.isSelected(),c5.isSelected(),c6.isSelected()};
         String data[]={"ATM Card","Internet Banking","Mobile Banking","email & message","cheque book","E-statement"};
         
         for(int i=0;i<flag.length-1;i++)
        {
            if(flag[i]==true)
            {
                facility=facility+data[i];
            }
        }
         
         if(c7.getText().equals(""))
         {
             JOptionPane.showMessageDialog(null,"input missing");
         }
         else
         {
             try
             {
                 Conn c=new Conn();
             c.con();
             c.stat.execute("insert into signup3 values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')");
             c.stat.execute("insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')");
            JOptionPane.showMessageDialog(null,"card no is:"+cardnumber+"pin :"+pinnumber);
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
             
             setVisible(false);
             new Deposit(pinnumber).setVisible(true);
         }
        }
        else if(ae.getSource()==cancle)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public Signup3(String formno)
    {
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("page 3:Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        
         JLabel l2=new JLabel("Account type:");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(100,140,200,30);
        add(l2);
        
        r1=new JRadioButton("saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,200,20);
        add(r1);
        
         r2=new JRadioButton("current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(450,180,200,20);
        add(r2);
        
        
         r3=new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,200,20);
        add(r3);
        
         r4=new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(450,220,200,20);
        add(r4);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        
        //card no
          JLabel cardno=new JLabel("Card number:");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(100,270,200,30);
        add(cardno);
        //card label
        JLabel cardlabel=new JLabel("Your 16 Digit Card NO");
        cardlabel.setFont(new Font("Raleway",Font.BOLD,14));
        cardlabel.setBounds(100,300,200,20);
        add(cardlabel);
        
        JLabel cnumber=new JLabel("XXXX-XXXX-XXXX-5786");
        cnumber.setFont(new Font("Raleway",Font.BOLD,22));
        cnumber.setBounds(350,270,300,30);
        add(cnumber);
        
        //pin
        JLabel pin=new JLabel("pin number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,350,200,30);
        add(pin);
        
        //pin label
        JLabel pinlabel=new JLabel("Your 4 digit pin no");
        pinlabel.setFont(new Font("Raleway",Font.BOLD,14));
        pinlabel.setBounds(100,380,200,20);
        add(pinlabel);
        
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(350,350,300,30);
        add(pnumber);
        
        
         JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,420,300,30);
        add(services);
        
        c1=new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,22));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,480,200,30);
        add(c1);
        
         c2=new JCheckBox("Internate Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,22));
        c2.setBackground(Color.WHITE);
        c2.setBounds(300,480,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,22));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,520,200,30);
        add(c3);
        
         c4=new JCheckBox("Email and sms rervices");
        c4.setFont(new Font("Raleway",Font.BOLD,22));
        c4.setBackground(Color.WHITE);
        c4.setBounds(300,520,200,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,22));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,560,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,22));
        c6.setBackground(Color.WHITE);
        c6.setBounds(300,560,200,30);
        add(c6);
        
        c7=new JCheckBox("I here by declares that the above enter details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,14));
        c7.setBackground(Color.WHITE);
        c7.setBounds(20,600,700,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(420,650,100,30);
        submit.addActionListener(this);
        add(submit);
        
        
        cancle=new JButton("Cancle");
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.setFont(new Font("Raleway",Font.BOLD,14));
        cancle.setBounds(540,650,100,30);
        cancle.addActionListener(this);
        add(cancle);
               
        
        setTitle("signup no 3");
       setSize(850,820);
        setVisible(true);
        setLocation(350,0);
        
        
    }
    public static void main(String args[])
    {
        new Signup3("");
    }
    
}
