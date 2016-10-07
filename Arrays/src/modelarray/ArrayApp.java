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

        System.out.print("Tabel 2: ");
        metode.printArray(tabel2);
        System.out.println("Max værdi: " + metode.findMax(tabel2));
        System.out.println("Min værdi: " + metode.findMin(tabel2));
        System.out.println("Sum i int: " + metode.sum(tabel2));
        System.out.println("Sum i double: " + metode.sumD(tabel2));
        System.out.println("Der er ulige tal: " + metode.hasUneven(tabel2));
        System.out.println("Sum af tabel 2 og 3: ");
        System.out.println(Arrays.toString(metode.makeSum(tabel2, tabel3)));
        System.out.println("___________________________________________________");
        System.out.print("Tabel 3: ");
        metode.printArray(tabel3);
        System.out.println("Bytter rundt på  plads 1. og 10. tal: ");
        metode.reverse(0, 9, tabel3);
        metode.printArray(tabel3);
        metode.reversePush(tabel3, 0);
        System.out.println("Array bliver skubbet 1 plads og sidste plads rykkker hen på 1. plads.");
        metode.printArray(tabel3);
        System.out.println("Erstatter de lige tal med 0: ");
        metode.replaceEven(tabel3);
        metode.printArray(tabel3);
        System.out.println("Andet højeste tal i array: " + metode.findAlmostMax(tabel3));
        System.out.println("Array er stigende: " + metode.stigende(tabel3));
        tabel3[9] = 1;
        System.out.println("Array er stigende: " + metode.stigende(tabel3));
        System.out.println("Der er duplicates: " + metode.dupes(tabel3));
        metode.printArray(tabel2);
        System.out.println("Der er duplicates: " + metode.dupes(tabel2));
    }
    
}
