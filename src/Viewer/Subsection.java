/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Section;
import Model.SubSection;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Daniel
 */
public class Subsection extends JPanel{
    private JButton createQuestion;
    private JPanel mainPane;
    public SubSection subSection;
    GridBagConstraints gbc = new GridBagConstraints();
    Section section;
    private DefaultListModel listModel;
    private JList questionList = new JList() ;
    Subsection(Section section){
        this.section = section;
        mainPane = this;
        subSection = new SubSection();
        section.AddSubSection(subSection);
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START ;      
        gbc.weightx = 1 ;
        gbc.weighty = 1 ;
        gbc.fill = GridBagConstraints.BOTH ;
        //JList questionList = new JList() ;
        questionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        questionList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        //questionList.setVisibleRowCount(-1) ;
        
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
        
        questionList = new JList(listModel) ;
        questionList.setSelectedIndex(0);
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
        
        add(createQuestion,gbc);
        * */
    }
   
    
}
