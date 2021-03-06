import solution1.Player;

class TennisGame1 implements TennisGame {
    
    private final Player firstPlayer;
    private final Player secondPlayer;

    TennisGame1(String firstPlayerName, String secondPlayerName) {
        firstPlayer = new Player(firstPlayerName);
        secondPlayer = new Player(secondPlayerName);
    }

    public void wonPoint(String playerName) {
        getPlayerFromName(playerName).incrementScore();
    }

    public String getScore() {
        if(playersScoreEquals()) {
            return firstPlayer.getScore() >= 3 ? "Deuce" : firstPlayer.getScoreString() + "-All";

        } else if (firstPlayer.getScore()>=4 || secondPlayer.getScore()>=4) {
            return getIsWinOrAdvantage() + getPlayerWithHigherScore().getName();

        } else {
            return firstPlayer.getScoreString() + "-" + secondPlayer.getScoreString();
        }
    }

    private String getIsWinOrAdvantage() {
        return Math.abs(getScoreDifference()) >= 2 ? "Win for " : "Advantage ";
    }

    private Player getPlayerWithHigherScore() {
        return getScoreDifference() > 0 ? firstPlayer : secondPlayer;
    }

    private int getScoreDifference() {
        return firstPlayer.getScore()-secondPlayer.getScore();
    }

    private boolean playersScoreEquals() {
        return firstPlayer.doHaveSameScoreOf(secondPlayer);
    }

    private Player getPlayerFromName(String name) {
        return isFirstPlayer(name) ? firstPlayer : secondPlayer;
    }

    private boolean isFirstPlayer(String playerName) {
        return firstPlayer.getName().equals(playerName);
    }
}
