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

    private int mark;
    private int totalMark;

    public Marker() {
        mark = 0;
        totalMark = 0;
    }

    /* 
     * public boolean markTest(StudentSubmission submission, MarkingScheme markingScheme) {
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
     }*/
    public boolean markTest(StudentSubmission submission, QuestionPaper paper) {
        mark = 0;
        totalMark = 0;
        if (submission.getPaperID() == paper.getPaperID()) {
            // mark sections
            for (int i = 0; i < submission.getSize(); i++) {
                // get section
                SubmissionSection submissionSection = submission.getSection(i);
                Section section = paper.getSection(i);

                if (submission.getSize() != paper.getNumberOfSections()) {
                    System.out.println("Number of sections in paper differ");
                }

                // mark subsections
                for (int j = 0; j < submissionSection.getSize(); j++) {
                    // get subSections
                    if (submissionSection.getSize() != section.getNumberOfSubSections()) {
                        System.out.println("Number of subsections in section " + j + " differ");
                    }

                    SubmissionSubSection submissionSubSection = submissionSection.getSubSection(j);
                    SubSection subSection = section.getSubSection(j);
                    // mark questions
                    for (int k = 0; k < submissionSubSection.getSize(); k++) {
                        // if question was a MCQ Question
                        if (submissionSubSection.getSize() != subSection.getNumberOfQuestions()) {
                            System.out.println("Number of questions in section " + j + " and subsection " + k + " differ");
                            System.out.println("Number of questions in subm. = " + submissionSubSection.getSize());
                            System.out.println("Number of questions in paper. = " + subSection.getNumberOfQuestions());
                        }
                        if (submissionSubSection.getAnswer(k) instanceof MCQAnswer) {
                            // if correct answer
                            MCQAnswer submAnswer = (MCQAnswer) submissionSubSection.getAnswer(k);
                            MultipleChoiceQuestion question = (MultipleChoiceQuestion) subSection.getQuestion(k);
                            for (int l = 0; l < question.getNumberOfPossibleAnswers(); l++) {
                                System.out.println("Checking mark for section:" + i + " subsection " + j + " question");
                                if (submAnswer.getAnswer() == question.getPossibleAnswer(l)) {
                                    mark += question.getMark(); //question.getMark();
                                }
                            }
                            // right or wrong increase total mark
                            totalMark += question.getMark(); //markingAnswer.getMark();
                        } /* else { // else it was FITB Question
                         FITBAnswer submAnswer = (FITBAnswer) submissionSubSection.getAnswer(k);
                         //FITBMarkingAnswer markingAnswer = (FITBMarkingAnswer)markingSubSection.getAnswer(k);
                         if (submAnswer.getAnswer().equals(markingAnswer.getAnswer())) {
                         mark += markingAnswer.getMark();
                         }
                         // right or wrong increase total mark
                         totalMark += markingAnswer.getMark();
                         } // else FITBQ */
                    } // questions
                } // subSections
            } // sections

            return true;
        } else {
            return false;
        }
    }

    public int getMark() {
        return mark;
    }

    public int getTotalMark() {
        return totalMark;
    }
}
