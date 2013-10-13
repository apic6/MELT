package Model;

public class FITBQuestion implements Question {

    private String Instructions;
    private String Question;
    private String ChosenAnswer;
    private String[] answers;

    FITBQuestion(String Question, String Instructions, String[] answers) {
        this.Question = Question;
        this.Instructions = Instructions;
        this.answers = answers;
    }

    @Override
    public String getInstructions() {
        return Instructions;
    }
    
    public int getNumberOfAnswers() {
        return answers.length;
    }
    
    public String getAnswer(int i) {
        return answers[i];
    }

    @Override
    public String getQuestion() {
        return Question;
    }

    public void SetAnswer(String ChosenAnswer) {
        this.ChosenAnswer = ChosenAnswer;
    }

    public String GetChosenAnswer() {
        return ChosenAnswer;
    }
    
    @Override
    public String toXML() {
        String XML = "<Question type=\"FITBQ\">\n";
        
        XML += "<Instructions>" + Instructions + "</Instructions>\n";
        XML += "<QuestionText>" + Question + "</QuestionText>\n";        
        XML += "</Question>\n";
        
        return XML;
    }    
}
