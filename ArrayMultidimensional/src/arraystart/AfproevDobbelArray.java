package arraystart;

/**
 * @author mad
 *
 */
public class AfproevDobbelArray {

	public static void main(String[] args) {
		int[][] array1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		int[][] array2 = { { 1, 2 }, { 0, 3 }, { 4, 5, 6 } };

		DobbelArray da = new DobbelArray();

		da.udskrivArray(array1);
		System.out.println();
		da.udskrivArray(array2);

		int[][] array3;
		array3 = new int[3][4];

		for (int i = 0; i < array3.length; i++) {
			array3[i][i] = 9;
		}

		System.out.println();
		da.udskrivArray(array3);
		// //
		//
		//
	}
}
