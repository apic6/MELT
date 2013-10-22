package Model;

public class EssayQuestion implements Question {

    private String instructions;
    private String question;
    private int mark;

    EssayQuestion(String question, String instructions, int mark) {
        this.question = question;
        this.instructions = instructions;
        this.mark = mark;
    }

    @Override
    public String getInstructions() {
        return instructions;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toXML() {
        String XML = "<Question type=\"FITBQ\">\n";

        XML += "<Instructions>" + instructions + "</Instructions>\n";
        XML += "<QuestionText>" + question + "</QuestionText>\n";
        XML += "<Mark>" + mark + "</Mark>\n";
        XML += "</Question>\n";

        return XML;
    }
}
