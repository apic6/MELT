/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Section;
import Model.SubSection;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
    private Section section;
    
    public SectionEditor (Section section){
        title.setText(section.getTitle());
        description.setText(section.getDescription());
        instruction.setText(section.getInstructions());
        timeLimit.setText(String.valueOf(section.getTimeLimit()));
        this.section = section;
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
        
        title.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                section.setTitle(title.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                section.setTitle(title.getText());}

            @Override
            public void changedUpdate(DocumentEvent e) {
                section.setTitle(title.getText());
            }
    });
        
        gbc.weightx = 0.3;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(description_label,gbc);
        
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        add(description,gbc);
        
        description.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                section.setDescription(description.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                section.setDescription(description.getText());}

            @Override
            public void changedUpdate(DocumentEvent e) {
                section.setDescription(description.getText());
            }
    });
        gbc.weightx = 0.3;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(instruction_label,gbc);
        
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        add(instruction,gbc);
        
        instruction.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                section.setInstructions(instruction.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                section.setInstructions(instruction.getText());}

            @Override
            public void changedUpdate(DocumentEvent e) {
                section.setInstructions(instruction.getText());
            }
    });
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        add(time_label,gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        add(timeLimit,gbc);
        
        timeLimit.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                section.setTimeLimit(Integer.parseInt(timeLimit.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                section.setTimeLimit(Integer.parseInt(timeLimit.getText()));
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                section.setTimeLimit(Integer.parseInt(timeLimit.getText()));
            }
    });
        
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
            
            subsectionPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc3 = new GridBagConstraints();
            gbc3.fill = GridBagConstraints.HORIZONTAL;
            gbc3.insets = new Insets(10,10,10,10);
            gbc3.gridx = 0;
            gbc3.gridy = 0;
            
            for(int i = 0; i < section.getNumberOfSubSections(); ++i){
                JLabel subTitleLabel = new JLabel("SubSection"+(i+1)+":  "+section.getSubSections().get(i).getTitle());
                subsectionPanel.add(subTitleLabel,gbc3);
                JButton moveUp = new JButton("UP");
                JButton moveDown = new JButton("DOWN");
                gbc3.gridx++;
                subsectionPanel.add(moveUp,gbc3);
                gbc3.gridx++;
                subsectionPanel.add(moveDown,gbc3);
                
                gbc3.gridy++;
                gbc3.gridx = 0;
            }
        
            
    }
}
