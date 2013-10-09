package Model;

public class FITBQuestion implements Question {

    private String Instructions;
    private String Question;
    private String ChosenAnswer;

    FITBQuestion(String Question, String Instructions) {
        this.Question = Question;
        this.Instructions = Instructions;
    }

    @Override
    public String getInstructions() {
        return Instructions;
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
