/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import static Viewer.Welcome.teacherButton;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mbaxkak4
 */
public class TeacherView extends JPanel {
    
    private JButton createTest;
    public JFrame mainFrame;
    public Modeller amodel;
    public TeacherView(JFrame frame,Modeller model){
        amodel = model;
        mainFrame = frame;
        initComponents();
    }
   
    public void initComponents()  {
    
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridy = 0;
        c.ipady = 50;
        c.weighty = 0;
        createTest.setText("Create a New Test");
        createTest.setPreferredSize(new Dimension(25, 25));
        createTest.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                  ((Viewer)mainFrame).guiChanger(new TestWizard(mainFrame,amodel));
            }
        });
        
        
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.weightx = 1;
        c1.weighty = 0;
        c1.gridx = GridBagConstraints.RELATIVE;
        c1.gridy = 1;
        c1.ipady = 30;
        c1.ipadx = 80;
        c1.anchor = GridBagConstraints.CENTER;
        c1.gridwidth = GridBagConstraints.REMAINDER;
        //add(welcomeLabel,c1);
        
        GridBagConstraints c2 = new GridBagConstraints();
        c2.anchor = GridBagConstraints.EAST;
        c2.gridx = 0;
        c2.gridy = 2;
        c2.ipadx = 20;
        c2.ipady = 20;
        c2.insets = new Insets(50, 0, 30, 20);
        c2.weightx = 0.5;
        //add(studentButton, c2);
        c2.insets = new Insets(50, 20, 30, 0);
        c2.anchor = GridBagConstraints.WEST;
        c2.gridx = 1;
        //add(teacherButton,c2);
    
    
    
    
    
    
    
    
    }
    
    
}
