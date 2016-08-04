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
        String score = "";
        int tempScore=0;
        if(scoreEquals() && firstPlayer.getScore() >= 3) {
            return "Deuce";
        } else if (scoreEquals()) {
            score = equalPointsMap.get(firstPlayer.getScore());
        }
        else if (firstPlayer.getScore()>=4 || secondPlayer.getScore()>=4)
        {
            int minusResult = firstPlayer.getScore()-secondPlayer.getScore();
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = firstPlayer.getScore();
                else { score+="-"; tempScore = secondPlayer.getScore();}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }

    private boolean scoreEquals() {
        return firstPlayer.getScore()==secondPlayer.getScore();
    }
}
