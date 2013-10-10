/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Section;
import Model.SubSection;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Daniel
 */
public class Subsection extends JPanel{
    private JButton createQuestion;
    private JPanel mainPane;
    public SubSection subSection;
    GridBagConstraints gbc = new GridBagConstraints();
    Section section;
    Subsection(Section section){
        this.section = section;
        mainPane = this;
        subSection = new SubSection();
        section.AddSubSection(subSection);
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        createQuestion = new JButton("Add Question");
        createQuestion.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                (new QuestionCreator(mainPane,gbc,subSection)).setVisible(true);
            }
            
        });
        
        add(createQuestion,gbc);
    }
    
    
}
