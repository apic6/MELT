/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.QuestionPaper;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Daniel
 */
public class PaperEditor extends JPanel{
    private JLabel title_label = new JLabel("title:");
    private JTextArea title = new JTextArea(1,30);
    private JLabel description_label = new JLabel("description:");
    private JTextArea description = new JTextArea(3,30);
    private JLabel instruction_label = new JLabel("instruction:");
    private JTextArea instruction = new JTextArea(3,30);
    
    
    public PaperEditor(QuestionPaper paper){
        title.setText(paper.GetTitle());
        description.setText(paper.GetDescription());
        instruction.setText(paper.GetInstructions());
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.3;
        gbc.weighty = 0.3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(title_label,gbc);
        
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        add(title,gbc);
        
        gbc.weightx = 0.3;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(description_label,gbc);
        
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        add(description,gbc);
        
        gbc.weightx = 0.3;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(instruction_label,gbc);
        
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        add(instruction,gbc);
    }
}
