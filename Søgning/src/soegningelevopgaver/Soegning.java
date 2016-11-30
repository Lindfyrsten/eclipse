package soegningelevopgaver;

import java.util.ArrayList;

public class Soegning {
    
    public boolean findUlige(int[] tabel) {
        
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {

            if (tabel[i] % 2 != 0) {
                
                found = true;
                return found;
            }
            else {
                i++;
            }
        }
        return found;
        
    }
    
    // her skriver du metoder tilopgaverne 2,3,5,6 og 7
    
    //opgave 2 - finder første heltal i intervallet [10,15]
    
    public int findHeltalInterval(int[] tabel) {
        
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {
            if (tabel[i] % 2 == 0 && tabel[i] < 15 && tabel[i] > 9) {
                
                found = true;
                return tabel[i];
            }
            else {
                i++;
            }
        }
        return -1;
        
    }
    
    //opgave 3 - nabotal ens?
    
    public boolean findNeighbourDuplicate(int[] tabel) {
        
        boolean found = false;
        int i = 0;
        int oldValue = -1;
        while (!found && i < tabel.length) {
            if (tabel[i] == oldValue) {
                
                found = true;
                return found;
            }
            else {
                oldValue = tabel[i];
                i++;
            }
        }
        return found;
        
    }

    //opgave 5 - find kvadratroden lineært og binær
    
    public int findSquareRootLineær(int tal) {
        
        boolean found = false;
        int i = 0;
        while (!found) {
            if (i * i <= tal && tal < (i + 1) * (i + 1)) {
                found = true;
                
            }
            i++;

        }
        
        return i - 1;
    }

    public int findSquareRootBinær(int tal) {

        boolean found = false;
        int left = 0;
        int right = tal;
        int middle = -1;
        while (!found && left <= right) {
            middle = (left + right) / 2;

            if (middle * middle <= tal && tal < (middle + 1) * (middle + 1)) {
                found = true;
            }
            else if (middle * middle >= tal && tal < (middle + 1) * (middle + 1)) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        if (found) {
            return middle;
        }
        else {
            return -1;
        }
    }

    //Opgave 6

    public int swapFind(ArrayList<Integer> arr, int tal) {
        boolean found = false;
        int i = 0;
        while (!found && i < arr.size()) {
            if (arr.get(i) == tal && i != 0) {
                int temp = arr.get(i);
                arr.set(i, arr.get(i - 1));
                arr.set(i - 1, temp);
                found = true;
                return i - 1;
            }
            i++;
        }
        return -1;
    }
}