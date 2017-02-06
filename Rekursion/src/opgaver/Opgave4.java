package opgaver;

public class Opgave4 {
    public static String reverse(String s) {

        int index = s.length() - 1;
        if (index < 0) {
            return "";
        }
        else {
            
            return s.charAt(index) + reverse(s.substring(0, index));
        }

    }
    
    public static void main(String[] args) {
        System.out.println(reverse("RANSLIRPA"));

    }

}
