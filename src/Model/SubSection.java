/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import 	java.util.ArrayList;

/**
 *
 * @author Jamie
 */
public class SubSection {
   
    String Title;
    String Description;
    String Instructions;
    
    ArrayList<Question> QuestionList;
    
    public SubSection(){
        QuestionList = new ArrayList();
    }
    
    public SubSection (String Title, String Description, String Instructions) {
        this.Title = Title;
        this.Description = Description;
        this.Instructions = Instructions;
        
        QuestionList = new ArrayList<>();
    }
    
    public void setTitle ( String Title) {
        this.Title = Title;
    }
    
    public void setDescription ( String Description) {
        this.Description = Description;
    }
    
    public void setInstructions ( String Instructions ) {
        this.Instructions = Instructions;
    }
    
    public String getTitle(){
        return Title;
    }
    
    public String getDescription(){
        return Description;
    }
    
    public String getInstructions() {
        return Instructions;
    }
    
    public Question getQuestion(int ID) {
        return QuestionList.get(ID);
    }
    
    public int getNumberOfQuestions(){
        return QuestionList.size();
    }
    
    public void addQuestion(int position, Question Q) {
  	QuestionList.add (position, Q);
    }
    
    public void addQuestion(Question Q) {
  	QuestionList.add (Q);
    }
    public void removeQuestion (int position) {
          QuestionList.remove(position);
    }

    public void moveQuestionUp (int QuestionToMove) {
          if (QuestionToMove <= 0) return;
          if (QuestionToMove >= getNumberOfQuestions() ) return;

          QuestionList.add(QuestionToMove-1, getQuestion(QuestionToMove));
          QuestionList.remove(QuestionToMove +1 );
    }

    public void moveQuestionDown (int QuestionToMove) {
          moveQuestionUp(QuestionToMove+1);
    }
    
    public String toXML() {
        String XML = "<SubSection>\n";
        
        XML += "<Title>" + Title + "</Title>\n";
        XML += "<Description>" + Description + "</Description>\n";
        XML += "<Instructions>" + Instructions + "</Instructions>\n";
        
        for (int i = 0; i<QuestionList.size(); i++) {
            XML += QuestionList.get(i).toXML();
        }
        
        XML += "</SubSection>\n";
        
        return XML;
    }
}
