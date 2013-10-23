package Model.questionPaper;

public interface Question {
    int getMark();
    String getQuestion();
    String getInstructions();
    String toXML();
}
