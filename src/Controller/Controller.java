/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
//should be able to handle button listeners in the viewer and model methods

/**
 *
 * @author mbaxkak4
 */
import Model.Modeller;
import Model.StudentSubmission.Submission;
import Model.questionPaper.QuestionPaper;
import Viewer.LoginScreen;
import Viewer.MarkerView;
import Model.Marker;
import Viewer.PaperViews.PaperView;

import Viewer.Student;

import Viewer.TeacherView;
import Viewer.TestWizard;
import Viewer.Viewer;
import Viewer.Welcome;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author mbaxkak4
 */
public class Controller {

    private Modeller amodel;
    private Controller controller;
    public ViewerEventListener lel;
    public Controller(Viewer view, Modeller model) {   //constructor of controller class

        Welcome.addListener(new ViewerEventListener());
        amodel = model;
        controller = this;
        lel = new ViewerEventListener();
    }

   public class ViewerEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "login": {
                    String username = LoginScreen.getUsername();
                    String pass = LoginScreen.getPass();
                    if (pass.equals("")) {
                        JFrame frame;
                        frame = LoginScreen.getFrame();
                        frame.setContentPane(new Student(frame, amodel, username));
                        Student.addListener(new ViewerEventListener());
                        frame.setVisible(true);


                    }
                }
                break;

                case "Create a New Test": {
                    JFrame frame;
                    frame = TeacherView.getFrame();
                    frame.setContentPane(new TestWizard(controller,frame, amodel,null));
                    frame.setVisible(true);
                    TestWizard.addListener(new Mouse());
                    Timer timer = new Timer(true);
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            saveNewTest();
                        }
                    }, 0, 2000);
                }
                break;

                case "I am a Teacher": {
                    JFrame frame;
                    frame = Welcome.getFrame();
                    frame.setContentPane(new TeacherView(frame, amodel));
                    frame.setVisible(true);
                    TeacherView.addListener(new ViewerEventListener());
                }
                break;
                case "I am a Student": {
                    JFrame frame;
                    frame = Welcome.getFrame();
                    frame.setContentPane(new LoginScreen(frame, amodel));
                    LoginScreen.addListener(new ViewerEventListener());
                    frame.setVisible(true);
                    //TeacherView.addListener(new ViewerEventListener()); 
                }
                break;

                case "markTrigger": {
                    MarkerView.addListeners(new Mouse());
                    Timer timer = new Timer(true);
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            Submission sub = MarkerView.getSubmission();
                            // sub.normalise();
                            saveSubmission(sub);
                        }
                    }, 0, 2000);
                }
                break;

                case "editTrigger": {

                    JFrame frame;
                    QuestionPaper paper;
                    frame = TeacherView.getFrame();
                    frame.setContentPane(new TestWizard(controller,frame, amodel, TeacherView.getPaper()));
                    frame.setVisible(true);
                    TestWizard.addListener(new Mouse());
                    Timer timer = new Timer(true);
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {

                            saveOldTest();
                        }
                    }, 0, 2000);
                }
                break;

                case "startTrigger": {
                    PaperView.addListener(new ViewerEventListener());
                    System.out.println("Something");
                    /* Needed to comment out to fix some code, this may not work though.
                     * I'll analyse this code and mine when Im more awake but right now having this code as-is prevents my code from working.
                     * I think it pulls thje submission a little too early and causes errors, I might be wrong though. */

                    Submission newsub;
                    newsub = PaperView.getSubmission();
                    amodel.loadSubmissions();
                    amodel.addSubmission(newsub);
                    try {
                        amodel.saveSubmissions(null);
                    } catch (FileNotFoundException ex) {
                    }
                    Timer timer = new Timer(true);
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            saveSubmission(PaperView.getSubmission());
                            System.err.println("jkhdfhjkshfkjds");
                        }
                    }, 0, 2000);
                }
                break;
                case "markerTrigger": {


                    Marker marker = new Marker();
                    Submission sub = PaperView.getSubmission();
                    sub.normalise();
                    marker.markTest(sub, PaperView.getPaper());
                    sub = marker.getSubmission();
                    sub.setSubmitted();
                    saveSubmission(sub);
                    System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                }
                break;

            }

        }
    }

    class ViewerDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateModel();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateModel();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateModel();
        }

        private void updateModel() {
            //
            // System.out.println("it works");
        }
    }

    class ViewerFocusListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            //System.out.println("works");
        }

        @Override
        public void focusLost(FocusEvent e) {
            //  saveTest();
        }
    }

    public class Mouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private void saveNewTest() {
        System.out.println("saving");
        QuestionPaper p;
        p = TestWizard.getQuestionPaper();
        //  System.out.println(p.getPaperID());
        amodel.loadPapers();

        try {
            // p.getPaperID();
            if (amodel.getPaperByPaperID(p.getPaperID()) != null) {
                amodel.removePaperByPaperID(p.getPaperID());
                amodel.addPaper(p);

            } else {
                amodel.addPaper(p);
            }

            amodel.savePapers(null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveOldTest() {
        System.out.println("saving");
        QuestionPaper p;
        p = TestWizard.getQuestionPaper();

        amodel.loadPapers();

        try {


            amodel.removePaperByPaperID(p.getPaperID());
            amodel.addPaper(p);             //it always adds at the end of the list...


            amodel.savePapers(null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveSubmission(Submission submission) {
        Submission sub = submission;

        System.out.println("SAVING");

        ArrayList<Submission> allsubs;
        try {
            amodel.loadSubmissions();
            allsubs = amodel.getSubmissions();
            for (int i = 0; i < allsubs.size(); i++) {
                if (allsubs.get(i).getPaperID() == sub.getPaperID() && allsubs.get(i).getStudentID() == sub.getStudentID()) {

                    amodel.removeSubmission(i);
                    amodel.addSubmission(sub, i);
                }


            }
            amodel.saveSubmissions(null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
