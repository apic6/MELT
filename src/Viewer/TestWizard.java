/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import Model.Section;
import java.util.ArrayList;
import Model.MultipleChoiceQuestion;
import Model.SubSection;
import static Viewer.QuestionCreator.title;
import static Viewer.TestWizard.paper;
import static Viewer.TestWizard.submit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author mbaxkmt6
 */
public class TestWizard extends JPanel{
    public JFrame mainFrame;
    public Modeller model;
    public JTabbedPane tabs;
     ArrayList<JTextArea> answerAreas;
    public static QuestionPaper paper;
    public static JButton submit=new JButton("finish");
    ArrayList<TestSection> sectionList;
    private JTabbedPane questionType;
    private JPanel MCQ;
    SubSection subSection;
    MultipleChoiceQuestion question;
    private JPanel answerPanel;
    GridBagConstraints apc = new GridBagConstraints();
    private JPanel FIBQ;
    public TestWizard(JFrame frame,Modeller model){
        this.model = model;
        mainFrame = frame;
        sectionList = new ArrayList();
        paper = new QuestionPaper(123456);
        initComponents();
        
        answerAreas = new ArrayList();
    
}

    private void initComponents() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.weightx = 1.0;
        con.weighty = 1.0;
        
        con.fill = GridBagConstraints.BOTH;
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
               // System.out.print(paper.toXML(model));
            }
    });
        con.gridx = 1;
        add(submit,con);
        
        final JPanel questionCreator = new JPanel() ;
        
        con.gridy = 0;
        con.weightx = 1.0;
        con.weighty = 1.0;
        con.gridx = 1 ;
        con.gridwidth = GridBagConstraints.REMAINDER;
        add(questionCreator, con) ;
        questionCreator.setLayout(new GridBagLayout());
        final GridBagConstraints c3 = new GridBagConstraints();
        
        //questionCreator.setBackground(Color.red);
        
        questionType = new JTabbedPane();
        MCQ = new JPanel();
        MCQ.setLayout(new GridBagLayout());
        c3.fill = GridBagConstraints.BOTH;
        c3.weightx = 0.3;
        c3.gridx = 0;
        c3.gridy = 0;
        JLabel title_label = new JLabel("title:  ");
        MCQ.add(title_label,c3);
        
        questionCreator.add(MCQ, c3) ;
        
        c3.gridx = 1;
        c3.weightx = 0.7;
        title = new JTextArea(1,20);
        MCQ.add(title,c3);
        
        JButton addAnswer = new JButton("add answer");
        c3.gridx = 2;
        c3.weightx = 0;
        MCQ.add(addAnswer,c3);
        
        answerPanel = new JPanel();
        c3.gridx = 0;
        c3.gridwidth = GridBagConstraints.REMAINDER;
        c3.gridy = 1;
        c3.weighty = 1.0;
        c3.weightx = 1.0;
        MCQ.add(answerPanel,c3);
        
        JButton submit = new JButton("submit");
        c3.gridx = 0;
        c3.gridy = 2;
        c3.weighty = 0.2;
        c3.ipady = 20 ;
        MCQ.add(submit,c3);
        
        answerPanel.setLayout(new GridBagLayout());
        apc.gridx = 0;
        apc.gridy = -1;
        
        addAnswer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apc.gridy++;
                apc.weightx = 1.0;
                answerPanel.add(addAnswer(apc.gridy+1),apc);
                answerPanel.revalidate();
            }
        
        });
        questionType.addTab("MCQ",MCQ);
        
        FIBQ = new JPanel();
        questionType.addTab("FIBQ",FIBQ);
        questionType.setPreferredSize(questionCreator.getSize());
        questionCreator.add(questionType, c3);
       
        //this.setPreferredSize(new Dimension(500,500));
        
    }
    
    public static  QuestionPaper getQuestionPaper(){
    QuestionPaper qp;
    qp=paper;
    return paper;
    }
public JPanel addAnswer(int num){
            JPanel tempPanel = new JPanel();
            JLabel answer_label = new JLabel("answer"+num);
            tempPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.weightx = 0.3;
            tempPanel.add(answer_label,gbc);
            JTextArea answer = new JTextArea(1,20);
            answerAreas.add(answer);
            gbc.gridx = 1;
            gbc.weightx = 0.7;
            tempPanel.add(answer,gbc);
            JCheckBox isRight = new JCheckBox("right answer");
            gbc.gridx = 2;
            tempPanel.add(isRight,gbc);
            return tempPanel;
        }
}