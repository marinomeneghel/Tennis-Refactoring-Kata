import solution1.Player;

import java.util.HashMap;

public class TennisGame1 implements TennisGame {
    
    private final Player firstPlayer;
    private final Player secondPlayer;

    public TennisGame1(String firstPlayerName, String secondPlayerName) {
        firstPlayer = new Player(firstPlayerName);
        secondPlayer = new Player(secondPlayerName);
    }

    public void wonPoint(String playerName) {
        getPlayerFromName(playerName).incrementScore();
    }

    private Player getPlayerFromName(String name) {
        return isFirstPlayer(name) ? firstPlayer : secondPlayer;
    }

    private boolean isFirstPlayer(String playerName) {
        return firstPlayer.getName().equals(playerName);
    }

    public String getScore() {
        String scoreString;
        if(scoreEquals()) {
            return firstPlayer.getScore() >= 3 ? "Deuce" : firstPlayer.getScoreString() + "-All";

        } else if (firstPlayer.getScore()>=4 || secondPlayer.getScore()>=4) {
            int minusResult = firstPlayer.getScore()-secondPlayer.getScore();
            if (minusResult==1) scoreString ="Advantage player1";
            else if (minusResult ==-1) scoreString ="Advantage player2";
            else if (minusResult>=2) scoreString = "Win for player1";
            else scoreString ="Win for player2";

        } else {
            return firstPlayer.getScoreString() + "-" + secondPlayer.getScoreString();
        }
        return scoreString;
    }

    private boolean scoreEquals() {
        return firstPlayer.getScore() == secondPlayer.getScore();
    }
}
