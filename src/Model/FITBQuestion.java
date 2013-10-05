package Model;

public class FITBQuestion implements Question {

    String Instructions;
    String Question;

    FITBQuestion(String GivenQuestion) {
        Question = GivenQuestion;
    }

    @Override
    public String GetInstructions() {
        return Instructions;
    }

    String GetQuestion() {
        return Question;
    }
}