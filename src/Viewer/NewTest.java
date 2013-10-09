/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author aris
 */
public class NewTest extends JPanel {
    private Modeller amodel;
    private JFrame mainFrame;   
    
    public  NewTest(JFrame frame,Modeller model) {
    mainFrame=frame;
    amodel=model;
    initComponents();
    }
    
    void initComponents(){
        
        JLabel title=new JLabel();
        title.setText("Welcome to the Test Creation Wizard");
        
        JLabel testTitleLabel=new JLabel();
        testTitleLabel.setText("Please type the title of the Test");
        
        JTextArea testTitle=new JTextArea();
        
        JLabel testTimeLabel=new JLabel();
        testTimeLabel.setText("Please type the duration of the Test");
        
        JTextArea testTime=new JTextArea();
        
        
        
    }
    
}
