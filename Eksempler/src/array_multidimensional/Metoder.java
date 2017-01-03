package array_multidimensional;

/**
 * @author Kristian Lindbjerg
 */
public class Metoder {
    public void udskrivArray(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.print(array[row][col] + "  ");
            }
            System.out.println();
        }
    }

    public void udskrivArray2(int[][] array) {
        int row = 0;
        while (row < array.length) {
            int col = 0;
            while (col < array[row].length) {
                System.out.print(array[row][col] + "  ");
                col++;
            }
            System.out.println();
            row++;
        }

    }

    public int samletRow(int[][] array, int row) {
        int sum = 0;
        for (int col = 0; col < array[row].length; col++) {
            sum += array[row][col];

        }

        return sum;
    }
    
    public double gennemsnitRow(int[][] array, int row) {
        double sum = 0;
        for (int col = 0; col < array[row].length; col++) {
            sum += array[row][col];

        }
        return sum / array[row].length;
    }
    
    public void nulstilRow(int[][] array, int row) {
        int col = 0;
        while (col < array[row].length) {
            
            array[row][col] = 0;
            col++;
        }
    }
}
