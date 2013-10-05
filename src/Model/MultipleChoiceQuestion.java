package Model;

public class MultipleChoiceQuestion implements Question {
    String Instructions; 
    int MarkValue;
    String Question;
    String[] Answers;
	
    MultipleChoiceQuestion(String Question, String[] Answers, String Instructions) {
        this.Question = Question;
        this.Instructions = Instructions;

        int ArraySize = Answers.length;
        this.Answers = new String[ArraySize];
        for (int i = 0; i<ArraySize; i++) {
                this.Answers[i] = Answers[i];
        }
    }
	
    @Override
    public String GetInstructions() {
        return Instructions;
    }
	
    String GetQuestion() {
        return Question;
    }

    int GetNumberOfAnswers() {
        return Answers.length;
    }

    String GetAnswer(int ID) {
        return Answers[ID];
    }
}
