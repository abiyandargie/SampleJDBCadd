 
package registration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*; 

public class Registration extends JFrame {
    JTextField tf;
    JTextField tf1;
    JTextField tf2;
    JTextField tf3;
    JButton bt3;
    JButton bt;
    JButton bt1;
    JPanel pan;
    Registration(){
        
         JPanel pan= new JPanel();


        LayoutManager l1=new GridLayout(5,2,5,5);
        JLabel lb=new JLabel("IDNO");
        JTextField tf= new JTextField();
         JLabel lb1=new JLabel("FirstName");
        JTextField tf1= new JTextField();
        JLabel lb2=new JLabel("LName");
        JTextField tf2= new JTextField();
       JLabel lb3=new JLabel("sex");
        JTextField tf3= new JTextField();
        JButton bt=new JButton("ADD");
        JButton bt1=new JButton("Clear");
        bt3=new JButton("display");
        pan.add(bt3);
        pan.setLayout(l1);
         pan.add(lb);
        pan.add(tf);
       pan.add(lb1);
          pan.add(tf1);
           pan.add(lb2);
           pan.add(tf2);
            pan.add(lb3);
            pan.add(tf3);
            pan.add(bt);
            pan.add(bt1);
             add(pan);
             //add
             bt.addActionListener(new  ActionListener  (){
public void actionPerformed(ActionEvent  e) {
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("loaded");
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/samplebook","root","tiger");
     System.out.println("conected");
     Statement st=con.createStatement();
     
   st.executeUpdate("insert into student values('"+tf.getText().trim()+"','"+tf1.getText().trim()+"','"+tf2.getText().trim()+"','"+tf3.getText().trim()+"')");
    JOptionPane.showMessageDialog(null,"added successfully");
    } catch (ClassNotFoundException ex) {
        
        Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
    } 
}
});
//clear
    bt1.addActionListener(new  ActionListener  (){
public void actionPerformed(ActionEvent  e) {
tf.setText("");
tf1.setText("");
tf2.setText("");
tf3.setText("");
}
});

        
        
        
    }

    
    public static void main(String[] args) {
        Registration rf=new Registration();
          rf.setVisible(true);
        rf.setLocationRelativeTo(null);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rf.setTitle("addition");
        rf.setSize(300, 200);
 
    }
    
}