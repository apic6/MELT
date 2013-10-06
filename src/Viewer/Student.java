/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Daniel
 */
public class Student extends JPanel{
    public Student(){
        initComponents();
    }
    
//    private Container mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel mainLabel;
    private JLabel leftLabel;
    private JLabel rightLabel;
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    
    private void initComponents() {
//        setTitle("Welcome!");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainPanel = getContentPane();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        mainLabel = new JLabel();
        leftLabel = new JLabel();
        rightLabel = new JLabel();
        menuBar = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        
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
        
        menu1.setText("File");
        menu1.add(menuItem1);
        menuItem1.setText("import");
        
        menu2.setText("Edit");
        menu2.add(menuItem2);
        menuItem2.setText("Refresh");
        
        menuBar.add(menu1);
        menuBar.add(menu2);
        
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.weightx = 1.0;
        c1.weighty = 1.0;
        c1.gridy = 0;
        leftPanel.add(new TestPreview(),c1);
        c1.gridy = 1;
        leftPanel.add(new TestPreview(),c1);
        c1.gridy = 2;
        leftPanel.add(new TestPreview(),c1);
        
        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.weightx = 1.0;
        c2.weighty = 1.0;
        c2.gridy = 0;
        rightPanel.add(new TestPreview(),c2);
        c2.gridy = 1;
        rightPanel.add(new TestPreview(),c2);
        c2.gridy = 2;
        rightPanel.add(new TestPreview(),c2);
        
//        setJMenuBar(menuBar);
//        pack();
    }
    
}
