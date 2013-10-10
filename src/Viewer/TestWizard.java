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
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author mbaxkmt6
 */
public class TestWizard extends JPanel{
    public JFrame mainFrame;
    public Modeller model;
    public JTabbedPane tabs;
    public static QuestionPaper paper;
    public static JButton submit=new JButton("finish");
    ArrayList<TestSection> sectionList;
    public TestWizard(JFrame frame,Modeller model,JTabbedPane tabs){
        this.model = model;
        mainFrame = frame;
        this.tabs = tabs;
        sectionList = new ArrayList();
        paper = new QuestionPaper(123456);
        initComponents();
    
}

    private void initComponents() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.weightx = 1.0;
        con.weighty = 1.0;
        con.gridwidth = GridBagConstraints.REMAINDER;
        con.fill = GridBagConstraints.BOTH;
        if(tabs!=null){
            add(tabs,con);
        }
        else{
        tabs = new JTabbedPane();
        JPanel tab1 = new JPanel();
        tab1.setLayout(new GridBagLayout());
        tab1.setPreferredSize(new Dimension(500,500));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        
        tab1.add(new TestSection(mainFrame,model,paper,sectionList),c);
        tabs.addTab("section"+ (tabs.getTabCount()+1), tab1);
        add(tabs,con);
        }
        
        JButton addSection = new JButton("addSection");
        addSection.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPanel tab3 = new JPanel();
            tab3.setLayout(new GridBagLayout());
            tab3.setPreferredSize(new Dimension(500,500));
            GridBagConstraints c2 = new GridBagConstraints();
            c2.gridx = 0;
            c2.gridy = 0;
            c2.weightx = 1.0;
            c2.weighty = 1.0;
            c2.fill = GridBagConstraints.BOTH;
            tab3.add(new TestSection(mainFrame,model,paper,sectionList),c2);
            tabs.addTab("section"+ (tabs.getTabCount()+1),tab3);
            tabs.revalidate();
            }
        });
        con.gridx = 0;
        con.gridy = 1;
        con.weighty = 0;
        con.gridwidth = 1;
        add(addSection,con);
        
        //JButton submit = new JButton("finish");
        //submit.setText("finish");
        submit.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < sectionList.size(); i++){
                    paper.SetTitle(("Test test"));
                    paper.SetDescription("Test Description");
                    paper.SetInstructions("Test instructions");
                    sectionList.get(i).section.SetTitle(sectionList.get(i).getTitle());
                    sectionList.get(i).section.SetDescription(sectionList.get(i).getDescription());
                    sectionList.get(i).section.SetInstructions(sectionList.get(i).getInstruction());
                }
                System.out.print(paper.toXML(model));
                model.addPaper(paper);
                try {
                    model.savePapers("src/PapersTest.xml");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TestWizard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    });
        con.gridx = 1;
        add(submit,con);
    }
    
    public static  QuestionPaper getQuestionPaper(){
    QuestionPaper qp=new QuestionPaper(123456);
    qp=paper;
    return paper;
    }

}