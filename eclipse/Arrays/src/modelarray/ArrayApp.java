package modelarray;

import java.util.Arrays;

public class ArrayApp {
    
    public static void main(String[] args) {
        ArrayMethods metode = new ArrayMethods();

        int[] tabel = metode.fyldArrayA();
        System.out.println(Arrays.toString(tabel));

        tabel = metode.fyldArrayB();
        System.out.println(Arrays.toString(tabel));

        tabel = metode.fyldArrayC();
        System.out.println(Arrays.toString(tabel));

        tabel = metode.fyldArrayD();
        System.out.println(Arrays.toString(tabel));

        tabel = metode.fyldArrayE();
        System.out.println(Arrays.toString(tabel));

        tabel = metode.fyldArrayF();
        System.out.println(Arrays.toString(tabel));

        tabel = metode.fyldArrayG();
        System.out.println(Arrays.toString(tabel));
        
        int[] tabel2 = { 78, 24, 2, 4 };
        int[] tabel3 = { 78, 23, 1, 4, 65, 3, 87, 5, 12, 1 };
//        metode.printArray(tabel2);
        System.out.println(metode.findMax(tabel2));
        System.out.println(metode.findMin(tabel2));
        System.out.println(metode.sum(tabel2));
        System.out.println(metode.sumD(tabel2));
        System.out.println(Arrays.toString(metode.makeSum(tabel2, tabel3)));
        System.out.println(metode.hasUneven(tabel2));
        
    }
    
}
