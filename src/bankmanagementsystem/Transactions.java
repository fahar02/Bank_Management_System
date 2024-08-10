
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener
{
    String pinno;
    JButton deposit,fastcash,withdrawl,ministatement,pinchange,benquery,exit;
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinno).setVisible(true);
        }
        else if(ae.getSource()==withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinno).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinno).setVisible(true);
        }
        else if(ae.getSource()==pinchange)
        {
            setVisible(false);
            new PinChange(pinno).setVisible(true);
        }
        else if(ae.getSource()==benquery)
        {
            setVisible(false);
            new BalanceEnquery(pinno).setVisible(true);
        }
        else if(ae.getSource()==ministatement)
        {
            new MiniStatement(pinno).setVisible(true);
        }
    }
    public Transactions(String pino)
    {
        setLayout(null);
        this.pinno=pinno;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
       add(image);
       
       
       JLabel text=new JLabel("pls Select your Transactions");
       text.setBounds(210,300,700,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("Raleway",Font.BOLD,20));
       image.add(text);
       
        deposit=new JButton("Deposit");
       deposit.setBounds(170,415,150,30);
       deposit.addActionListener(this);
       image.add(deposit);
       
        fastcash=new JButton("Fast Cash");
       fastcash.setBounds(170,450,150,30);
       fastcash.addActionListener(this);
       image.add(fastcash);
       
        withdrawl=new JButton("Withdrawl");
       withdrawl.setBounds(355,415,150,30);
       withdrawl.addActionListener(this);
       image.add(withdrawl);
       
        ministatement=new JButton("mini-statement");
       ministatement.setBounds(355,450,150,30);
       ministatement.addActionListener(this);
       image.add(ministatement);
       
       pinchange=new JButton("pin change");
       pinchange.setBounds(170,485,150,30);
       pinchange.addActionListener(this);
       image.add(pinchange);
       
         benquery=new JButton("balance Enquery");
       benquery.setBounds(355,485,150,30);
       benquery.addActionListener(this);
       image.add(benquery);
       
        exit=new JButton("Exit");
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
        new Transactions("");
    }
    
}
