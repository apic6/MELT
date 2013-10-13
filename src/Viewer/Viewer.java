/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;

/**
 *
 * @author mbaxkak4
 */
public class Viewer extends JFrame {

  

    
     public Viewer (Modeller model) {      //constructor
         
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         this.setSize(new Dimension(1100,800));
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
         Welcome wel=new Welcome(this,model);
         setContentPane(wel);
         setVisible(true);
      
}
  
     
     
    public void guiChanger(JPanel NewPanel){
             setContentPane(NewPanel);
             //pack();
             setVisible(true);}
     
     
     
     
     public void addListener(ActionListener mal,DocumentListener doc,FocusListener foc) {
          //(Welcome.teacherButton).addActionListener(mal);
          //(LoginScreen.loginButton).addActionListener(mal);
         (TestWizard.submit).addActionListener(mal);
          //  (QuestionCreator.title).getDocument().addDocumentListener(doc);
         (LoginScreen.userIDText).addFocusListener(foc);
         
    }
     
    
     
    
}