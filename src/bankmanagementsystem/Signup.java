
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
public class Signup extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,
            addressTextField,cityTextField,stateTextField,pinTextField;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;
    @Override
            public void actionPerformed(ActionEvent ae)
            {
                String formno=""+random;
                String name=nameTextField.getText();
                String fname=fnameTextField.getText();
                String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
                String gender=null;
                if(male.isSelected())
                {
                    gender="Male";
                }
                else if(female.isSelected())
                {
                    gender="female";
                }
                String email=emailTextField.getText();
                String maratial=null;
                if(married.isSelected())
                {
                    maratial="Married";
                }
                else if(unmarried.isSelected())
                {
                    maratial="Unmarried";
                }
                else if(other.isSelected())
                        {
                           maratial="Other"; 
                        }
                String address=addressTextField.getText();
                String city=cityTextField.getText();
                String state=stateTextField.getText();
                String pin=pinTextField.getText();
                if(nameTextField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"field is missing");
                }
                else
                {
                    try
                    {
                        Conn connection=new Conn();
                        connection.con();
                   connection.stat.execute("insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maratial+"','"+address+"','"+city+"','"+state+"','"+pin+"')");
                   setVisible(false);
                   new Signup2(formno).setVisible(true); 
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
    public Signup()
    {
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        //first
        JLabel formno=new JLabel("Application From NO "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        //second
        JLabel personalDetails=new JLabel("Page 1:Personal Deatils ");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
         //label 2
        JLabel name=new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        //text field 1
         nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,22));
        nameTextField.setBounds(300, 140, 400,30);
        add(nameTextField);
        //label 3
        JLabel fname=new JLabel("Father Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);
        //text field 2
         fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,22));
        fnameTextField.setBounds(300, 190, 400,30);
        add(fnameTextField);
        //label 4
        JLabel dob=new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);
         dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);
        
        // label 5
        JLabel gender=new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
         male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
         female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        //label email
          JLabel email=new JLabel("Email: ");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);
        // text field
           emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,22));
       emailTextField.setBounds(300, 340, 400,30);
        add(emailTextField);
        // label 6
        JLabel marital=new JLabel("Marital status: ");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,390,200,30);
        add(marital);
          married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
       married.setBackground(Color.WHITE);
        add(married);
        
       unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
       unmarried.setBackground(Color.WHITE);
        add(unmarried);
          other=new JRadioButton("Other");
        other.setBounds(630,390,100,30);
       other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);  
        // label 7
         JLabel address=new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        // text field
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,22));
       addressTextField.setBounds(300, 440, 400,30);
        add(addressTextField);
         // label 8
         JLabel city=new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);
        // text field
           cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,22));
       cityTextField.setBounds(300, 490, 400,30);
        add(cityTextField);
        // label 9
         JLabel state=new JLabel("state: ");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        // text field
           stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,22));
       stateTextField.setBounds(300, 540, 400,30);
        add(stateTextField);
         // label 10
         JLabel pincode=new JLabel("Pin code: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        // text field
           pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,22));
       pinTextField.setBounds(300, 590, 400,30);
        add(pinTextField);
        
        JButton next=new JButton("next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(600,660,80,30);
        next.addActionListener(this);
        add(next);
        
         getContentPane().setBackground(Color.WHITE);
         setTitle("SignUp form first");
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new Signup();
        
    }
    
}
