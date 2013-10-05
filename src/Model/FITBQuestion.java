package Model;

public class FITBQuestion implements Question {
  String comments;
  int MarkValue;
	String Question;
	String Answer;
	String ChosenAnswer;
	
	FITBQuestion (String GivenQuestion, String GivenAnswer) {
		Question = GivenQuestion;
		Answer = GivenAnswer;
	}
	
  public String GetComments() {
		return comments;
	}
	
	String GetQuestion() {
		return Question;
	}
	
	void SetAnswer(String chosenAnswer) {
		ChosenAnswer = chosenAnswer;
	}
	
	public int GetMarkValue() {
		return MarkValue;
	}
	
	public boolean IsCorrect() {
		return Answer.equals(ChosenAnswer);
	}
}
