package Model;

public class FITBQuestion implements Question {

    private String instructions;
    private String question;
    private String chosenAnswer;
    private String[] answers;
    private String[] possibleAnswers;
    private int mark;

    FITBQuestion(String question, String instructions, String[] answers, String[] possibleAnswer, int mark) {
        this.question = question;
        this.instructions = instructions;
        this.answers = answers;
        this.possibleAnswers = possibleAnswers;
        this.mark = mark;
    }

    @Override
    public String getInstructions() {
        return instructions;
    }

    public int getNumberOfAnswers() {
        return answers.length;
    }

    public String getAnswer(int i) {
        return answers[i];
    }

    @Override
    public String getQuestion() {
        return question;
    }

    public int getNumberOfPossibleAnswers() {
        return possibleAnswers.length;
    }

    public String getPossibleAnswer(int i) {
        return possibleAnswers[i];
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
        for (int i = 0; i < possibleAnswers.length; i++) {
            if (answers[i] != null) {
                XML += "<PossibleAnswer>" + possibleAnswers[i] + "</PossibleAnswer>\n";
            }
        }
        XML += "<Mark>" + mark + "</Mark>\n";
        XML += "</Question>\n";

        return XML;
    }
}
