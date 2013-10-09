/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Daniel
 */
public class Subsection extends JPanel{
    private JButton createQuestion;
    private JTabbedPane questionPane;
    
    Subsection(){
        initComponents();
    }

    private void initComponents() {
        createQuestion = new JButton("Add Question");
        createQuestion.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                (new QuestionCreater()).setVisible(true);
            }
            
        });
        
        add(createQuestion);
    }
    
    
}
