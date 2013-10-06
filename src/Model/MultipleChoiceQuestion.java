package Model;

public class MultipleChoiceQuestion implements Question {
    String Instructions; 
    int MarkValue;
    String Question;
    String[] Answers;
    int ChosenAnswer;
	
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
    
    void SetAnswer(int ChosenAnswer) {
        this.ChosenAnswer = ChosenAnswer;
    }
    
    int GetChosenAnswer() {
        return ChosenAnswer;
    }
    
    @Override
    public String toXML() {
        String XML = "<Question type=\"MCQ\">\n";
        
        XML += "<Instructions>" + Instructions + "</Instructions>\n";
        XML += "<QuestionText>" + Question + "</QuestionText>\n";
        for (int i = 0; i<Answers.length; i++) {
            XML += "<Answer>" + Answers[i] + "</Answer>\n";
        }
        
        XML += "</Question>\n";
        
        return XML;
    }
}
