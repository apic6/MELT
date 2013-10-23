/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.questionPaper.FITBQuestion;
import Model.questionPaper.MultipleChoiceQuestion;
import Model.questionPaper.Question;
import Model.questionPaper.QuestionPaper;
import Model.questionPaper.Section;
import Model.questionPaper.SubSection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author mbgm8je3
 */
class sSectionPanel extends JPanel {

    sSectionPanel(Section s) {
        GridBagLayout layout = new GridBagLayout();
        //FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);

        GridBagConstraints con = new GridBagConstraints();

        setLayout(layout);

        con.gridx = 0;
        con.gridy = 0;

        con.anchor = GridBagConstraints.EAST;
        con.fill = GridBagConstraints.HORIZONTAL;

        con.weightx = 1.0;



        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JLabel title = new JLabel(s.getTitle());
        panel1.add(title);
        //add(title, con);

        //con.gridx = 1;
        JButton remove = new JButton("Remove");
        //add(remove, con);
        panel2.add(remove);

        //con.gridx = 2;
        JButton up = new JButton("Move Up");
        //add(up, con);
        panel2.add(up);

        //con.gridx = 3;
        JButton down = new JButton("Move Down");
        //add(down, con);
        panel2.add(down);

        add(panel1, con);
        con.gridx = 1;
        add(panel2, con);

        setBorder(new LineBorder(new Color(0, 0, 0)));
    }
}

class sSubSectionPanel extends JPanel {

    sSubSectionPanel(SubSection s) {
        GridBagLayout layout = new GridBagLayout();
        //FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);

        GridBagConstraints con = new GridBagConstraints();

        setLayout(layout);

        con.gridx = 0;
        con.gridy = 0;

        con.anchor = GridBagConstraints.EAST;
        con.fill = GridBagConstraints.HORIZONTAL;

        con.weightx = 1.0;



        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JLabel title = new JLabel(s.getTitle());
        panel1.add(title);
        //add(title, con);

        //con.gridx = 1;
        JButton remove = new JButton("Remove");
        //add(remove, con);
        panel2.add(remove);

        //con.gridx = 2;
        JButton up = new JButton("Move Up");
        //add(up, con);
        panel2.add(up);

        //con.gridx = 3;
        JButton down = new JButton("Move Down");
        //add(down, con);
        panel2.add(down);

        add(panel1, con);
        con.gridx = 1;
        add(panel2, con);

        setBorder(new LineBorder(new Color(0, 0, 0)));
    }
}

class sQuestionPanel extends JPanel {

    sQuestionPanel(Question q) {
        GridBagLayout layout = new GridBagLayout();
        //FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);

        GridBagConstraints con = new GridBagConstraints();

        setLayout(layout);

        con.gridx = 0;
        con.gridy = 0;

        con.anchor = GridBagConstraints.EAST;
        con.fill = GridBagConstraints.HORIZONTAL;

        con.weightx = 1.0;



        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        String question = q.getQuestion();
        if (question.length() > 40) {
            question = question.substring(0, 37);
            question = question.concat("...");
        }

        JLabel title = new JLabel(question);
        panel1.add(title);
        //add(title, con);

        //con.gridx = 1;
        JButton remove = new JButton("Remove");
        //add(remove, con);
        panel2.add(remove);

        //con.gridx = 2;
        JButton up = new JButton("Move Up");
        //add(up, con);
        panel2.add(up);

        //con.gridx = 3;
        JButton down = new JButton("Move Down");
        //add(down, con);
        panel2.add(down);

        add(panel1, con);
        con.gridx = 1;
        add(panel2, con);

        setBorder(new LineBorder(new Color(0, 0, 0)));
    }
}

public class RightPanel extends JPanel {

    public enum ViewMode {

        PaperEditor, SectionEditor, SubSectionEditor, MCQEditor, FITBEditor
    }

    RightPanel(QuestionPaper paper) {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints con = new GridBagConstraints();

        // con.anchor =  GridBagConstraints.LINE_START;
        con.insets = new Insets(5, 5, 5, 5);
        con.weightx = 0.5;
        con.fill = GridBagConstraints.HORIZONTAL;

        con.gridx = 0;
        con.gridy = 0;

        // con.fill = GridBagConstraints.VERTICAL;

        layout.setConstraints(this, con);

        // this.setBackground(new Color(255, 0, 0));
        this.setLayout(layout);

        JLabel title1 = new JLabel("Title: ");
        add(title1, con);

        con.gridx = 1;
        JTextArea title = new JTextArea(paper.getTitle());
        add(title, con);

        con.gridx = 0;
        con.gridy = 1;
        JLabel description1 = new JLabel("Description: ");
        add(description1, con);

        con.gridx = 1;
        JTextArea description = new JTextArea(5, 20);
        description.setText(paper.getDescription());
        JScrollPane descriptionScroll = new JScrollPane(description);
        add(descriptionScroll, con);


        con.gridx = 0;
        con.gridy = 2;
        JLabel instructions1 = new JLabel("Instructions: ");
        add(instructions1, con);

        con.gridx = 1;
        JTextArea instructions = new JTextArea(5, 20);
        instructions.setText(paper.getInstructions());
        JScrollPane instructionsScroll = new JScrollPane(instructions);
        add(instructionsScroll, con);

        con.gridx = 0;
        con.gridy = 3;
        JButton button = new JButton("Add Section");
        add(button, con);

        con.gridy = 4;
        // con.gridx = 0;
        con.weightx = 1.0;
        con.gridwidth = 2;

        JLabel ssTitle = new JLabel("Sections");
        add(ssTitle, con);

        con.gridy++;

        for (int i = 0; i < paper.getNumberOfSections(); i++) {
            add(new sSectionPanel(paper.getSection(i)), con);
            con.gridy++;
        }

        this.setPreferredSize(new Dimension(600, 800));
    }

    RightPanel(Section section) {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints con = new GridBagConstraints();

        // con.anchor =  GridBagConstraints.LINE_START;
        con.insets = new Insets(5, 5, 5, 5);
        con.weightx = 0.5;
        con.fill = GridBagConstraints.HORIZONTAL;

        con.gridx = 0;
        con.gridy = 0;

        // con.fill = GridBagConstraints.VERTICAL;

        layout.setConstraints(this, con);

        // this.setBackground(new Color(255, 0, 0));
        this.setLayout(layout);

        JLabel title1 = new JLabel("Title: ");
        add(title1, con);

        con.gridx = 1;
        JTextArea title = new JTextArea(section.getTitle());
        title.setBorder(new LineBorder(new Color(0, 0, 0)));
        add(title, con);

        con.gridx = 0;
        con.gridy = 1;
        JLabel description1 = new JLabel("Description: ");
        add(description1, con);

        con.gridx = 1;
        JTextArea description = new JTextArea(5, 20);
        description.setText(section.getDescription());
        description.setBorder(new LineBorder(new Color(0, 0, 0)));
        JScrollPane descriptionScroll = new JScrollPane(description);
        descriptionScroll.setBorder(null);
        add(descriptionScroll, con);


        con.gridx = 0;
        con.gridy = 2;
        JLabel instructions1 = new JLabel("Instructions: ");
        add(instructions1, con);

        con.gridx = 1;
        JTextArea instructions = new JTextArea(5, 20);
        instructions.setText(section.getInstructions());
        instructions.setBorder(new LineBorder(new Color(0, 0, 0)));
        JScrollPane instructionsScroll = new JScrollPane(instructions);
        instructionsScroll.setBorder(null);
        add(instructionsScroll, con);

        con.gridx = 0;
        con.gridy = 3;
        JLabel timeLimit1 = new JLabel("Time Limit: ");
        add(timeLimit1, con);

        con.gridx = 1;
        JTextArea timeLimit = new JTextArea(1, 20);
        instructions.setText(Integer.toString(section.getTimeLimit()));
        timeLimit.setBorder(new LineBorder(new Color(0, 0, 0)));
        add(timeLimit, con);

        con.gridx = 0;
        con.gridy = 4;
        JButton button = new JButton("Add SubSection");
        add(button, con);

        con.gridy = 5;
        con.gridx = 0;
        con.weightx = 1.0;
        con.gridwidth = 2;

        JLabel ssTitle = new JLabel("SubSections");
        add(ssTitle, con);

        con.gridy = 6;

        for (int i = 0; i < section.getNumberOfSubSections(); i++) {
            add(new sSubSectionPanel(section.getSubSection(i)), con);
            con.gridy++;
        }

        this.setPreferredSize(new Dimension(600, 800));
    }

    RightPanel(SubSection subSection) {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints con = new GridBagConstraints();

        // con.anchor =  GridBagConstraints.LINE_START;
        con.insets = new Insets(5, 5, 5, 5);
        con.weightx = 0.5;
        con.fill = GridBagConstraints.HORIZONTAL;

        con.gridx = 0;
        con.gridy = 0;

        // con.fill = GridBagConstraints.VERTICAL;

        layout.setConstraints(this, con);

        // this.setBackground(new Color(255, 0, 0));
        this.setLayout(layout);

        JLabel title1 = new JLabel("Title: ");
        add(title1, con);

        con.gridx = 1;
        JTextArea title = new JTextArea(subSection.getTitle());
        title.setBorder(new LineBorder(new Color(0, 0, 0)));
        add(title, con);

        con.gridx = 0;
        con.gridy = 1;
        JLabel description1 = new JLabel("Description: ");
        add(description1, con);

        con.gridx = 1;
        JTextArea description = new JTextArea(5, 20);
        description.setText(subSection.getDescription());
        description.setBorder(new LineBorder(new Color(0, 0, 0)));
        JScrollPane descriptionScroll = new JScrollPane(description);
        descriptionScroll.setBorder(null);
        add(descriptionScroll, con);


        con.gridx = 0;
        con.gridy = 2;
        JLabel instructions1 = new JLabel("Instructions: ");
        add(instructions1, con);

        con.gridx = 1;
        JTextArea instructions = new JTextArea(5, 20);
        instructions.setText(subSection.getInstructions());
        instructions.setBorder(new LineBorder(new Color(0, 0, 0)));
        JScrollPane instructionsScroll = new JScrollPane(instructions);
        instructionsScroll.setBorder(null);
        add(instructionsScroll, con);

        con.gridx = 0;
        con.gridy = 3;
        JButton button = new JButton("Add Question");
        add(button, con);

        con.gridy = 4;
        con.gridx = 0;
        con.weightx = 1.0;
        con.gridwidth = 2;

        JLabel ssTitle = new JLabel("Questions");
        add(ssTitle, con);

        con.gridy = 5;

        for (int i = 0; i < subSection.getNumberOfQuestions(); i++) {
            add(new sQuestionPanel(subSection.getQuestion(i)), con);
            con.gridy++;
        }

        this.setPreferredSize(new Dimension(600, 800));
    }

    public RightPanel(Question question) {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints con = new GridBagConstraints();

        // con.anchor =  GridBagConstraints.LINE_START;
        con.insets = new Insets(5, 5, 5, 5);
        con.weightx = 0.5;
        con.fill = GridBagConstraints.HORIZONTAL;

        con.gridx = 0;
        con.gridy = 0;

        // con.fill = GridBagConstraints.VERTICAL;

        layout.setConstraints(this, con);

        // this.setBackground(new Color(255, 0, 0));
        this.setLayout(layout);

        JLabel title1 = new JLabel("Question: ");
        add(title1, con);

        con.gridx = 1;
        JTextArea title = new JTextArea(question.getQuestion());
        title.setBorder(new LineBorder(new Color(0, 0, 0)));
        add(title, con);

        con.gridx = 0;
        con.gridy = 1;
        JLabel instructions1 = new JLabel("Instructions: ");
        add(instructions1, con);

        con.gridx = 1;
        JTextArea instructions = new JTextArea(5, 20);
        instructions.setText(question.getInstructions());
        instructions.setBorder(new LineBorder(new Color(0, 0, 0)));
        JScrollPane instructionsScroll = new JScrollPane(instructions);
        instructionsScroll.setBorder(null);
        add(instructionsScroll, con);

        JLabel sAnswers = new JLabel("Valid Answers");
        add(sAnswers, con);
        
        con.gridy ++;
        
        if (question instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion mcqQuestion = (MultipleChoiceQuestion) question;
            for (int i = 0; i < mcqQuestion.getNumberOfAnswers(); i++) {
                con.gridy ++;
                con.gridx = 0;
                JLabel answerText = new JLabel(mcqQuestion.getAnswer(i));
                add(answerText, con);
                con.gridx = 1;
                JLabel mark = new JLabel("Mark: x");
                add(mark, con);
            }
        } else {
            FITBQuestion fitbQuestion = (FITBQuestion) question;
            for (int i = 0; i < fitbQuestion.getNumberOfPossibleAnswers(); i++) {
                con.gridy ++;
                con.gridx = 0;
                JLabel answerText = new JLabel(fitbQuestion.getPossibleAnswer(i));
                add(answerText, con);
                con.gridx = 1;
                JLabel mark = new JLabel("Mark: x");
                add(mark, con);
            }            
        }

        /*
         con.gridx = 0;
         con.gridy = 2;
         JButton button = new JButton("Add Question");
         add(button, con);

         con.gridy = 4;
         con.gridx = 0;
         con.weightx = 1.0;
         con.gridwidth = 2;
         */

        this.setPreferredSize(new Dimension(600, 800));
    }

    public static void main(String[] argv) {
    }
}
