package multiplechoicegui;

public class MultipleChoice {
    private char[] correctAnswer = { 'B', 'C', 'A', 'A', 'B', 'A', 'C', 'D',
        'A', 'C' };
    
    private char[][] studentAnswers;
    
    public MultipleChoice(int numberOfStudents) {
        studentAnswers = new char[numberOfStudents][10];
        for (int i = 0; i < studentAnswers.length; i++) {
            for (int j = 0; j < studentAnswers[i].length; j++) {
                int tal = (int) (Math.random() * 4); // tal mellem 0-3
                char c = (char) (tal + 'A');
                studentAnswers[i][j] = c;
            }
        }
    }
    
    public void printStudentAnswers() {
        for (int i = 0; i < studentAnswers.length; i++) {
            System.out.print("Student " + (i + 1) + " resultat: ");
            for (int j = 0; j < studentAnswers[i].length; j++) {
                if (j != 0) {
                    System.out.print(", ");
                }
                System.out.print(studentAnswers[i][j]);
            }
            System.out.println();
        }
    }
    
    /**
     * Udskriver for hver studerende antallet af rigtige svar
     */
    public String[] correctAnswersPrStudent() {
        int[] answers = new int[studentAnswers.length];
        String[] students = new String[studentAnswers.length];
        for (int i = 0; i < studentAnswers.length; i++) {

            int sum = 0;
            for (int j = 0; j < studentAnswers[i].length; j++) {
                if (studentAnswers[i][j] == correctAnswer[j]) {
                    sum++;
                }
                
            }
            answers[i] = sum;
            students[i] = "Student " + (i + 1) + ": " + sum + " points.";
            sum = 0;
        }
        return students;
    }
    
    /**
     * Udskriver for hver spørgsmål antallet af rigtige svar
     */
    public String[] correctAnswerPrQuestion() {
        String[] question = new String[studentAnswers.length];
        int[] answers = new int[studentAnswers[0].length];
        for (int j = 0; j < studentAnswers[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < studentAnswers.length; i++) {
                if (studentAnswers[i][j] == correctAnswer[j]) {
                    sum++;
                }
                
            }
            answers[j] = sum;
            question[j] = "Question " + (j + 1) + ": " + sum + " correct.";
            sum = 0;
        }
        return question;
    }
    
}
