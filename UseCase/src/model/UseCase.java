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
        String alternativForloeb) {
        this.navn = navn;
        this.haendelse = haendelse;
        this.beskrivelse = beskrivelse;
        this.aktoer = aktoer;
        this.relUseCases = relUseCases;
        this.interessenter = interessenter;
        this.preBetingelse = preBetingelse;
        this.postBetingelse = postBetingelse;
        this.alternativForloeb = alternativForloeb;
    }
    
    public String getNavn() {
        return navn;
    }
    
    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    public String getHaendelse() {
        return haendelse;
    }
    
    public void setHaendelse(String haendelse) {
        this.haendelse = haendelse;
    }
    
    public String getBeskrivelse() {
        return beskrivelse;
    }
    
    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
    
    public String getAktoer() {
        return aktoer;
    }
    
    public void setAktoer(String aktoer) {
        this.aktoer = aktoer;
    }
    
    public String getRelUseCases() {
        return relUseCases;
    }
    
    public void setRelUseCases(String relUseCases) {
        this.relUseCases = relUseCases;
    }
    
    public String getInteressenter() {
        return interessenter;
    }
    
    public void setInteressenter(String interessenter) {
        this.interessenter = interessenter;
    }
    
    public String getPreBetingelse() {
        return preBetingelse;
    }
    
    public void setPreBetingelse(String preBetingelse) {
        this.preBetingelse = preBetingelse;
    }
    
    public String getPostBetingelse() {
        return postBetingelse;
    }
    
    public void setPostBetingelse(String postBetingelse) {
        this.postBetingelse = postBetingelse;
    }
    
    public String getNormalForloeb() {
        return normalForloeb;
    }
    
    public void setNormalForloeb(String normalForloeb) {
        this.normalForloeb = normalForloeb;
    }
    
    public String getAlternativForloeb() {
        return alternativForloeb;
    }
    
    public void setAlternativForloeb(String alternativForloeb) {
        this.alternativForloeb = alternativForloeb;
    }
    
    public ArrayList<Forloeb> getForloeb() {
        return new ArrayList<>(forloebList);
    }
    
    public void addForloeb(Forloeb forloeb) {
        forloebList.add(forloeb);
    }
    
    //
    public void printCase() {

        File file = new File("UseCase.txt");
        try {
            PrintWriter p = new PrintWriter(file);
            p.println("+---------------------+----------------------+");
            p.print(String.format("|%-20s | %-20s %1s\r\n", "Use case id og navn", navn, "|"));
            p.println("+---------------------+----------------------+");
            p.print(String.format("|%-20s | %-20s %1s\r\n", "Trigger hændelse", haendelse, "|"));
            p.println("+---------------------+----------------------+");
            p.print(String.format("|%-20s | %-20s %1s\r\n", "Kort beskrivelse", beskrivelse, "|"));
            p.println("+---------------------+----------------------+");
            p.print(String.format("|%-20s | %-20s %1s\r\n", "Aktører", aktoer, "|"));
            p.println("+---------------------+----------------------+");
            p.print(String.format("|%-20s | %-20s %1s\r\n", "Rel. use cases",
                relUseCases, "|"));
            p.println("+---------------------+----------------------+");
            p.print(String.format("|%-20s | %-20s %1s\r\n", "Interessenter", interessenter, "|"));
            p.println("+---------------------+----------------------+");
            p.print(String.format("|%-20s | %-20s %1s\r\n", "Præbetingelse", preBetingelse, "|"));
            p.println("+---------------------+----------------------+");
            p.print(String.format("|%-20s | %-20s %1s\r\n", "Postbetingelse", postBetingelse, "|"));
            p.println("+---------------------+----------------------+");
            p.print(String.format("|%-15s HOVED FORLØB %-14s %1s\r\n", "", "", "|"));
            p.println("+---------------------+----------------------+");
            p.print(String.format("|%-20s | %-20s %1s\r\n", "       Aktør", "       System", "|"));
            p.println("+---------------------+----------------------+");
            for (int i = 0; i < forloebList.size(); i++) {
                p.print(String.format("|%-20s | %-20s %1s\r\n",
                    (i + 1) + ". " + forloebList.get(i).getAktoer(),
                    (i + 1) + "." + i + " " + forloebList.get(i).getSystembesker().get(0), "|"));
                if (forloebList.get(i).getSystembesker().size() > 1) {
                    int count = 1;
                    for (int j = 1; j < forloebList.get(i).getSystembesker().size(); j++) {
                        p.print(String.format("|%-20s | %-20s %1s\r\n",
                            "",
                            (i + 1) + "." + count + " "
                                + forloebList.get(i).getSystembesker().get(j),
                            "|"));
                        count++;
                    }
                    
                }
                p.println("|                     |                      |");
            }
            p.println("+---------------------+----------------------+");
            p.print(String.format("|%-20s | %-20s %1s\r\n", "Alternativt forløb", alternativForloeb,
                "|"));
            p.println("+---------------------+----------------------+");
            p.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
