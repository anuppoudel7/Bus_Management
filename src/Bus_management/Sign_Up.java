package Bus_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Sign_Up extends JFrame implements ActionListener {
 JFrame f;
 JLabel l1,l2,l3,l4;
 JTextField t1,t2,t3;
 JPasswordField p1;
 JButton b1,b2;
    Sign_Up()
    {
        f= new JFrame("Create New Account");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1= new JLabel("Username");
        l1.setBounds(50,30,110,40);
        f.add(l1);

        l2= new JLabel("Name");
        l2.setBounds(50,80,110,40);
        f.add(l2);

        l3= new JLabel("Password");
        l3.setBounds(50,130,110,40);
        f.add(l3);

        l4= new JLabel("Phone");
        l4.setBounds(50,180 ,110,40);
        f.add(l4);

        t1 = new JTextField();
        t1.setBounds(150,30,150,40);
        f.add(t1);

        t2 = new JTextField();
        t2.setBounds(150,80,150,40);
        f.add(t2);

        p1= new JPasswordField();
        p1.setBounds(150,130,150,40);
        f.add(p1);

        t3 = new JTextField();
        t3.setBounds(150,170,150,40);
        f.add(t3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon((i2));
        JLabel  l5 =  new JLabel(i3);
        l5.setBounds(350, 70,150,150);
        f.add(l5);

        b1 = new JButton("Sign up");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 250,130,40);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(50, 250,130,40);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.add(b1);
        f.add(b2);

        f.getContentPane();

        f.setVisible(true);
        f.setSize(550, 340);
        f.setLocation(400, 300);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String Username = t1.getText();
            String Name = t2.getName();
            String Password = p1.getText();
            String Phone = t3.getText();

            try{
ConnectionClass obj = new ConnectionClass();
String q = "insert into Signup values('"+Username+"','"+Name+"','"+Password+"','"+Phone+"')";
int aa =obj.stm.executeUpdate(q);
if(aa==1){
    JOptionPane.showMessageDialog(null,"Account created Successfully");
    this.setVisible(false);
    new Login();

}
else {
    JOptionPane.showMessageDialog(null,"Please!Fill all the details carefully");
    this.f.setVisible(false);
    this.f.setVisible(true);
}
            }

            catch(Exception e){
e.printStackTrace();
            }

        }
        if(ae.getSource()==b2)
        {
this.f.setVisible(false);
new Login();
        }
    }
    public static void main(String[] args)
    {

        new Sign_Up();
    }
}
