public class MultipleChoiceQuestion implements Question {
  String comments; 
  int MarkValue;
	String Question;
	String[] Answers;
	int CorrectAnswer;
	int ChosenAnswer;
	
	MultipleChoiceQuestion(String GivenQuestion, String[] GivenAnswers, 
																						int GivenCorrectAnswer) {
		Question = GivenQuestion;
		
		int ArraySize = GivenAnswers.length;
		Answers = new String[ArraySize];
		for (int i = 0; i<ArraySize; i++) {
			Answers[i] = GivenAnswers[i];
		}
		
		CorrectAnswer = GivenCorrectAnswer;
	}
	
	public String GetComments() {
		return comments;
	}
	
	String GetQuestion() {
		return Question;
	}
	
	int GetNumberOfQuestions() {
	  return Answers.length;
	}
	
	String GetAnswer(int ID) {
		return Answers[ID];
	}
	
	void SetAnswer ( int chosenAnswer ) {
	  ChosenAnswer = chosenAnswer;
	}
	
	public int GetMarkValue() {
		return MarkValue;
	}
	
	public boolean IsCorrect() {
		return CorrectAnswer == ChosenAnswer;
	}
}
