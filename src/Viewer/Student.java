package Viewer;

import Viewer.PaperViews.PaperView;
import Model.Modeller;
import Model.StudentSubmission.Submission;
import Model.questionPaper.QuestionPaper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Daniel
 */
class MarkedSubmission extends JPanel {

    MarkedSubmission(Submission sub, Modeller model) {
        QuestionPaper paper = model.getPaperByPaperID(sub.getPaperID());
        if (paper != null) {
            setLayout(new FlowLayout());
            JLabel title = new JLabel("Paper: " + paper.getTitle());

            JLabel mark = new JLabel("Marks: " + sub.getMark() + "/" + paper.getMaximumMark());
            add(title);
            add(mark);
        } else {
            System.out.println("Submission for paper that doesn't exist.");
        }
    }
}

public class Student extends JPanel {

    public String ID;
    public int intID;
    public JFrame mainFrame;
    public Modeller amodel;
    private static JButton startTrigger = new JButton("startTrigger");

    public Student(JFrame frame, Modeller model, String studentID) {
        amodel = model;
        mainFrame = frame;
        ID = studentID;
        intID = Integer.parseInt(ID);
        initComponents();
    }
    private JPanel leftPanel;
    private JPanel rightPanel;

    private void initComponents() {

        mainFrame.setTitle(ID);
        // mainFrame.setPreferredSize(new Dimension(700, 500));
        // mainFrame.setMinimumSize(mainFrame.getPreferredSize());


        leftPanel = new JPanel();
        rightPanel = new JPanel();


        Dimension dimensionH = new Dimension(mainFrame.getPreferredSize());
        dimensionH.height = dimensionH.height / 2;

        leftPanel.setMinimumSize(dimensionH);
        rightPanel.setMinimumSize(dimensionH);



        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        add(leftPanel, c);


        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = GridBagConstraints.REMAINDER;
        c.gridwidth = GridBagConstraints.REMAINDER;
        add(rightPanel, c);



        leftPanel.setLayout(new GridLayout(20, 0));
        leftPanel.setBorder(new TitledBorder("My avaliable tests"));
        rightPanel.setLayout(new GridLayout(20, 0));
        rightPanel.setBorder(new TitledBorder("My previous taken tests"));

        amodel.loadSubmissions();
        amodel.loadPapers();
        ArrayList<Submission> submissions = amodel.getMarkedSubmissionsByStudentID(intID);


        for (int i = 0; i < submissions.size(); i++) {
            JPanel panel = new MarkedSubmission(submissions.get(i), amodel);
            rightPanel.add(panel);
        }

        /////////setting the layout for each panel


        GridBagConstraints c1 = new GridBagConstraints();

        c1.fill = GridBagConstraints.BOTH;
        c1.weightx = 0.5;
        c1.weighty = 0.5;
        amodel.loadPapers("papers/Papers.xml");
        final ArrayList<QuestionPaper> papers = amodel.getPapersByStudentID(intID);
        for (int i = 0; i < papers.size(); ++i) {
            boolean bool = true;
            ArrayList<Submission> allsubs = amodel.getSubmissionsByStudentID(intID);
            for (int y = 0; y < allsubs.size(); y++) {
                if (allsubs.get(y).getPaperID() == papers.get(i).getPaperID()) {
                    bool = false;
                }
            }

            if (bool) {
                c1.gridy = i;

                c1.gridx = 1;

                leftPanel.add(new PaperPreviewer(papers.get(i)), c1);

                c1.gridx = 2;
                //  c1.gridy=i;
                c1.fill = GridBagConstraints.HORIZONTAL;
                c1.weighty = 0.1;   //request any extra vertical space

                //c1.gridwidth = 1;   //2 columns wide
                //c1.weightx=0.1;
                JButton startButton = new JButton("Start this Test");

                //startButton    



                final Student sView = this;
                // TODO remove
                final int j = i;
                startButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setContentPane(new PaperView(papers.get(j), mainFrame, sView, Integer.parseInt(ID)));
                        mainFrame.setVisible(true);
                        startTrigger.doClick();
                    }
                });

                startButton.setPreferredSize(new Dimension(50, 50));
                startButton.addActionListener(new StartListener());
                leftPanel.add(startButton, c1);
            }
        }
    }

    public class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1100, 800);
    }

    public void repopulateLeftPanel() {
        leftPanel.removeAll();
        
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.BOTH;
        c1.weightx = 0.5;
        c1.weighty = 0.5;
        final ArrayList<QuestionPaper> papers = amodel.getPapersByStudentID(intID);
        for (int i = 0; i < papers.size(); ++i) {
            boolean bool = true;
            ArrayList<Submission> allsubs = amodel.getSubmissionsByStudentID(intID);
            for (int y = 0; y < allsubs.size(); y++) {
                if (allsubs.get(y).getPaperID() == papers.get(i).getPaperID()) {
                    bool = false;
                }
            }

            if (bool) {
                c1.gridy = i;

                c1.gridx = 1;

                leftPanel.add(new PaperPreviewer(papers.get(i)), c1);

                c1.gridx = 2;
                //  c1.gridy=i;
                c1.fill = GridBagConstraints.HORIZONTAL;
                c1.weighty = 0.1;   //request any extra vertical space

                //c1.gridwidth = 1;   //2 columns wide
                //c1.weightx=0.1;
                JButton startButton = new JButton("Start this Test");

                //startButton    



                final Student sView = this;
                // TODO remove
                final int j = i;
                startButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setContentPane(new PaperView(papers.get(j), mainFrame, sView, Integer.parseInt(ID)));
                        mainFrame.setVisible(true);
                        startTrigger.doClick();
                    }
                });

                startButton.setPreferredSize(new Dimension(50, 50));
                startButton.addActionListener(new StartListener());
                leftPanel.add(startButton, c1);
            }
        }
        
        this.repaint();
        this.revalidate();
    }

    public JFrame getFrame() {
        return mainFrame;
    }

    public static void addListener(ActionListener mal) {
        startTrigger.addActionListener(mal);
    }
}
