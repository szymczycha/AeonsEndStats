package model;

public class Player {
    String mageName;
    String playerName;

    public String getMageName() {
        return mageName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Player(String mageName, String playerName) {
        this.mageName = mageName;
        this.playerName = playerName;
    }
}
