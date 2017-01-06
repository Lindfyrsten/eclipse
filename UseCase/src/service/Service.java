package service;

import java.util.ArrayList;

import model.Forloeb;
import model.UseCase;
import storage.Storage;

/**
 * @author Lindbjerg
 */
public class Service {
    public static UseCase createUseCase(String navn, String haendelse, String beskrivelse,
        String aktoer,
        String relUseCases, String interessenter, String preBetingelse, String postBetingelse,
        String alternativForloeb, ArrayList<Forloeb> forloebList) {
        UseCase uCase = new UseCase(navn, haendelse, beskrivelse, aktoer, relUseCases,
            interessenter, preBetingelse, postBetingelse, alternativForloeb);
        Storage.addUseCase(uCase);
        return uCase;
    }
    
    public static void addForloeb(UseCase uCase, Forloeb forloeb) {
        uCase.addForloeb(forloeb);
    }
}
