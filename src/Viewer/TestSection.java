/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import Model.Section;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import static Viewer.TestWizard.paper;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
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
    public Modeller model;
    
   public TestSection(Modeller model,QuestionPaper paper,ArrayList<TestSection> sectionList,TestWizard wizard){
        this.model = model;
//        mainFrame = frame;
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
                if(tabNr > -1)
                wizard.repainRightPanel("SubSection information", new SubsectionEditor(section.getSubSection(tabNr),wizard,(Subsection)subsections.getComponentAt(tabNr)));
                else
                wizard.repainRightPanel("QuestionPaper information", new PaperEditor(paper,wizard));
            }
        });
        
        
        JButton addSubsection = new JButton("Add Subsection");
        
        addSubsection.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Subsection subsection = new Subsection(section,model,paper,wizard);
                subsections.addTab("subsection"+(subsections.getTabCount()+1),subsection );
                subsections.setSelectedIndex(subsections.getTabCount()-1);
                subsections.revalidate();
                wizard.repainRightPanel("SubSection information", new SubsectionEditor(section.getSubSection(section.getNumberOfSubSections()-1),wizard,subsection));
            }
        });
        
        JButton deleteSubsection = new JButton("Delete Subsection");
         deleteSubsection.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                subsections.remove(subsections.getSelectedComponent());
//                subsections.addTab("subsection"+(subsections.getTabCount()+1),subsection );
//                subsections.setSelectedIndex(subsections.getTabCount()-1);
                subsections.revalidate();
//                wizard.repainRightPanel("SubSection information", new SubsectionEditor(section.getSubSection(section.getNumberOfSubSections()-1),wizard,subsection));
            }
        });
        
        con.gridy = 1;
        con.weighty = 0;
        add(addSubsection,con);
        con.gridy++ ;
        
        add(deleteSubsection, con);
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
    
    public void addListeners(FocusListener foc){
    title.addFocusListener(foc);
    description.addFocusListener(foc);
    instruction.addFocusListener(foc);
    }
}


