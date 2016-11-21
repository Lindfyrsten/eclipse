package question;

import java.util.Scanner;

public class QuestionDemo4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Question q = new NumericQuestion();
        q.setText("What is 5-4");
        q.setAnswer("1");
//
        q.display();
        System.out.print("Your answer: ");
        String response = in.nextLine();
        System.out.println(q.checkAnswer(response));
        
    }
}
