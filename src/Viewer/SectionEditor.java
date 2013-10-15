/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Section;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Daniel
 */
public class SectionEditor extends JPanel{
    
    private JLabel title_label = new JLabel("title:");
    private JTextArea title = new JTextArea(1,30);
    private JLabel description_label = new JLabel("description:");
    private JTextArea description = new JTextArea(3,30);
    private JLabel instruction_label = new JLabel("instruction:");
    private JTextArea instruction = new JTextArea(3,30);
    private JLabel time_label = new JLabel("time limit:");
    private JTextArea timeLimit = new JTextArea(1,10);
    
    public SectionEditor (Section section){
        title.setText(section.getTitle());
        description.setText(section.getDescription());
        instruction.setText(section.getInstructions());
        timeLimit.setText(String.valueOf(section.getTimeLimit()));
        initComponents();
    }

    private void initComponents() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 0.3;
        gbc.weighty = 0.3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,5,5,10);
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
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        add(time_label,gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        add(timeLimit,gbc);
        
        JPanel positionPanel = new JPanel();
        positionPanel.setBorder(new TitledBorder("Position"));
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(positionPanel,gbc);
        
            JButton positionUp = new JButton("Up");
            JButton positionDown = new JButton("Down");
            positionPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc2 = new GridBagConstraints();
            gbc2.gridx = 0;
            gbc2.gridy = 0;
            gbc2.insets = new Insets(10,10,10,10);
            gbc2.ipadx = 10;
            gbc2.ipady = 10;
            gbc2.fill = GridBagConstraints.BOTH;
            positionPanel.add(positionUp,gbc2);
            gbc2.gridx = 1;
            positionPanel.add(positionDown,gbc2);
            
        JPanel subsectionPanel = new JPanel();
        subsectionPanel.setBorder(new TitledBorder("SubSections"));
        gbc.gridy++;
        add(subsectionPanel,gbc);
        
            
    }
}
