/**
 *
 */
package question;

import java.util.ArrayList;

/**
 * @author Kristian
 */
public class AnyCorrectChoiceQuestion extends Question {
    // ===========================================================
    // Fields
    // ===========================================================
    private ArrayList<String> correctAnswer = new ArrayList<>();
    // ===========================================================
    // Constructors
    // ===========================================================
    
    public AnyCorrectChoiceQuestion() {
        super();
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public void setAnswer(String correctResponse) {
        correctAnswer.add(correctResponse);
    }
    
    @Override
    public boolean checkAnswer(String response) {
        boolean answerBool = false;
        for (String s : correctAnswer) {
            if (response.toLowerCase().trim().equals(s.toLowerCase())) {
                answerBool = true;
            }
        }
        return answerBool;
    }
}
