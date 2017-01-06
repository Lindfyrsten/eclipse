package storage;

import java.util.ArrayList;

import model.UseCase;

public class Storage {
    private static ArrayList<UseCase> useCaseList = new ArrayList<>();

    public static ArrayList<UseCase> getUseCaseList() {
        return new ArrayList<>(useCaseList);
    }
    
    public static void addUseCase(UseCase uCase) {
        useCaseList.add(uCase);
    }
}
