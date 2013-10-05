package Model;

import 	java.util.ArrayList;

public class QuestionPaper {
    int PaperID;
    ArrayList<Section> SectionList;
    // ArrayList<Question> QuestionList;
    ArrayList<Integer>  EligibleStudents;
    ArrayList<Integer>  EligibleSetters;
  
  QuestionPaper (int GivenPaperID, int CreatorID) {
  	PaperID = GivenPaperID;
        SectionList = new ArrayList<Section>();
  	// QuestionList = new ArrayList<Question>();
  	EligibleStudents = new ArrayList<Integer>();
  	EligibleSetters = new ArrayList<Integer>();
  	EligibleSetters.add(CreatorID);
  }
  
  /*
   *	Modifying Question Paper
   */
   
	
	
	void AddEligibleStudents(int ID) {
		EligibleStudents.add(ID);
	}
	
	void AddEligibleStudent(int[] IDs) {
		for (int ID : IDs) {
			EligibleStudents.add(ID);
		}
	}
  
	void AddEligibleSetters(int ID) {
		EligibleSetters.add(ID);
	}  
  
	void AddEligibleSetters(int[] IDs) {
		for (int ID : IDs ) {
			EligibleSetters.add(ID);
		}
	}    
  
  
  
  /*
   *	Reading/Using Question Paper
   */
   
  int GetPaperID() {
  	return PaperID;
  }
  
  /*
  int GetNumberOfQuestions() {
  	return QuestionList.size();
  }
  
  Question GetQuestion( int ID) {
		return QuestionList.get(ID);
	}
	
	int GetTimeLimit () {
		return TimeLimit;
	}
	*/
	boolean IsStudentEligible ( int StudentID) {
		for ( int ID : EligibleStudents) {
			if ( StudentID == ID ) return true;
		}
		return false;
	}
	/*
	void SubmitAnswers () {
		int totalMark = 0;
		for ( Question Q : QuestionList ) {
			if ( Q.IsCorrect() ) {
				totalMark += Q.GetMarkValue();
			}
		}
		
		//"submit mark"
		 
	}*/
}
