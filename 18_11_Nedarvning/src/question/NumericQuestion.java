package question;

public class NumericQuestion extends Question {
    // ===========================================================
    // Fields
    // ===========================================================
    // ===========================================================
    // Constructors
    // ===========================================================
    public NumericQuestion() {
        super();
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public boolean checkAnswer(String response) {

        boolean answerBool = true;
        if (Double.parseDouble(super.getAnswer()) - Double.parseDouble(response) > 0.01
            || Double.parseDouble(super.getAnswer()) - Double.parseDouble(response) < -0.01) {
            answerBool = false;

        }
        return answerBool;
    }
}