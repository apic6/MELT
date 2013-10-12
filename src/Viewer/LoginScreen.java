/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author aris
 */
public class LoginScreen extends JPanel {
    
     public JFrame mainFrame;
     public static JButton loginButton=new JButton("login");
     public static JTextField userIDText = new JTextField(20);
     private static JPasswordField passwordText = new JPasswordField(20);
     private Modeller amodel;
     
     public LoginScreen (JFrame frame,Modeller model) {    //might not even need the frame
     mainFrame=frame;
     initComponents();
     amodel=model;
     }
    
    
    
 private void initComponents(){
                this.setLayout(null);

		JLabel userLabel = new JLabel("User ID");
		userLabel.setBounds(10, 10, 80, 25);
		this.add(userLabel);

		
		userIDText.setBounds(100, 10, 160, 25);
		this.add(userIDText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		this.add(passwordLabel);

		
		passwordText.setBounds(100, 40, 160, 25);
		this.add(passwordText);

		
                
                final JLabel accessDen=new JLabel("Wrong Password!Please try again or contact the teaching staff.");
                
		loginButton.setBounds(10, 80, 80, 25);
		this.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent Ev){
                    String pass=(passwordText.getText()).toString();
                if( "English".equals(pass)){
                         ((Viewer)mainFrame).guiChanger(new Student(mainFrame,amodel));   
                                } 
                else {
                          
                        }
                }
                });
                
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(180, 80, 80, 25);
		this.add(cancelButton);
                cancelButton.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     
                     ((Viewer)mainFrame).guiChanger(new Welcome(mainFrame,amodel));
                        }
                       });
                 JLabel label=new JLabel("Hint:English");
                  label.setBounds(10,120,80,25);
                  this.add(label);
 
 }
 

public static String getUsername(){
String login=userIDText.getText();
    return login; 
}
public static String getPass(){
char[] pass=passwordText.getPassword();
 return pass.toString();
}

}

    
    
    
    

