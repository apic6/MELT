/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mbgm8je3
 */
public class Test {
    public static void main(String argv[]){
        Modeller model = new Modeller();
        model.loadPapers();
        QuestionPaper paper = model.getPaper(0);
        JPanel panel1 = new PaperEditor(paper);
        JPanel panel2 = new SectionEditor(paper.getSection(0));
        JPanel panel3 = new SubsectionEditor(paper.getSection(0).getSubSection(0));
        //JPanel panel4 = new QuestionEditor();
        
        JFrame frame1 = new JFrame();
        frame1.add(panel1);
        frame1.setVisible(true);
        frame1.pack();
        
        JFrame frame2 = new JFrame();
        frame2.add(panel2);
        frame2.setVisible(true);
        frame2.pack();
        
        JFrame frame3 = new JFrame();
        frame3.add(panel3);
        frame3.setVisible(true);
        frame3.pack();
        
    }
}
