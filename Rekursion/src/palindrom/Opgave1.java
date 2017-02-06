package palindrom;

public class Opgave1 {
    
    public static boolean palindrom(String tekst) {
        return palindrom(tekst, 0, tekst.length() - 1);
        
    }

    public static boolean palindrom(String tekst, int left, int right) {
        if (right - left <= 0) {
            return true;
        }
        
        if (tekst.charAt(left) != tekst.charAt(right)) {
            return false;
            
        }
        else {
            return palindrom(tekst, left + 1, right - 1);
        }

    }
    
    public static void main(String[] args) {
        System.out.println(palindrom("TERTRET"));
    }

}
