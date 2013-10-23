/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.questionPaper.QuestionPaper;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import Model.*;
/**
 *
 * @author Daniel
 */
public class PaperPreviewer extends JPanel{
    JLabel title;
    JTextArea description;
    public PaperPreviewer(QuestionPaper paper){
        
        title = new JLabel(paper.getTitle());
        description = new JTextArea(paper.getDescription());
        
        setLayout(new GridBagLayout());
        GridBagConstraints c5 = new GridBagConstraints();
        c5.fill = GridBagConstraints.HORIZONTAL;
        c5.gridx = 0;
        c5.weightx = 0.3;
        add(title,c5);
        
        c5.fill = GridBagConstraints.HORIZONTAL;
        c5.gridx = 1;
        c5.weightx = 0.7;
        add(description,c5);
    }
}
