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

    private static Map<Integer, String> equalPointsMap;
    static {
        equalPointsMap = new HashMap<Integer, String>();
        equalPointsMap.put(0, "Love-All");
        equalPointsMap.put(1, "Fifteen-All");
        equalPointsMap.put(2, "Thirty-All");
    }

    public String getScore() {
        String scoreString = "";
        int tempScore=0;
        if(scoreEquals() && firstPlayer.getScore() >= 3) {
            return "Deuce";
        } else if (scoreEquals()) {
            scoreString = equalPointsMap.get(firstPlayer.getScore());
        }
        else if (firstPlayer.getScore()>=4 || secondPlayer.getScore()>=4)
        {
            int minusResult = firstPlayer.getScore()-secondPlayer.getScore();
            if (minusResult==1) scoreString ="Advantage player1";
            else if (minusResult ==-1) scoreString ="Advantage player2";
            else if (minusResult>=2) scoreString = "Win for player1";
            else scoreString ="Win for player2";
        }
        else {
            scoreString = getScoreStringValue(firstPlayer);
            scoreString += "-";
            scoreString += getScoreStringValue(secondPlayer);
        }
        return scoreString;
    }

    private String getScoreStringValue(Player player) {
        switch(player.getScore()) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return null;
        }
    }

    private boolean scoreEquals() {
        return firstPlayer.getScore() == secondPlayer.getScore();
    }
}
