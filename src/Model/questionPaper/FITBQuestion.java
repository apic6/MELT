package Model.questionPaper;

public class FITBQuestion implements Question {

    private String instructions;
    private String[] questionParts;
    private String[] possibleAnswers;
    private int mark;

    public FITBQuestion(String[] question, String instructions, String[] possibleAnswers, int mark) {
        if (question.length != 2) {
            return;
        } else {
            this.questionParts = new String[2];
            this.questionParts[0] = question[0];
            this.questionParts[1] = question[1];
        }
        this.instructions = instructions;
        this.possibleAnswers = possibleAnswers;
        this.mark = mark;
    }

    @Override
    public String getInstructions() {
        return instructions;
    }

    @Override
    public String getQuestion() {
        return questionParts[0].concat("-Blank-" + questionParts[1]);
    }
    
    public String[] getQuestionParts() {
        return questionParts;
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
        XML += "<QuestionText>" + questionParts[0] + "</QuestionText>\n";
        XML += "<QuestionText>" + questionParts[0] + "</QuestionText>\n";
        for (int i = 0; i < possibleAnswers.length; i++) {
            if (possibleAnswers[i] != null) {
                XML += "<PossibleAnswer>" + possibleAnswers[i] + "</PossibleAnswer>\n";
            }
        }
        XML += "<Mark>" + mark + "</Mark>\n";
        XML += "</Question>\n";

        return XML;
    }
}