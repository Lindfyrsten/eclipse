package team;

public class TeamApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Player player = new Player("Kristian", 29);
        Player player1 = new Player("Ronaldo", 31);
        Player player2 = new Player("Messi", 12);

        player.setScore(15);
        player.addScore(3);
        player1.addScore(10);
        player2.addScore(3);

        Team t = new Team("A-team");
        
        t.addPlayer(player);
        t.addPlayer(player1);
        t.addPlayer(player2);
        t.printPlayers();
        System.out.println("Gennemsnitsalder: " + t.calcAverageAge());
        System.out.println("Mål i alt : " + t.totalScore());
        System.out.println("Mål over aldersgrænsen " + t.calcOldPlayerScore(29));
        System.out.println("Topscorer : " + t.bestPlayer() + "| Mål: " + t.maxScore());
    }
    
}
