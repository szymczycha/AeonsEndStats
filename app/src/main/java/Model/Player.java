package Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Player {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String mageName;

    public String playerName;

    public Player(){

    }
    @Ignore
    public String getMageName() {
        return mageName;
    }

    @Ignore
    public String getPlayerName() {
        return playerName;
    }

    @Ignore
    public Player(String mageName, String playerName) {
        this.mageName = mageName;
        this.playerName = playerName;
    }
}
