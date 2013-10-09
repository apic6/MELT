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
    
    SubSection (String Title, String Description, String Instructions) {
        this.Title = Title;
        this.Description = Description;
        this.Instructions = Instructions;
        
        QuestionList = new ArrayList<>();
    }
    
    public void SetTitle ( String Title) {
        this.Title = Title;
    }
    
    public void SetDescription ( String Description) {
        this.Description = Description;
    }
    
    public void SetInstructions ( String Instructions ) {
        this.Instructions = Instructions;
    }
    
    public String GetTitle(){
        return Title;
    }
    
    public String GetDescription(){
        return Description;
    }
    
    public String GetInstructions() {
        return Instructions;
    }
    
    public Question GetQuestion(int ID) {
        return QuestionList.get(ID);
    }
    
    public int GetNumberOfQuestions(){
        return QuestionList.size();
    }
    
    public void AddQuestion(int position, Question Q) {
  	QuestionList.add (position, Q);
    }

    public void RemoveQuestion (int position) {
          QuestionList.remove(position);
    }

    public void MoveQuestionUp (int QuestionToMove) {
          if (QuestionToMove <= 0) return;
          if (QuestionToMove >= GetNumberOfQuestions() ) return;

          QuestionList.add(QuestionToMove-1, GetQuestion(QuestionToMove));
          QuestionList.remove(QuestionToMove +1 );
    }

    public void MoveQuestionDown (int QuestionToMove) {
          MoveQuestionUp(QuestionToMove+1);
    }
    
    String toXML() {
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
