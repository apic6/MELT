/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mbaxkak4
 */
public class Viewer extends JFrame {

  

    
     public Viewer (Modeller model) {      //constructor
         
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
         Welcome wel=new Welcome(this,model);
         setContentPane(wel);
         pack();
         setVisible(true);
      
}
  
     
     
    public void guiChanger(JPanel NewPanel){
             setContentPane(NewPanel);
             pack();
             setVisible(true);}
     
     
     
     
     public void addListener(ActionListener mal) {
         //(Welcome.teacherButton).addActionListener(mal);
         (LoginScreen.loginButton).addActionListener(mal);
    }
     
    
     
    
}