package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Daniel
 */
public class Student extends JPanel{
    
    public JFrame mainFrame;
    public Modeller amodel;
    public Student(JFrame frame,Modeller model){
        amodel = model;
        mainFrame = frame;
        initComponents();
    }
    
    private JPanel leftPanel;
    private JPanel rightPanel;
    
    private void initComponents() {
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.weightx = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.weighty = 1.0;
        c.ipadx = 10;
        c.ipady = 10;
        c.insets = new Insets(10, 10, 0, 0);
        leftPanel.setBorder(new TitledBorder("My avaliable tests"));
        add(leftPanel,c);
        
        c.weightx = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.weighty = 1.0;
        c.ipadx = 10;
        c.ipady = 10;
        c.insets = new Insets(10, 0, 0, 10);
        rightPanel.setBorder(new TitledBorder("My previous taken tests"));
        add(rightPanel,c);
        
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.weightx = 1.0;
        c1.weighty = 0;
        
        
        
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.weightx = 1.0;
        c2.weighty = 0;
        c2.gridy = 0;
//        rightPanel.add(new PaperPreviewer(),c2);
        c2.gridy = 1;
//        rightPanel.add(new PaperPreviewer(),c2);
        c2.gridy = 2;
        c2.weighty = 1.0;
        c2.anchor = GridBagConstraints.NORTH;
        amodel.loadPapers("src/Papers.xml");
        ArrayList<QuestionPaper> papers = amodel.getPapersByStudentID(12301230);
        for(int i=0;i<papers.size();++i){
            c1.gridy = i;
        leftPanel.add(new PaperPreviewer(papers.get(i)),c2);
        }
//        rightPanel.add(new PaperPreviewer(),c2);
        
    }
    
}
