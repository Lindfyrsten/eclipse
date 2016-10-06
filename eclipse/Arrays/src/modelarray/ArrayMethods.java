package modelarray;

/**
 * @author Kristian
 *
 */

public class ArrayMethods {
    public void printArray(int[] tabel) {
        System.out.print("{");
        for (int i = 0; i < tabel.length; i++) {
            if (i == 0) {
                System.out.print(tabel[i]);
            }
            else {
                System.out.print(", " + tabel[i]);
            }
        }
        System.out.println("}  ");
    }
    
    /**
     *
     * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
     */
    public int[] fyldArrayA() {
        int[] result = new int[10];
        return result;
    }

    /**
     *
     * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
     */
    public int[] fyldArrayB() {
        int[] result = new int[10];
        result[0] = 2;
        result[1] = 44;
        result[2] = -23;
        result[3] = 99;
        result[4] = 8;
        result[5] = -5;
        result[6] = 7;
        result[7] = 10;
        result[8] = 20;
        result[9] = 30;
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
     */
    public int[] fyldArrayC() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }
    
    /**
     *
     * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
     */
    public int[] fyldArrayD() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = (i + 1) * 2;
        }
        return result;
    }
    
    /**
     *
     * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
     */
    
    public int[] fyldArrayE() {
        int[] result = new int[10];
        for (int i = 1; i < result.length; i++) {

            result[i] = i * i;
            
        }

        return result;
    }
    
    /**
     *
     * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
     */
    public int[] fyldArrayF() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = i % 2;
            
        }
        return result;
    }
    
    /**
     *
     * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
     */
    public int[] fyldArrayG() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            
            result[i] = i % 5;
            
        }
        return result;
    }

    /**
     * Finder maximum
     */
    public int findMax(int[] tabel) {
        int max = -1;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] > max) {
                max = tabel[i];
            }
        }
        return max;
    }
    
    /**
     * Finder minimum
     */
    public int findMin(int[] tabel) {
        int min = tabel[0];
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] < min) {
                min = tabel[i];
            }
        }
        return min;
    }
    
    /**
     * Sum i int
     */
    public int sum(int[] t) {
        int sum = 0;
        for (int i = 0; i < t.length; i++) {
            sum = sum + t[i];
        }
        return sum;
        
    }
    
    /**
     * Sum i double
     */
    public double sumD(int[] t) {
        double sum = 0.0;
        for (int i = 0; i < t.length; i++) {
            sum = sum + t[i];
        }
        return sum;
        
    }
    
    /**
     * Laver sum af to arrays i et nyt array
     */
    
    public int[] makeSum(int[] a, int[] b) {
        
        int[] c = new int[Math.max(a.length, b.length)];
        
        for (int i = 0; i < c.length; i++) {
            if (a.length > i) {
                c[i] += a[i];
            }
            if (b.length > i) {
                c[i] += b[i];
            }
        }
        return c;
    }

    /**
     * Tjekker om der er et ulige tal
     */
    public boolean hasUneven(int[] t) {
        boolean uneven = false;

        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 == 1) {
                uneven = true;

            }
        }
        return uneven;
    }
}
