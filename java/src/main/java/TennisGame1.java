import java.util.HashMap;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (isPlayerOne(playerName))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    private boolean isPlayerOne(String playerName) {
        return playerName.equals(player1Name);
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
        if(scoreEquals() && m_score1 >= 3) {
            return "Deuce";
        } else if (scoreEquals()) {
            score = equalPointsMap.get(m_score1);
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = m_score1;
                else { score+="-"; tempScore = m_score2;}
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
        return m_score1==m_score2;
    }
}
