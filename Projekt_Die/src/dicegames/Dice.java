package dicegames;

public class Dice {
    
    public Dice() {
    }
    
    public int d1(int di) {
        
        if (di == 1) {
            System.out.println("██████████");
            System.out.println("██████████");
            System.out.println("███   ████");
            System.out.println("██████████");
            System.out.println("██████████");

        }
        else if (di == 2) {
            System.out.println("██████████");
            System.out.println("██  ██████");
            System.out.println("██████████");
            System.out.println("██████  ██");
            System.out.println("██████████");
        }
        else if (di == 3) {
            System.out.println("██████████");
            System.out.println("█  ███████");
            System.out.println("████  ████");
            System.out.println("███████  █");
            System.out.println("██████████");
        }
        else if (di == 4) {
            System.out.println("██████████");
            System.out.println("██  ██  ██");
            System.out.println("██████████");
            System.out.println("██  ██  ██");
            System.out.println("██████████");
            
        }
        else if (di == 5) {
            System.out.println("█▀▀████▀▀█");
            System.out.println("█▄▄████▄▄█");
            System.out.println("███   ████");
            System.out.println("█▀▀████▀▀█");
            System.out.println("█▄▄████▄▄█");
        }
        else if (di == 6) {
            System.out.println("█▀▀████▀▀█");
            System.out.println("█▄▄████▄▄█");
            System.out.println("█  ████  █");
            System.out.println("█▀▀████▀▀█");
            System.out.println("█▄▄████▄▄█");
            
        }
        return di;
    }

}