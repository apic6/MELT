/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer.PaperViews;

import Model.questionPaper.Question;
import Model.questionPaper.SubSection;
import javax.swing.JPanel;
import Model.*;
import java.awt.Color;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author mbgm8je3
 */
public class SubSectionView extends JPanel {

    QuestionView[] questionViews;
    SubSectionView[] subSectionViews;
    // int height;

    public SubSectionView(SubSection subSection, final QuestionPaperTaker taker, final int sectionID, final int subSectionID) {
        JPanel questionsPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.width = 1050;
                return d;
            }
        };

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.anchor = GridBagConstraints.NORTH;
        con.fill = GridBagConstraints.NONE;
        questionsPanel.setLayout(layout);

        GridBagConstraints vertFill = new GridBagConstraints();


        JScrollPane scrollPane = new JScrollPane() {
            @Override
            public Dimension getPreferredSize() {
                //Dimension d = super.getPreferredSize();
                //d.width = 1050;
                //return d;
                return new Dimension(1050, 750);
            }
        };



        if (subSection.getCollectionType() == SubSection.CollectionType.QUESTIONS) {
            questionViews = new QuestionView[subSection.getNumberOfQuestions()];
            for (int i = 0; i < subSection.getNumberOfQuestions(); i++) {
                questionViews[i] = new QuestionView(subSection.getQuestion(i), taker, sectionID, subSectionID, i);
                questionsPanel.add(questionViews[i], con);
                con.gridy++;
            }
            vertFill = con;
            vertFill.anchor = GridBagConstraints.NORTH;
            vertFill.fill = GridBagConstraints.VERTICAL;

            questionsPanel.setAlignmentX(TOP_ALIGNMENT);
            questionsPanel.add(Box.createVerticalBox(), vertFill);
            scrollPane.getViewport().add(questionsPanel, null);


            this.add(scrollPane, null);
            this.setLayout(new GridLayout(1, 1));
            this.add(scrollPane);
        } else if (subSection.getCollectionType() == SubSection.CollectionType.SUBSECTIONS) {
            subSectionViews = new SubSectionView[subSection.getNumberOfSubSections()];
            JTabbedPane tabbedPane = new JTabbedPane() {
                @Override
                public Dimension getPreferredSize() {
                    Dimension d = super.getPreferredSize();
                    d.height = 700;
                    d.width = 1050;
                    return d;
                }
            };
            for (int i = 0; i < subSection.getNumberOfSubSections(); i++) {
                ArrayList<Integer> subSectionList = new ArrayList<>();
                subSectionList.add(sectionID);
                subSectionList.add(i);
                subSectionViews[i] = new SubSectionView(subSection.getSubSection(i), taker, sectionID, subSectionList);
                tabbedPane.add(subSectionViews[i], subSection.getSubSection(i).getTitle());
                questionsPanel.add(tabbedPane, con);
                con.gridy++;
            }
            vertFill = con;
            vertFill.anchor = GridBagConstraints.NORTH;
            vertFill.fill = GridBagConstraints.VERTICAL;

            questionsPanel.setAlignmentX(TOP_ALIGNMENT);
            questionsPanel.add(Box.createVerticalBox(), vertFill);
            scrollPane.getViewport().add(questionsPanel, null);
            // scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            this.add(scrollPane, null);
            this.setLayout(new GridLayout(1, 1));
            this.add(scrollPane);
        }


    }

    public SubSectionView(SubSection subSection, final QuestionPaperTaker taker, final int sectionID, final ArrayList<Integer> subSectionIDs) {
        JPanel questionsPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.width = 1050;
                return d;
            }
        };

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.anchor = GridBagConstraints.NORTH;
        con.fill = GridBagConstraints.NONE;
        questionsPanel.setLayout(layout);

        GridBagConstraints vertFill = new GridBagConstraints();


        JScrollPane scrollPane = new JScrollPane() {
            @Override
            public Dimension getPreferredSize() {
                //Dimension d = super.getPreferredSize();
                //d.width = 1050;
                //return d;
                return new Dimension(1050, 750);
            }
        };



        if (subSection.getCollectionType() == SubSection.CollectionType.QUESTIONS) {
            questionViews = new QuestionView[subSection.getNumberOfQuestions()];
            for (int i = 0; i < subSection.getNumberOfQuestions(); i++) {
                questionViews[i] = new QuestionView(subSection.getQuestion(i), taker, sectionID, subSectionIDs, i);
                questionsPanel.add(questionViews[i], con);
                con.gridy++;
            }
            vertFill = con;
            vertFill.anchor = GridBagConstraints.NORTH;
            vertFill.fill = GridBagConstraints.VERTICAL;

            questionsPanel.setAlignmentX(TOP_ALIGNMENT);
            questionsPanel.add(Box.createVerticalBox(), vertFill);
            scrollPane.getViewport().add(questionsPanel, null);

            this.add(scrollPane, null);
            this.setLayout(new GridLayout(1, 1));
            this.add(scrollPane);
        } else if (subSection.getCollectionType() == SubSection.CollectionType.SUBSECTIONS) {

            subSectionViews = new SubSectionView[subSection.getNumberOfSubSections()];
            JTabbedPane tabbedPane = new JTabbedPane() {
                @Override
                public Dimension getPreferredSize() {
                    Dimension d = super.getPreferredSize();
                    d.height = 700;
                    d.width = 1050;
                    return d;
                }
            };
            for (int i = 0; i < subSection.getNumberOfSubSections(); i++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j<subSectionIDs.size(); j++) {
                    list.add(subSectionIDs.get(j));
                }
                list.add(i);
                subSectionViews[i] = new SubSectionView(subSection.getSubSection(i), taker, sectionID, list);
                tabbedPane.add(subSectionViews[i], subSection.getSubSection(i).getTitle());
                questionsPanel.add(tabbedPane, con);
                con.gridy++;
            }
            vertFill = con;
            vertFill.anchor = GridBagConstraints.NORTH;
            vertFill.fill = GridBagConstraints.VERTICAL;

            questionsPanel.setAlignmentX(TOP_ALIGNMENT);
            questionsPanel.add(Box.createVerticalBox(), vertFill);
            scrollPane.getViewport().add(questionsPanel, null);
            // scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            this.add(scrollPane, null);
            this.setLayout(new GridLayout(1, 1));
            this.add(scrollPane);
        }


    }

    public SubSectionView(SubSection subSection, final int sectionID, final int subSectionID) {
        JPanel questionsPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.width = 1050;
                return d;
            }
        };

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.anchor = GridBagConstraints.NORTH;
        con.fill = GridBagConstraints.NONE;
        questionsPanel.setLayout(layout);

        GridBagConstraints vertFill = new GridBagConstraints();


        JScrollPane scrollPane = new JScrollPane() {
            @Override
            public Dimension getPreferredSize() {
                //Dimension d = super.getPreferredSize();
                //d.width = 1050;
                //return d;
                return new Dimension(1050, 750);
            }
        };

        questionViews = new QuestionView[subSection.getNumberOfQuestions()];

        for (int i = 0; i < subSection.getNumberOfQuestions(); i++) {
            questionViews[i] = new QuestionView(subSection.getQuestion(i), sectionID, subSectionID, i);
            questionsPanel.add(questionViews[i], con);
            con.gridy++;
        }
        vertFill = con;
        vertFill.anchor = GridBagConstraints.NORTH;
        vertFill.fill = GridBagConstraints.VERTICAL;

        questionsPanel.setAlignmentX(TOP_ALIGNMENT);
        questionsPanel.add(Box.createVerticalBox(), vertFill);
        scrollPane.getViewport().add(questionsPanel, null);

        this.add(scrollPane, null);
        this.setLayout(new GridLayout(1, 1));
        this.add(scrollPane);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1050, 750);
    }
}
