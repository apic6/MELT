package Model;

public interface Question {
    String getQuestion();
    String getInstructions();
    String toXML();
    MultipleChoiceQuestion getMCQ();
    FITBQuestion getFIB();
}
