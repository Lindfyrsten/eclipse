package array_multidimensional;

/**
 * @author Kristian Lindbjerg
 */
public class Eksempel {
    
    public static void main(String[] args) {
        int[][] array1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        int[][] array2 = { { 1, 2 }, { 0, 3 }, { 4, 5, 6 } };
        Metoder da = new Metoder();
        da.udskrivArray(array1);
        System.out.println();
        da.udskrivArray(array2);
        
        // gennemsnit
        System.out.println(da.gennemsnitRow(array1, 1));

        // samlet row
        System.out.println(da.samletRow(array1, 0));
        System.out.println(array1.toString());
        
    }
}
