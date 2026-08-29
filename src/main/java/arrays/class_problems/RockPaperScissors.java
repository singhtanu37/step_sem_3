import java.util.Random;
public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        if (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors") ||
            playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock") ||
            playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper")) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();
        int wins = 0, losses = 0, draws = 0;
        
        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 1; i <= 5; i++) {
            String pMove = moves[rand.nextInt(3)]; 
            String cMove = moves[rand.nextInt(3)];
            String res = playRound(pMove, cMove);
            if (res.equals("Player Wins")) wins++;
            else if (res.equals("Computer Wins")) losses++;
            else draws++;
            System.out.printf("Round %d | Player: %s | Computer: %s | Result: %s\n", i, pMove, cMove, res);
        }
        System.out.printf("\nFinal Summary | Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, (wins/5.0)*100);
    }
}
