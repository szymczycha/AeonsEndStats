package Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(tableName = "games")
public class Game {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public List<Model.Player> Players;

    public String NemesisName;

    public int GraveholdHP;

    public int NemesisHP;

    public Boolean isWon;

    public String ReasonForOutcome;

    public Date date;

    public Boolean HarderVariant;

    public String notes;

    public Game(){

    }
    @Ignore
    public Game(List<Model.Player> players, String nemesisName, int graveholdHP, int nemesisHP, Boolean isWon, String reasonForOutcome, Date date, Boolean harderVariant, String notes) {
        Players = players;
        NemesisName = nemesisName;
        GraveholdHP = graveholdHP;
        NemesisHP = nemesisHP;
        this.isWon = isWon;
        ReasonForOutcome = reasonForOutcome;
        this.date = date;
        HarderVariant = harderVariant;
        this.notes = notes;
    }

    @Ignore
    public List<Model.Player> getPlayers() {
        return Players;
    }

    @Ignore
    public String getNemesisName() {
        return NemesisName;
    }

    @Ignore
    public int getGraveholdHP() {
        return GraveholdHP;
    }

    @Ignore
    public int getNemesisHP() {
        return NemesisHP;
    }

    @Ignore
    public Boolean getWon() {
        return isWon;
    }

    @Ignore
    public String getReasonForOutcome() {
        return ReasonForOutcome;
    }

    @Ignore
    public Boolean getHarderVariant() {
        return HarderVariant;
    }

    @Ignore
    public String getNotes() {
        return notes;
    }

    @Ignore
    public Date getDate() {
        return date;
    }

    @Ignore
    @Override
    public String toString() {
        return "Game{" +
                "Players=" + Players +
                ", NemesisName='" + NemesisName + '\'' +
                ", GraveholdHP=" + GraveholdHP +
                ", NemesisHP=" + NemesisHP +
                ", isWon=" + isWon +
                ", ReasonForOutcome='" + ReasonForOutcome + '\'' +
                ", date=" + date +
                ", HarderVariant=" + HarderVariant +
                ", notes='" + notes + '\'' +
                '}';
    }
}
