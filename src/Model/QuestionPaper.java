import 	java.util.ArrayList;

public class QuestionPaper {
	int PaperID;
  ArrayList<Question> QuestionList;
  int TimeLimit;
  ArrayList<Integer>  EligibleStudents;
  ArrayList<Integer>  EligibleSetters;
  
  QuestionPaper (int GivenPaperID, int CreatorID) {
  	PaperID = GivenPaperID;
  	QuestionList = new ArrayList<Question>();
  	EligibleStudents = new ArrayList<Integer>();
  	EligibleSetters = new ArrayList<Integer>();
  	EligibleSetters.add(CreatorID);
  }
  
  /*
   *	Modifying Question Paper
   */
   
	void SetTimeLimit ( int GivenTimeLimit) {
		TimeLimit = GivenTimeLimit;
	}
	
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
  
  /*
   *	Reading/Using Question Paper
   */
   
  int GetPaperID() {
  	return PaperID;
  }
  
  int GetNumberOfQuestions() {
  	return QuestionList.size();
  }
  
  Question GetQuestion( int ID) {
		return QuestionList.get(ID);
	}
	
	int GetTimeLimit () {
		return TimeLimit;
	}
	
	boolean IsStudentEligible ( int StudentID) {
		for ( int ID : EligibleStudents) {
			if ( StudentID == ID ) return true;
		}
		return false;
	}
	
	int GetMark () {
		int Mark = 0;
		for (Question Q : QuestionList ) {
			if (Q.IsCorrect() )
				Mark+= Q.GetMarkValue();
		}
		return Mark;
	}
	
	int GetTotalMark () {
		int TotalMark = 0;
		for (Question Q : QuestionList ) {
			TotalMark+= Q.GetMarkValue();
		}
		return TotalMark;
	}
	
	void SubmitAnswers () {
		int totalMark = 0;
		for ( Question Q : QuestionList ) {
			if ( Q.IsCorrect() ) {
				totalMark += Q.GetMarkValue();
			}
		}
		/*
			 "submit mark"
		 */
	}
}
