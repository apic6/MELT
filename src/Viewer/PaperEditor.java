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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private TestWizard wizard;
    public PaperEditor(QuestionPaper paper, TestWizard wizard){
        title.setText(paper.getTitle());
        description.setText(paper.getDescription());
        instruction.setText(paper.getInstructions());
        sections = paper.getSectionList();
        this.paper = paper;
        this.wizard = wizard;
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
        
        JPanel sectionPanel = new JPanel();
        sectionPanel.setBorder(new TitledBorder("Sections"));
        gbc.gridy++;
        add(sectionPanel,gbc);
            
            sectionPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc3 = new GridBagConstraints();
            gbc3.fill = GridBagConstraints.HORIZONTAL;
            gbc3.insets = new Insets(10,10,10,10);
            gbc3.gridx = 0;
            gbc3.gridy = 0;
            
            for(int i = 0; i < paper.getNumberOfSections(); ++i){
                JLabel subTitleLabel = new JLabel("Section"+(i+1)+":  "+paper.getSectionList().get(i).getTitle());
                sectionPanel.add(subTitleLabel,gbc3);
                JButton moveUp = new JButton("UP");
                final int pos = i;
                moveUp.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(pos>0){
                        paper.getSectionList().add(pos-1,paper.getSectionList().remove(pos));
                        JPanel tab_temp = (JPanel)wizard.tabs.getComponentAt(pos);
                        wizard.tabs.remove(pos);
                        wizard.tabs.insertTab(paper.getSection(pos-1).getTitle(), null, tab_temp, null, pos-1);
                        wizard.repainRightPanel("QuestionPaper information", new PaperEditor(paper,wizard));
                        }
                    }
                });
                JButton moveDown = new JButton("DOWN");
                moveDown.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(pos<(paper.getNumberOfSections()-1)){
                        paper.getSectionList().add(pos+1,paper.getSectionList().remove(pos));
                        JPanel tab_temp = (JPanel)wizard.tabs.getComponentAt(pos);
                        wizard.tabs.remove(pos);
                        wizard.tabs.insertTab(paper.getSection(pos+1).getTitle(), null, tab_temp, null, pos+1);
                        wizard.repainRightPanel("SubSection information", new PaperEditor(paper,wizard));
                        }
                    }
                });
                gbc3.gridx++;
                sectionPanel.add(moveUp,gbc3);
                gbc3.gridx++;
                sectionPanel.add(moveDown,gbc3);
                
                gbc3.gridy++;
                gbc3.gridx = 0;
            }
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(sectionPanel,gbc);
    }
}
