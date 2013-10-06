/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mbaxkak4
 */
public class Viewer extends JFrame {
    
     private JButton    testButton = new JButton("test");
     private JButton    testButton2 = new JButton("test2");
     
     
     public Viewer (Modeller model) {      //constructor
         
        JPanel content = new JPanel();
        content.setSize(400,400);
        
        content.add(new JLabel("Input"));
        
        content.add(testButton);
        content.add(testButton2);
        this.setContentPane(content);
        this.pack();
        
        this.setTitle("testing");
        Welcome welcome=new Welcome();
        welcome.setVisible(true);
     
}
     
     public void addListener(ActionListener mal) {
        testButton.addActionListener(mal);
        testButton2.addActionListener(mal);
    }
     
    
     
    
}