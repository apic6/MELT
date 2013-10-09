/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
//Should be able to handle data request and manipulate persistent data

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mbaxkak4
 */
public class Modeller {
    ArrayList<QuestionPaper> questionPapers;
    QuestionPaper viewingPaper;
    
    public Modeller() {     //constructor
        
    }
    
    // loads all papers into model
    public void loadPapers(String filename) {
        QuestionPaperLoader loader = new QuestionPaperLoader(filename);
        
        loader.ReadPapers();
        
        questionPapers = loader.getQuestionPapers();
    }
    
    // saves papers
    void savePapers(String filename) throws FileNotFoundException {
        String xmlString = "";
        if (filename == null) {
            filename = "Papers2.xml";
        }
        for (int i = 0; i<questionPapers.size(); i++) {
            xmlString += questionPapers.get(i).toXML();
        }
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.println(xmlString);
            writer.close();              
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Modeller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<QuestionPaper>  getPapersByStudentID(int studentID) {
        ArrayList<QuestionPaper> eligiblePapers = new ArrayList<>();
        for (int i = 0; i<questionPapers.size(); i++) {
            if (questionPapers.get(i).IsStudentEligible(studentID)) {
                eligiblePapers.add(questionPapers.get(i));
            }
        }
        return eligiblePapers;
    }
   
    
    
    // get number of papers
    int getNumberOfPapers() {
        return questionPapers.size();
    }
    
    // retrieve a paper
    QuestionPaper getPaper(int index) {
        return questionPapers.get(index);
    }
    
    // add a paper to the model
    void addPaper(QuestionPaper paper) {
        questionPapers.add(paper);
    }
    
    // remove a paper from the model
    void removePaper(int index) {
        questionPapers.remove(index);
    }
    
    // moves a paper up in a list
    void movePaperUp(int index) {
        if (index <= 0) return;
        if (index >= questionPapers.size()) return;

        questionPapers.add(index-1, getPaper(index));
        questionPapers.remove(index +1 );
    }
    
    // moves a paper down in a list
    void MoveSubSectionDown (int index) {
        movePaperUp(index+1);
    }
    
    
   
    public void setValue(){
    System.out.println("it Works");}
}