package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Game {
    List<model.Player> Players;
    String NemesisName;
    int GraveholdHP;
    int NemesisHP;
    Boolean isWon;
    String ReasonForOutcome;
    Date date;
    Boolean HarderVariant;
    String notes;

    public Game(List<model.Player> players, String nemesisName, int graveholdHP, int nemesisHP, Boolean isWon, String reasonForOutcome, Date date, Boolean harderVariant, String notes) {
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

    public List<model.Player> getPlayers() {
        return Players;
    }

    public String getNemesisName() {
        return NemesisName;
    }

    public int getGraveholdHP() {
        return GraveholdHP;
    }

    public int getNemesisHP() {
        return NemesisHP;
    }

    public Boolean getWon() {
        return isWon;
    }

    public String getReasonForOutcome() {
        return ReasonForOutcome;
    }

    public Boolean getHarderVariant() {
        return HarderVariant;
    }

    public String getNotes() {
        return notes;
    }

    public Date getDate() {
        return date;
    }

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
