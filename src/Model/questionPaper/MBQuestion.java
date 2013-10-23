package Model.questionPaper;

import java.util.ArrayList;

public class MBQuestion implements Question {

    private String instructions;
    private ArrayList<String> questionParts;
    private int mark;
    
    public MBQuestion(){
        
    }
    public MBQuestion(ArrayList<String> question, String instructions, int mark) {
        questionParts = new ArrayList();
        for (int i = 0 ; i< question.size(); i++) {
            questionParts.add(question.get(i));
        }
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
        String question = "";
        for (int i = 0; i< questionParts.size(); i++) {
            question = question.concat("-Blank-" + questionParts.get(i));
        }
        return question;
    }
    
    public ArrayList<String> getQuestionParts() {
        return questionParts;
    }

    public void setQuestionParts(ArrayList<String> questionParts){
        this.questionParts = questionParts;
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
        for (int i =0; i<questionParts.size(); i++) 
            XML += "<QuestionText>" + questionParts.get(i) + "</QuestionText>\n";
        XML += "<Mark>" + mark + "</Mark>\n";
        XML += "</Question>\n";

        return XML;
    }
}
