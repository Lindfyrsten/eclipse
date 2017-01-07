package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UseCase {
    private String navn, haendelse, beskrivelse, aktoer, relUseCases, interessenter, preBetingelse,
        postBetingelse, normalForloeb, alternativForloeb;
    private ArrayList<Forloeb> forloebList = new ArrayList<>();

    public UseCase(String navn, String haendelse, String beskrivelse, String aktoer,
        String relUseCases, String interessenter, String preBetingelse, String postBetingelse,
        String alternativForloeb, ArrayList<Forloeb> forloebList) {
        this.navn = navn;
        this.haendelse = haendelse;
        this.beskrivelse = beskrivelse;
        this.aktoer = aktoer;
        this.relUseCases = relUseCases;
        this.interessenter = interessenter;
        this.preBetingelse = preBetingelse;
        this.postBetingelse = postBetingelse;
        this.alternativForloeb = alternativForloeb;
        this.forloebList = forloebList;
    }
    
    public String getNavn() {
        return navn;
    }
    
    public String getHaendelse() {
        return haendelse;
    }
    
    public String getBeskrivelse() {
        return beskrivelse;
    }
    
    public String getAktoer() {
        return aktoer;
    }
    
    public String getRelUseCases() {
        return relUseCases;
    }
    
    public String getInteressenter() {
        return interessenter;
    }
    
    public String getPreBetingelse() {
        return preBetingelse;
    }
    
    public String getPostBetingelse() {
        return postBetingelse;
    }
    
    public String getNormalForloeb() {
        return normalForloeb;
    }
    
    public String getAlternativForloeb() {
        return alternativForloeb;
    }
    
    public ArrayList<Forloeb> getForloeb() {
        return new ArrayList<>(forloebList);
    }
    
    public void addForloeb(Forloeb forloeb) {
        forloebList.add(forloeb);
    }
    
    public void printCase() {

        File file = new File("UseCase.txt");
        try {
            PrintWriter p = new PrintWriter(file);
            p.println("+---------------------+-------------------------------------------------");
            p.print(String.format("|%-20s | %-20s\r\n", "Use case id og navn", navn));
            p.println("+---------------------+-------------------------------------------------");
            p.print(String.format("|%-20s | %-20s\r\n", "Trigger hændelse", haendelse));
            p.println("+---------------------+-------------------------------------------------");
            p.print(String.format("|%-20s | %-20s\r\n", "Kort beskrivelse", beskrivelse));
            p.println("+---------------------+-------------------------------------------------");
            p.print(String.format("|%-20s | %-20s\r\n", "Aktører", aktoer));
            p.println("+---------------------+-------------------------------------------------");
            p.print(String.format("|%-20s | %-20s\r\n", "Rel. use cases",
                relUseCases));
            p.println("+---------------------+-------------------------------------------------");
            p.print(String.format("|%-20s | %-20s\r\n", "Interessenter", interessenter));
            p.println("+---------------------+-------------------------------------------------");
            p.print(String.format("|%-20s | %-20s\r\n", "Præbetingelse", preBetingelse));
            p.println("+---------------------+-------------------------------------------------");
            p.print(String.format("|%-20s | %-20s\r\n", "Postbetingelse", postBetingelse));
            p.println("+---------------------+-------------------------------------------------");
            p.print(String.format("%-16s HOVED FORLØB %-14s\r\n", "", ""));
            p.println("+-----------------------------------------------------------------------");
            p.print(String.format("|%-25s  %-30s\r\n", "       Aktør", "       System"));
            p.println("+-----------------------------------------------------------------------");
            for (int i = 0; i < forloebList.size(); i++) {
                if (!forloebList.get(i).getSystembesker().isEmpty()) {
                    p.print(String.format("|%-30s\r\n",
                        (i + 1) + ". " + forloebList.get(i).getAktoer()));
                    int count = 1;
                    for (int j = 0; j < forloebList.get(i).getSystembesker().size(); j++) {
                        p.print(String.format("|%-30s %-30s\r\n", "",
                            (i + 1) + "." + count + " "
                                + forloebList.get(i).getSystembesker().get(j)));
                        count++;
                    }
                    
                }
                else {
                    p.printf("|%-30s\r\n",
                        (i + 1) + ". " + forloebList.get(i).getAktoer());
                }
                p.println("| ");
            }
            p.println("+-----------------------------------------------------------------------");
            p.print(String.format("|%-20s | %-20s\r\n", "Alternativt forløb", alternativForloeb));
            p.println("+-----------------------------------------------------------------------");
            p.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
