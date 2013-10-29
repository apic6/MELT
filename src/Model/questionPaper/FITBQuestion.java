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

    public FITBQuestion() {
        
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

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String[] getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setQuestionParts(String[] questionParts) {
        this.questionParts = questionParts;
    }
     public void setQuestionParts(String questionParts, int i) {
        this.questionParts[i] = questionParts;
    }
    public void setPossibleAnswers(String[] possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    
    public int getNumberOfPossibleAnswers() {
       return possibleAnswers.length ;
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
        XML += "<QuestionText>" + questionParts[1] + "</QuestionText>\n";
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
