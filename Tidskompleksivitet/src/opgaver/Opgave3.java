package opgaver;

import java.util.Arrays;

public class Opgave3 {

    public static double[] prefixAverage(int[] inputTal) {
        double[] outputTal = new double[inputTal.length];
        double avg = 0;
        for (int i = 0; i < inputTal.length; i++) {
            avg += inputTal[i];
            outputTal[i] = avg / (i + 1);
        }
        return outputTal;
    }
    
    public static void main(String[] args) {
        int[] inputTal = { 5, 10, 5, 6, 4, 9, 8 };
        
        System.out.println(Arrays.toString(prefixAverage(inputTal)));

    }

}
