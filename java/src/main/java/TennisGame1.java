import solution1.Player;

import java.util.HashMap;
import java.util.Map;

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

    private static Map<Integer, String> scoreValueNames;
    static {
        scoreValueNames = new HashMap<Integer, String>();
        scoreValueNames.put(0, "Love");
        scoreValueNames.put(1, "Fifteen");
        scoreValueNames.put(2, "Thirty");
        scoreValueNames.put(3, "Forty");
    }


    public String getScore() {
        String scoreString;
        if(scoreEquals()) {
            return firstPlayer.getScore() >= 3 ? "Deuce" : getScoreForAll();

        } else if (firstPlayer.getScore()>=4 || secondPlayer.getScore()>=4) {
            int minusResult = firstPlayer.getScore()-secondPlayer.getScore();
            if (minusResult==1) scoreString ="Advantage player1";
            else if (minusResult ==-1) scoreString ="Advantage player2";
            else if (minusResult>=2) scoreString = "Win for player1";
            else scoreString ="Win for player2";

        } else {
            return getScoreStringValue(firstPlayer.getScore()) + "-" + getScoreStringValue(secondPlayer.getScore());
        }
        return scoreString;
    }

    private String getScoreForAll() {
        return scoreValueNames.get(firstPlayer.getScore()) + "-All";
    }

    private String getScoreStringValue(int score) {
        return scoreValueNames.get(score);
    }

    private boolean scoreEquals() {
        return firstPlayer.getScore() == secondPlayer.getScore();
    }
}
