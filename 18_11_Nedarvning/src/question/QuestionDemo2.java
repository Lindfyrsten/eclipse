package question;

import java.util.Scanner;

public class QuestionDemo2 {
	public static void main(String[] args) {
		ChoiceQuestion first = new ChoiceQuestion();
		first.setText("What was the original name of the Java language?");
		first.addChoice("*7", false);
		first.addChoice("Duke", false);
		first.addChoice("Oak", true);
		first.addChoice("Gosling", false);

		ChoiceQuestion second = new ChoiceQuestion();
		second.setText("In which country was the inventor of Java born?");
		second.addChoice("Australia", false);
		second.addChoice("Canada", true);
		second.addChoice("Denmark", false);
		second.addChoice("United States", false);
		QuestionDemo2.presentQuestion(first);
		QuestionDemo2.presentQuestion(second);
	}

	/**
	 * Presents a question to the user and checks the response.
	 *
	 * @param q
	 *            the question
	 */
	public static void presentQuestion(ChoiceQuestion q) {
		q.display();
		System.out.print("Your answer: ");
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		System.out.println(q.checkAnswer(response));
	}
}
