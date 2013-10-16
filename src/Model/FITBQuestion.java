package Model;

public class FITBQuestion implements Question {

    private String instructions;
    private String question;
    private String[] possibleAnswers;
    private int mark;

    FITBQuestion(String question, String instructions, String[] possibleAnswers, int mark) {
        this.question = question;
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
        return question;
    }
    
   
    @Override
    public MultipleChoiceQuestion getMCQ (){
    return null;
    }
    @Override
    public FITBQuestion getFIB(){
    return this;}

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
            if (possibleAnswers[i] != null) {
                XML += "<PossibleAnswer>" + possibleAnswers[i] + "</PossibleAnswer>\n";
            }
        }
        XML += "<Mark>" + mark + "</Mark>\n";
        XML += "</Question>\n";

        return XML;
    }
}
