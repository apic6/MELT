package Model;

public class MultipleChoiceQuestion implements Question {

    private String instructions;
    private int mark;
    private String question;
    private String[] answers;
    private int[] possibleAnswers;

    public MultipleChoiceQuestion(){
        
    }
    
    public MultipleChoiceQuestion(String Question, String[] Answers, String Instructions, int[] possibleAnswers, int mark) {
        this.question = Question;
        this.instructions = Instructions;

        int ArraySize = Answers.length;
        this.answers = new String[ArraySize];
        for (int i = 0; i < ArraySize; i++) {
            this.answers[i] = Answers[i];
        }

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
    return this;
    }
    @Override
    public FITBQuestion getFIB(){
    return null;}
    

    public int getNumberOfAnswers() {
        return answers.length;
    }

    public String getAnswer(int ID) {
        return answers[ID];
    }

    public String[] getAnswers(){
        return answers;
    }
    
    public int getNumberOfPossibleAnswers() {
        return possibleAnswers.length;
    }
    
    public int[] getPossibleAnswers(){
        return possibleAnswers;
    }

    public int getPossibleAnswer(int i) {
        return possibleAnswers[i];
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
   

    public void setInstructions(String instructions) {
        this.instructions = instructions;
        
    }

    public void setPossibleAnswers(int[] possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
   

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toXML() {
        String XML = "<Question type=\"MCQ\">\n";

        XML += "<Instructions>" + instructions + "</Instructions>\n";
        XML += "<QuestionText>" + question + "</QuestionText>\n";
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] != null) {
                XML += "<Answer>" + answers[i] + "</Answer>\n";
            }
        }
        for (int i = 0; i < possibleAnswers.length; i++) {
            XML += "<PossibleAnswer>" + possibleAnswers[i] + "</PossibleAnswer>\n";
        }
        XML += "<Mark>" + mark + "</Mark>\n";
        XML += "</Question>\n";

        return XML;
    }

    public int getRightAnswers() {
        int result = 0;
        for(int i=0;i<possibleAnswers.length;i++)
            if(possibleAnswers[i] == 1)
                result++;
        return result;
    }
}
