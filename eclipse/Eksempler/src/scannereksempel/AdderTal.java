package scannereksempel;

import java.util.Scanner;

public class AdderTal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tal1 = -1;
		int tal2 = -1;

		System.out.print("Tal 1 ");
		if (scan.hasNextInt()) {
			tal1 = scan.nextInt();
			System.out.print("Tal 2 ");
			if (scan.hasNextInt()) {
				tal2 = scan.nextInt();
				System.out.println("Resultat addition " + (tal1 + tal2));
			}

		}
		scan.close();

	}
}
