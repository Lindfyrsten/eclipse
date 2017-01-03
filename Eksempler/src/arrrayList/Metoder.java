package arrrayList;

import java.util.ArrayList;

/**
 * @author Kristian Lindbjerg
 */
public class Metoder {
    /**
    *
    * @param list
    * @return sums the mumbers in the list using a for loop
    */
    public int sumListe(ArrayList<Integer> list) {
        int resultat = 0;
        for (int i = 0; i < list.size(); i++) {
            resultat = resultat + list.get(i);
        }
        return resultat;
    }
    
    /**
    *
    * @param list
    * @return sums the mumbers in the list using a forEach loop
    */
    public int sumListe2(ArrayList<Integer> list) {
        int resultat = 0;
        for (int tal : list) {
            resultat = resultat + tal;
        }
        return resultat;
    }
    
    /**
    *
    * @param list
    * @return index at the first even number
    */
    public int hasEvenAtIndex(ArrayList<Integer> list) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < list.size()) {
            if (list.get(i) % 2 == 0) {
                index = i;
            }
            i++;
        }
        return index;
        
    }
    
    public int min(ArrayList<Integer> list) {
        int min = list.get(1);
        for (int tal : list) {
            if (tal < min) {
                min = tal;
            }
            
        }
        return min;
        
    }
    
    public double average(ArrayList<Integer> list) {
        int sum = 0;
        for (int tal : list) {
            sum = tal + sum;
        }
        int average = sum / list.size();
        return average;
    }
    
    public int countZeros(ArrayList<Integer> list) {
        int zero = 0;
        for (int tal : list) {
            if (tal == 0) {
                zero++;
            }
        }
        return zero;
    }
    
    public void swapEvenWithZero(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.set(i, 0);
            }
        }
        
    }
    
    public ArrayList<Integer> aEvenList(ArrayList<Integer> list) {
        ArrayList<Integer> aEvenList = new ArrayList<>();
        for (int i : list) {
            if (i % 2 == 0) {
                aEvenList.add(i);
                
            }
        }
        
        return aEvenList;
    }
}
