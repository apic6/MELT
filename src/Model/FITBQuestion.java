package Model;

public class FITBQuestion implements Question {

    String Instructions;
    String Question;
    String ChosenAnswer;

    FITBQuestion(String Question, String Instructions) {
        this.Question = Question;
        this.Instructions = Instructions;
    }

    @Override
    public String GetInstructions() {
        return Instructions;
    }

    String GetQuestion() {
        return Question;
    }

    void SetAnswer(String ChosenAnswer) {
        this.ChosenAnswer = ChosenAnswer;
    }

    String GetChosenAnswer() {
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