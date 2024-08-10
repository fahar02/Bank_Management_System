
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
public class Signup2 extends JFrame implements ActionListener{
    JTextField panTextField,aadharTextField;
    JRadioButton scyes,scno,eyes,eno;
    JComboBox religioncom,catcom,jincome,eud,occup;
    JDateChooser dateChooser;
    String formno;
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                String sreligion=(String)religioncom.getSelectedItem();
                String scategory=(String)catcom.getSelectedItem();
                
                String sincome=(String)jincome.getSelectedItem();
                
                String seduation=(String)eud.getSelectedItem();
                String soccupation=(String)occup.getSelectedItem();
                String scs=null;
                if(scyes.isSelected())
                {
                    scs="yes";
                }
                else if(scno.isSelected())
                {
                    scs="NO";
                }
                String  sea=null;
                if(eyes.isSelected())
                {
                    sea="Yes";
                }
                else if(eno.isSelected())
                {
                    sea="NO";
                }
                String span=panTextField.getText();
                String saadhar=aadharTextField.getText();
               if(panTextField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"field is missing");
                }
                else
                {
                    try
                    {
                        Conn connection=new Conn();
                        connection.con();
                   connection.stat.execute("insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seduation+"','"+soccupation+"','"+scs+"','"+sea+"','"+span+"','"+saadhar+"')");
                   // signup 3 object
                   
                   setVisible(false);
                   new Signup3(formno).setVisible(true);
               
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
    public Signup2(String formno)
    {
        this.formno=formno;
        
        setLayout(null);
        //second
        JLabel additionalDetails=new JLabel("Page 2:Additional Deatils ");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
         //label 2
        JLabel religion=new JLabel("Religion : ");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100,140,200,30);
        add(religion);
        
        String val[]={"hindu","muslim","sikh","cristain","other"};
         religioncom=new JComboBox(val);
        religioncom.setBackground(Color.WHITE);
        religioncom.setBounds(300, 140, 400,30);
        add(religioncom);
        
        //label 3
        JLabel category=new JLabel("Category : ");
        category.setFont(new Font("Raleway",Font.BOLD,22));
        category.setBounds(100,190,200,30);
        add(category);
        String cat[]={"open","obc","st","nt"};
        catcom=new JComboBox(cat);
        catcom.setBounds(300, 190, 400,30);
        catcom.setBackground(Color.WHITE);
        add(catcom);
        
         JLabel income=new JLabel("income : ");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100,240,200,30);
        add(income);
        
        String i[]={"<50000","<150000","<250000","max"};
         jincome=new JComboBox(i);
        jincome.setBounds(300,240,400,30);
        jincome.setBackground(Color.WHITE);
        add(jincome);
        
        JLabel eduation=new JLabel(" Education");
        eduation.setFont(new Font("Raleway",Font.BOLD,22));
        eduation.setBounds(100,290,200,30);
        add(eduation);
        JLabel qualification=new JLabel(" Qualification : ");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
       qualification.setBounds(100,320,200,30);
        add(qualification);
        
        String e[]={"graduation","postgraduation","master","other"};
         eud=new JComboBox(e);
        eud.setBounds(300,300,400,30);
        eud.setBackground(Color.WHITE);
        add(eud);
        
        JLabel occuption=new JLabel("Occupation: ");
        occuption.setFont(new Font("Raleway",Font.BOLD,22));
        occuption.setBounds(100,390,200,30);
        add(occuption);
        String o[]={"government","private","bussiness","other"};
         occup=new JComboBox(o);
        occup.setBounds(300,390,400,30);
        occup.setBackground(Color.WHITE);
        add(occup);
        
         JLabel pan=new JLabel("Pan NO: ");
       pan.setFont(new Font("Raleway",Font.BOLD,22));
       pan.setBounds(100,440,200,30);
        add(pan);
         
         panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,22));
       panTextField.setBounds(300, 440, 400,30);
        add(panTextField);
        
        JLabel aadhar=new JLabel("Aadhar NO: ");
       aadhar.setFont(new Font("Raleway",Font.BOLD,22));
       aadhar.setBounds(100,490,200,30);
        add(aadhar);
         
         aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,22));
       aadharTextField.setBounds(300, 490, 400,30);
        add(aadharTextField);
        
       
         
         JLabel sc=new JLabel("Senior Citizen: ");
        sc.setFont(new Font("Raleway",Font.BOLD,22));
        sc.setBounds(100,540,200,30);
        add(sc);
         scyes=new JRadioButton("yes");
        scyes.setBounds(300,540,60,30);
        scyes.setBackground(Color.WHITE);
        add(scyes);
         scno=new JRadioButton("NO");
        scno.setBounds(450,540,120,30);
        scno.setBackground(Color.WHITE);
        add(scno);
        ButtonGroup scGroup=new ButtonGroup();
        scGroup.add(scyes);
        scGroup.add(scno);
        
        
         JLabel ea=new JLabel("Exisiting Account: ");
        ea.setFont(new Font("Raleway",Font.BOLD,22));
        ea.setBounds(100,590,200,30);
        add(ea);
        eyes=new JRadioButton("yes");
        eyes.setBounds(300,590,60,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
         eno=new JRadioButton("NO");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup eagroup=new ButtonGroup();
       eagroup.add(eyes);
        eagroup.add(eno);
        
        
          
        
        
        JButton next=new JButton("next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(600,660,80,30);
        next.addActionListener(this);
        add(next);
        
         getContentPane().setBackground(Color.WHITE);
         setTitle("SignUP form 2");
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new Signup2("");
        
    }
    
    
    
}
