package arrmultiapp;

public class TeaterSal {
    
    public int[][] nySal() {
        int[][] bio = new int[8][9];
        
        for (int i = 0; i < bio.length; i++) {
            for (int j = 0; j < bio[i].length; j++) {
                bio[i][j] = 10;
                if (j > 1 && i > 2) {
                    bio[i][j] += 10;
                    if (i > 5) {
                        bio[i][j] += 10;
                    }
                    if (i > 6 && j > 1) {
                        bio[i][j] += 10;
                    }
                    if (i > 5 && j > 3 && j < 6) {
                        bio[i][j] += 10;
                    }
                    if (i > 5 && j > 3) {
                        bio[i][j] += 10;
                    }
                }
            }
        }
        return bio;
    }

    public void udskrivSal(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                System.out.print(array[row][col] + "  ");
            }
            System.out.println();
        }
    }
}
