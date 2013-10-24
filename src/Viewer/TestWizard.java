/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Viewer.PaperViews.PaperView;
import Model.Modeller;
import Model.questionPaper.QuestionPaper;
import Model.questionPaper.MultipleChoiceQuestion;
import Model.questionPaper.SubSection;
import static Viewer.TestWizard.paper;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.TabbedPaneUI;

/**
 *
 * @author mbaxkmt6
 */
public class TestWizard extends JPanel{
    public static JFrame mainFrame;
    public Modeller model;
    public JTabbedPane tabs;
     ArrayList<JTextArea> answerAreas;
    public static QuestionPaper paper;
    public  JButton submit=new JButton("finish");
    ArrayList<TestSection> sectionList;
    private JTabbedPane questionType;
    private JPanel MCQ;
    private static JPanel rightPanel = new JPanel();
    SubSection subSection;
    MultipleChoiceQuestion question;
    private JPanel answerPanel;
    GridBagConstraints apc = new GridBagConstraints();
    private JPanel FIBQ;
    final JPanel questionCreator = new JPanel() ;
    public TestWizard wizard;
    
    ///New Test Constructor
    public TestWizard(JFrame frame,Modeller model){
        this.model = model;
        mainFrame = frame;
        
        sectionList = new ArrayList();
        int ID=model.getNextID();
        paper = new QuestionPaper(ID);
        wizard = this;
        initComponents();
        
        answerAreas = new ArrayList();
    
}
    
    //Edit an old Test Constructor
   public TestWizard(JFrame frame,Modeller model,QuestionPaper apaper){
   this.model=model;
   mainFrame=frame;
   paper=apaper;
   sectionList=new ArrayList();
   wizard=this;
   initComponents();
   
   answerAreas= new ArrayList();
   }

   
   
    private void initComponents() {
        
        setBorder(new TitledBorder("New QuestionPaper"));
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.weightx = 1.0;
        con.weighty = 1.0;
        
        con.fill = GridBagConstraints.BOTH;
        tabs = new JTabbedPane();
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        
        
        
        
        leftPanel.add(tabs,con);
        
        JButton addSection = new JButton("addSection");
        addSection.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPanel tab3 = new JPanel();
            tab3.setLayout(new GridBagLayout());
            GridBagConstraints c2 = new GridBagConstraints();
            c2.gridx = 0;
            c2.gridy = 0;
            c2.weightx = 1.0;
            c2.weighty = 1.0;
            c2.fill = GridBagConstraints.BOTH;
            tab3.add(new TestSection(model,paper,sectionList,wizard),c2);
            
            tabs.addTab("section"+ (tabs.getTabCount()+1),tab3);
            tabs.setSelectedIndex(tabs.getTabCount()-1);
            tabs.revalidate();
            repainRightPanel("Section informtion",new SectionEditor(paper.getSection(paper.getNumberOfSections()-1),wizard,(JPanel)tabs.getSelectedComponent()));
            }
        });
        
        tabs.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int tabNr = ((TabbedPaneUI)tabs.getUI()).tabForCoordinate(tabs, e.getX(), e.getY());
                
                if(tabNr > -1){
                    repainRightPanel("Section informtion",new SectionEditor(paper.getSection(tabNr),wizard,(JPanel)tabs.getSelectedComponent()));}
                else{
                    repainRightPanel("QuestionPaper informtion",new PaperEditor(paper,wizard));
                }
            }
        });
        con.gridx = 0;
        con.gridy = 1;
        con.weightx = 1.0;
        con.weighty = 0;
        con.gridwidth = 1;
        leftPanel.add(addSection,con);
        
        con.gridy = 0;
        con.weightx = 0;
        con.weighty = 0;
        leftPanel.setPreferredSize(new Dimension(480,720));
        add(leftPanel,con);
        
        submit.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < sectionList.size(); i++){
                    paper.setTitle(("Test test"));
                    paper.setDescription("Test Description");
                    paper.setInstructions("Test instructions");
                    sectionList.get(i).section.setTitle(sectionList.get(i).getTitle());
                    sectionList.get(i).section.setDescription(sectionList.get(i).getDescription());
                    sectionList.get(i).section.setInstructions(sectionList.get(i).getInstruction());
                }
            }
    });
        rightPanel.setBorder(new TitledBorder("QuestionPaper information"));
        con.gridx = 1;
        con.gridy = 0;
        con.weightx = 0;
        con.weighty = 0;
        rightPanel.setPreferredSize(new Dimension(600,700));
        add(rightPanel,con);
        
        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc_right = new GridBagConstraints();
        gbc_right.fill = GridBagConstraints.HORIZONTAL;
        gbc_right.anchor = GridBagConstraints.NORTH ;
        gbc_right.insets = new Insets(10,0,0,0) ;
        gbc_right.gridx = 0;
        gbc_right.gridy = 0;
        gbc_right.weighty = 0.2;
        rightPanel.add(new PaperEditor(paper,wizard),gbc_right);
        
        
        
        JButton editButton=new JButton("Preview Test");
            editButton.addActionListener(new ActionListener(){
              @Override
           public void actionPerformed(ActionEvent evt){
           JFrame some=new JFrame();
           some.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           some.setSize(new Dimension(1100,800));
           some.setContentPane(new PaperView(paper, some, null,null, -1));
           some.setVisible(true);}
        
        });
            GridBagConstraints c4=new GridBagConstraints();
            c4.anchor=GridBagConstraints.LAST_LINE_END;
//            c4.ipady=10;
//            c4.insets = new Insets(31,31,31,31);
            c4.gridx = 1 ;
            c4.gridy = 1 ;
           // c4.anchor=GridBagConstraints.EAST;
            add(editButton,c4);

    }
    
    public static  QuestionPaper getQuestionPaper(){
    QuestionPaper qp;
    qp=paper;
    return paper;
    }
    
    public void repainRightPanel(String title,JPanel editor){
        GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weighty = 1.0;
                gbc.weightx = 1.0;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.anchor = GridBagConstraints.NORTH;
                rightPanel.removeAll();
                rightPanel.setLayout(new GridBagLayout());
                rightPanel.setBorder(new TitledBorder(title));
                rightPanel.add(editor,gbc);
                rightPanel.revalidate();
                rightPanel.repaint();
    }
    
    
 public static void addListener(MouseListener mouse){
 mainFrame.addMouseListener(mouse);
 rightPanel.addMouseListener(mouse);
 }

}
