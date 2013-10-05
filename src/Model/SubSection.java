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
    
    void SetTitle ( String Title) {
        this.Title = Title;
    }
    
    void SetDescription ( String Description) {
        this.Description = Description;
    }
    
    void SetInstructions ( String Instructions ) {
        this.Instructions = Instructions;
    }
    
    String GetTitle(){
        return Title;
    }
    
    String GetDescription(){
        return Description;
    }
    
    String GetInstructions() {
        return Instructions;
    }
    
    Question GetQuestion(int ID) {
        return QuestionList.get(ID);
    }
    
    int GetNumberOfQuestions(){
        return QuestionList.size();
    }
    
    void AddQuestion(int position, Question Q) {
  	QuestionList.add (position, Q);
    }

    void RemoveQuestion (int position) {
          QuestionList.remove(position);
    }

    void MoveQuestionUp (int QuestionToMove) {
          if (QuestionToMove <= 0) return;
          if (QuestionToMove >= GetNumberOfQuestions() ) return;

          QuestionList.add(QuestionToMove-1, GetQuestion(QuestionToMove));
          QuestionList.remove(QuestionToMove +1 );
    }

    void MoveQuestionDown (int QuestionToMove) {
          MoveQuestionUp(QuestionToMove+1);
    }
}
