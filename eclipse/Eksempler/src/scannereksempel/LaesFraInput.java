package scannereksempel;

import java.util.Scanner;

public class LaesFraInput {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String fornavn = "";
		String efternavn = "";
		int alder = -1;

		System.out.println("Hvad er dit fornavn ? ");
		fornavn = scan.nextLine();
		System.out.println("Hvad er dit efternavn ? ");
		efternavn = scan.nextLine();
		System.out.println("Hvor gammel er du ? ");
		alder = scan.nextInt();

		System.out.println(fornavn + " " + efternavn + " " + alder);
		scan.close();

	}

}
