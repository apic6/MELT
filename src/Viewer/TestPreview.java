/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

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
public class TestPreview extends JPanel{
    JLabel title;
    JTextArea description;
    public TestPreview(QuestionPaper paper){
        title = new JLabel(paper.GetTitle());
        description = new JTextArea(paper.GetDescription());
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.weightx = 0.3;
        add(title,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.weightx = 0.7;
        add(description,c);
    }
}
