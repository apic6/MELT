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
}