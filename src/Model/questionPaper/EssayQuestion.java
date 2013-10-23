package Model.questionPaper;

public class EssayQuestion implements Question {

    private String instructions;
    private String question;
    private int mark;
    private int wordLimit;
    
    public EssayQuestion(){
        
    }
    
    public EssayQuestion(String question, String instructions, int mark) {
        this.question = question;
        this.instructions = instructions;
        this.mark = mark;
    }

    @Override
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions){
        this.instructions = instructions;
    }
    
    @Override
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }
    
    public int getWordLimit(){
        return this.wordLimit;
    }
    
    public void setWordLimit(int wordLimit){
        this.wordLimit = wordLimit;
    }
    
    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toXML() {
        String XML = "<Question type=\"EssayQuestion\">\n";

        XML += "<Instructions>" + instructions + "</Instructions>\n";
        XML += "<QuestionText>" + question + "</QuestionText>\n";
        XML += "<Mark>" + mark + "</Mark>\n";
        XML += "</Question>\n";

        return XML;
    }
}
