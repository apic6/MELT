/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author mbaxkmt6
 */
public class TestSection extends JPanel{
    public JFrame mainFrame;
    public Modeller model;
    private JLabel title_label;
    private JLabel description_label;
    private JLabel instruction_label;
    private JTextArea title;
    private JTextArea description;
    private JTextArea instruction;
    
    
    public TestSection(JFrame frame,Modeller model){
        this.model = model;
        mainFrame = frame;
        initComponents();
    }

    
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        
        con.gridx = 0;
        con.gridy = 0;
        con.weightx = 0.3;
        con.anchor = GridBagConstraints.NORTHWEST;
        title_label = new JLabel("title:  ");
        add(title_label,con);
        con.gridx = 1;
        con.weightx = 0.7;
        title = new JTextArea(1,10);
        add(title, con);
        
        description_label = new JLabel("description:  ");
        con.gridx = 0;
        con.gridy = 1;
        add(description_label,con);
        
        instruction_label = new JLabel("instruction:  ");
        con.gridy = 2;
        con.weighty = 1.0;
        add(instruction_label,con);
        
        
    }
}
