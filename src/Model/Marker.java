/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mbgm8je3
 */
public class Marker {
    int mark;
    int totalMark;
    
    Marker() {
        mark = 0;
        totalMark = 0;
    }
    
    boolean markTest(StudentSubmission submission, MarkingScheme markingScheme) {
        mark = 0;
        totalMark = 0;
        if (submission.getPaperID() == markingScheme.getPaperID()) {
            // mark sections
            for (int i = 0; i<submission.getSize(); i++) {
                // get section
                SubmissionSection submissionSection = submission.getSection(i);
                MarkingSection markingSection = markingScheme.getSection(i);
                
                // mark subsections
                for (int j = 0; j<submissionSection.getSize(); j++) {
                    // get subSections
                    SubmissionSubSection submissionSubSection = submissionSection.getSubSection(j);
                    MarkingSubSection markingSubSection = markingSection.getSubSection(j);
                    // mark questions
                    for (int k=0; k<submissionSubSection.getSize();k++) {
                        // if question was a MCQ Question
                        if (submissionSubSection.getAnswer(k) instanceof MCQAnswer) {
                            // if correct answer
                            MCQAnswer submAnswer = (MCQAnswer) submissionSubSection.getAnswer(k);
                            MCQMarkingAnswer markingAnswer = (MCQMarkingAnswer)markingSubSection.getAnswer(k);
                            if ( submAnswer.getAnswer() == markingAnswer.getAnswer()) {
                                mark += markingAnswer.getMark();
                            }
                            // right or wrong increase total mark
                            totalMark += markingAnswer.getMark();
                        } else { // else it was FITB Question
                            FITBAnswer submAnswer = (FITBAnswer) submissionSubSection.getAnswer(k);
                            FITBMarkingAnswer markingAnswer = (FITBMarkingAnswer)markingSubSection.getAnswer(k);
                            if (submAnswer.getAnswer().equals(markingAnswer.getAnswer())) {
                                mark += markingAnswer.getMark();
                            }
                            // right or wrong increase total mark
                            totalMark += markingAnswer.getMark();
                        } // else FITBQ
                    } // questions
                } // subSections
            } // sections
            
            return true;
        } else return false;
    }
    
    int getMark() {
        return mark;
    }
    
    int getTotalMark() {
        return totalMark;
    }
}
