/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import Model.Section;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import Viewer.TestWizard;
import static Viewer.TestWizard.paper;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.TabbedPaneUI;
/**
 *
 * @author mbaxkmt6
 */
public class TestSection extends JPanel{
    private JLabel title_label;
    private JLabel description_label;
    private JLabel instruction_label;
    private JTextArea title;
    private JTextArea description;
    private JTextArea instruction;
    private JTabbedPane subsections;
    public Section section;
    private TestWizard wizard;
    private JPanel rightPanel;
    public TestSection(JPanel rightPanel,QuestionPaper paper,ArrayList<TestSection> sectionList,TestWizard wizard){
        section = new Section();
        sectionList.add(this);
        paper.addSection(section);
        this.wizard = wizard;
        this.rightPanel = rightPanel;
        initComponents();
    }

    
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        
        con.gridx = 0;
        con.gridy = 0;
        con.weightx = 0.3;
        con.anchor = GridBagConstraints.NORTHWEST;
        
        subsections = new JTabbedPane();
        con.gridx = 0;
        con.weighty = 1.0;
        con.gridy = 0;
        con.weightx = 1.0;
        con.fill = GridBagConstraints.BOTH;
        con.gridwidth = GridBagConstraints.REMAINDER;
        add(subsections,con);
        
        subsections.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int tabNr = ((TabbedPaneUI)subsections.getUI()).tabForCoordinate(subsections, e.getX(), e.getY());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weighty = 1.0;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.anchor = GridBagConstraints.NORTH;
                rightPanel.removeAll();
                rightPanel.revalidate();
                rightPanel.setLayout(new GridBagLayout());
                rightPanel.setBorder(new TitledBorder("SubSection information"));
                rightPanel.add(new SubsectionEditor(section.getSubSection(tabNr)),gbc);
                rightPanel.revalidate();
                rightPanel.repaint();
            }
        });
        
        JButton addSubsection = new JButton("Add Subsection");
        
        addSubsection.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel subsection = new Subsection(section);
                subsections.addTab("subsection"+(subsections.getTabCount()+1),subsection );
                subsections.revalidate();
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weighty = 1.0;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.anchor = GridBagConstraints.NORTH;
                rightPanel.removeAll();
                rightPanel.revalidate();
                rightPanel.setLayout(new GridBagLayout());
                rightPanel.setBorder(new TitledBorder("SubSection information"));
                rightPanel.add(new SubsectionEditor(section.getSubSection(section.getNumberOfSubSections()-1)),gbc);
                rightPanel.revalidate();
                rightPanel.repaint();
            }
        });
        con.gridy = 1;
        con.weighty = 0;
        add(addSubsection,con);
    }
    
    public String getTitle(){
        return this.title.getText();
    }

    public String getDescription() {
        return this.description.getText();
    }
    
    public String getInstruction(){
        return this.instruction.getText();
    }
    class Foc implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
         wizard.questionCreatorSetVinsible();
         
         
        }

        @Override
        public void focusLost(FocusEvent e) {
            
        }
    }
}


