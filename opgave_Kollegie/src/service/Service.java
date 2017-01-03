package service;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Bolig;
import model.Kollegie;
import model.Lejeaftale;
import model.Lejer;
import storage.Storage;

/**
 * @author Kristian Lindbjerg
 */
public class Service {
    public static Kollegie opretKollegie(String navn, String adresse) {
        Kollegie kollegie = new Kollegie(navn, adresse);
        Storage.addKollegie(kollegie);
        return kollegie;
    }

    public static Lejer opretLejer(String navn, String uddannelse) {
        Lejer lejer = new Lejer(navn, uddannelse);
        Storage.addLejer(lejer);
        return lejer;
    }
    
    public static ArrayList<String> nyeLejere(ArrayList<Lejer> tidligereLejere, Lejer[] ansoegere) {
        return null;
        
    }

    public static void createSomeObjects() {
        Kollegie k1 = opretKollegie("Ranvsbjergs", "Risdalsvej 48");
        Kollegie k2 = opretKollegie("Christian X", "Christian X's vej 120");
        Bolig b1 = k1.createBolig("1", 28, 2100);
        Bolig b2 = k1.createBolig("3", 28, 2100);
        Bolig b3 = k1.createBolig("2", 54, 4000);
        Bolig b4 = k2.createBolig("1", 28, 2100);
        Bolig b5 = k2.createBolig("2", 28, 2100);
        Bolig b6 = k2.createBolig("3", 28, 2100);
        Lejer l1 = opretLejer("Kristian Lindbjerg", "Datamatiker");
        Lejer l2 = opretLejer("Damian Marley", "Musiker");
        Lejer l3 = opretLejer("Albert Einstein", "Fysiker");
        Lejer l4 = opretLejer("Donald Trump", "Dropout");
        Lejer l5 = opretLejer("Usain Bolt", "Idræt");
        
        Lejeaftale la1 = b1.createLejeaftale(LocalDate.now());
        Lejeaftale la2 = b2.createLejeaftale(LocalDate.now());
        Lejeaftale la3 = b5.createLejeaftale(LocalDate.now());
        Lejeaftale la4 = b6.createLejeaftale(LocalDate.now());

        la1.addLejer(l1);
        la2.addLejer(l2);
        la2.addLejer(l3);
        la3.addLejer(l4);
        la4.addLejer(l5);
        
    }
}
