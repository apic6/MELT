/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.Question;
import Model.QuestionPaper;
import Model.MultipleChoiceQuestion;
import Model.Section;
import Model.SubSection;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.TabbedPaneUI;

/**
 *
 * @author Daniel
 */
public class Subsection extends JPanel{
    private JButton createQuestion;
    private JPanel mainPane;
    public int firstI  ;
    public int lastI  ;
    public int index ;
    
    public Modeller amodel;
    public SubSection subSection;
    private JPanel rightPanel;
    private QuestionPaper paper ;
    GridBagConstraints gbc = new GridBagConstraints();
    Section section;
    private DefaultListModel listModel;
    private TestWizard wizard;
    Subsection(Section section, Modeller model, QuestionPaper paper, TestWizard wizard){
        this.paper = paper ;
        this.section = section;
        mainPane = this;
        amodel = model;
        subSection = new SubSection();
        section.AddSubSection(subSection);
        this.rightPanel = rightPanel;
        this.wizard = wizard;
        initComponents();
    }

    private void initComponents() {
        
        
        
        //need for list listener
        firstI = -1 ;
        lastI = -1 ;
        index = -1 ;
        
        setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START ;      
        gbc.weightx = 1 ;
        gbc.weighty = 1 ;
        gbc.fill = GridBagConstraints.BOTH ;
        JList questionList = new JList() ;
        questionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        questionList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        //questionList.setVisibleRowCount(-1) ;
        
        
        
        listModel = new DefaultListModel();
        
        /*
        amodel.loadPapers("papers/Papers.xml");
        ArrayList<QuestionPaper> papers = amodel.getPapersByStudentID(12301230);
*/
        
        final Question[] questions;
        QuestionView[] questionViews;
        
        //QuestionPaper paper = papers.get(0);
        
        final Section section = paper.getSection(0);
        SubSection subSection = section.getSubSection(0);
        
        String[] Answers = new String[2];
        Answers[0] = "hsdfbdsjhfb";
        Answers[1] = "sdkjgfmldgm";
        int [] possibleAnswers = new int[2] ;
        possibleAnswers[0] = 0 ;
        possibleAnswers[1] = 1 ;
        
        listModel.addElement("New question");        
        
        MultipleChoiceQuestion a ;
        a = new MultipleChoiceQuestion("rololol", Answers, "what", possibleAnswers, 5);
        
        subSection.addQuestion(a);
        
        questions = new Question[subSection.getNumberOfQuestions()];
        questionViews = new QuestionView[questions.length];

        for (int i = 0; i < subSection.getNumberOfQuestions(); i++) {
            questions[i] = subSection.getQuestion(i);
            questionViews[i] = new QuestionView(questions[i]);
            listModel.addElement(questions[i].getQuestion());
            
        }
        
        /*
        listModel = new DefaultListModel();
        listModel.addElement("New question");
        listModel.addElement("asdsadsadasd");
        listModel.addElement("xcvcxvcxvcxvxc");
        listModel.addElement("asdsadsadasd");
        listModel.addElement("xcvcxvcxvcxvxc");
        listModel.addElement("asdsadsadasd");
        listModel.addElement("xcvcxvcxvcxvxc");
        listModel.addElement("asdsadsadasd");
        listModel.addElement("xcvcxvcxvcxvxc");
        listModel.addElement("asdsadsadasd");
        listModel.addElement("xcvcxvcxvcxvxc");
        listModel.addElement("asdsadsadasd");
        listModel.addElement("xcvcxvcxvcxvxc");
        */
        
        questionList = new JList(listModel) ;
        
        JScrollPane listScroller = new JScrollPane(questionList);
        add(listScroller, gbc) ;
        
        gbc.gridy = 1 ;
        /*
        createQuestion = new JButton("Add Question");
        createQuestion.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                (new QuestionCreator(mainPane,gbc,subSection)).setVisible(true);
            }
            
        });
        
        * 
        add(createQuestion,gbc);
        * */
        
       
        
        questionList.addListSelectionListener(new ListSelectionListener() {
            
            
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()){
                
                }else{
                System.out.print("\n_First:" + evt.getFirstIndex()  + "_\n");
                System.out.print("_Last:" + evt.getLastIndex()  + "_\n");
                
                int firstLower = 0 ;
                int newIndex = -1 ;
                
                if (firstI == -1 ||lastI == -1)
                {
                    firstI = evt.getFirstIndex() ;
                    lastI = evt.getLastIndex() ;
                    index = firstI ;
                }
                else
                {
              
                if (firstI != evt.getFirstIndex())
                {
                    if (firstI < evt.getFirstIndex())
                        firstLower = 1 ;
                    else
                        firstLower = 0 ;
                    firstI = evt.getFirstIndex() ;
                    newIndex = firstI ;
                    
                }
                 if (lastI != evt.getLastIndex())
                {
                    lastI = evt.getLastIndex() ;
                    newIndex = lastI ;
                }
               // if index == last and first < index
                if (index == lastI && firstLower == 1)
                    newIndex = firstI ;
                
                if (newIndex == -1)
                    if (index == firstI)
                        newIndex = lastI ;
                    else if (index == lastI)
                        newIndex = firstI ;
                index = newIndex ;
                }
                
                System.out.print(index);
//                GridBagConstraints gbc = new GridBagConstraints();
//                gbc.gridx = 0;
//                gbc.gridy = 0;
//                gbc.weighty = 1.0;
//                gbc.fill = GridBagConstraints.HORIZONTAL;
//                gbc.anchor = GridBagConstraints.NORTH;
//                rightPanel.removeAll();
//                rightPanel.revalidate();
//                rightPanel.setLayout(new GridBagLayout());
//                rightPanel.setBorder(new TitledBorder("SubSection information"));
                if (index != 0 && index != -1) 
                    wizard.repainRightPanel("SubSection information", new SubsectionEditor(section.getSubSection(0), questions[index - 1],wizard));
                else 
                   wizard.repainRightPanel("SubSection information", new SubsectionEditor(section.getSubSection(0),wizard));
//
//                rightPanel.add(new SubsectionEditor(section.getSubSection(0)),gbc);
//                
//                rightPanel.revalidate();
//                rightPanel.repaint();
                
                
                
            }}
        
        
    });
    }
    class Foc implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
         
         
         
        }

        @Override
        public void focusLost(FocusEvent e) {
            
        }
    }
    
}
