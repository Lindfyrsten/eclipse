package team;

import java.util.ArrayList;

public class Team {
    
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        
        players = new ArrayList<>();
        players.clear();

    }

    public String getName() {
        return name;
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public void printPlayers() {

        for (Player s : players) {

            System.out.println(
                "Navn: " + s.getName() + "| Alder: " + s.getAge() + "| Mål: " + s.getScore());

        }
    }
    
    public double calcAverageAge() {
        double sum = 0;
        for (Player s : players) {
            sum = sum + s.getAge();
        }
        return (sum / players.size());
    }
    
    public int totalScore() {
        int sum = 0;
        
        for (Player s : players) {
            sum = sum + s.getScore();
        }
        return sum;
    }

    public int calcOldPlayerScore(int ageLimit) {
        int sum = 0;

        for (Player s : players) {
            if (s.getAge() >= ageLimit) {
                sum = sum + s.getScore();
            }
        }
        return sum;
    }
    
    public int maxScore() {
        int max = -1;
        
        for (Player s : players) {
            if (s.getScore() > max) {
                max = s.getScore();
            }
        }
        return max;
    }
    
    public String bestPlayer() {
        int max = -1;
        String bestPlayer = null;

        for (Player s : players) {
            if (s.getScore() > max) {
                max = s.getScore();
                bestPlayer = s.getName();
            }
        }
        return bestPlayer;
    }
}
