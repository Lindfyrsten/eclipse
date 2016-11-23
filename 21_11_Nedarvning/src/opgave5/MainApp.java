package opgave5;

/**
 * @author Kristian
 */
public class MainApp {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println();
        Indkøbsvogn vogn = new Indkøbsvogn("Kristian");
        
        Vare sødmælk = new Fødevare("Mælk", "1 ltr sødmælk", 8);
        Vare elTandbørste = new ElArtikel("El-tandbørste", "Til at børste tænder", 150);
        Vare batteri = new ElArtikel("AA-batteri", "Til strøm", 1);
        Vare champagne =
            new Spiritus("Champagne", "Nytårs champagne fra et semi-respekteret område", 100);
        Vare øl = new Spiritus("Sloths øl", "Flaske øl fra knap så respekteret område", 10);
        vogn.tilføjVare(sødmælk);
        vogn.tilføjVare(elTandbørste);
        vogn.tilføjVare(batteri);
        vogn.tilføjVare(champagne);
        vogn.tilføjVare(øl);
        
        System.out.println(vogn.toString());
        System.out.printf("%.2f", vogn.samletPris());
    }
    
}
