package solution1;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private String name;
    private int score;
    private static Map<Integer, String> scoreValueNames;
    static {
        scoreValueNames = new HashMap<Integer, String>();
        scoreValueNames.put(0, "Love");
        scoreValueNames.put(1, "Fifteen");
        scoreValueNames.put(2, "Thirty");
        scoreValueNames.put(3, "Forty");
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore() {
        score ++;
    }

    public String getScoreString() {
        return scoreValueNames.get(score);
    }
}
