/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.QuestionPaper;
import Model.Section;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
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
public class PaperEditor extends JPanel{
    private JLabel title_label = new JLabel("title:");
    private JTextArea title = new JTextArea(1,30);
    private JLabel description_label = new JLabel("description:");
    private JTextArea description = new JTextArea(3,30);
    private JLabel instruction_label = new JLabel("instruction:");
    private JTextArea instruction = new JTextArea(3,30);
    private JPanel sections_panel = new JPanel();
    private ArrayList<Section> sections;
    private QuestionPaper paper;
    public PaperEditor(QuestionPaper paper){
        title.setText(paper.getTitle());
        description.setText(paper.getDescription());
        instruction.setText(paper.getInstructions());
        sections = paper.getSectionList();
        this.paper = paper;
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
        gbc.insets = new Insets(5,0,0,0) ;
        
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        add(title,gbc);
        
        title.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                paper.setTitle(title.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                paper.setTitle(title.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                paper.setTitle(title.getText());
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
                paper.setDescription(description.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                paper.setDescription(description.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                paper.setDescription(description.getText());
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
                paper.setInstructions(instruction.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                paper.setInstructions(instruction.getText());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                paper.setInstructions(instruction.getText());
            }
    });
        
        sections_panel.setBorder(new TitledBorder("sections"));
        sections_panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        int section_num = 0;
        for(Section one : sections){
            JLabel sec_label = new JLabel("Section "+ (++section_num));
            sections_panel.add(sec_label,gbc2);
            gbc2.gridx = 1;
            JLabel sec_title = new JLabel(one.getTitle());
            sections_panel.add(sec_title,gbc2);
            gbc2.gridx = 2;
            JButton edit_section = new JButton("Edit");
            sections_panel.add(edit_section,gbc2);
            gbc2.gridx = 0;
            gbc2.gridy++;
        }
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(sections_panel,gbc);
    }
}
