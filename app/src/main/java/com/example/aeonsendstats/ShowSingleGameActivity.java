package com.example.aeonsendstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

public class ShowSingleGameActivity extends AppCompatActivity {
    private TextView NemesisNameTV;
    private TextView NemesisHPTV;
    private TextView GraveholdHPTV;
    private TextView WonTV;
    private LinearLayout PlayerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_single_game);

        Intent intent = getIntent();
        String jsonString = intent.getStringExtra("game");
        Gson gson = new Gson();
        model.Game game = gson.fromJson(jsonString, model.Game.class);
        NemesisNameTV = findViewById(R.id.nemesis_name_tv);
        NemesisHPTV = findViewById(R.id.nemesis_hp_tv);
        GraveholdHPTV = findViewById(R.id.gravehold_hp_tv);
        WonTV = findViewById(R.id.won_tv);
        PlayerList = findViewById(R.id.players_list);
        if(game != null){
            NemesisNameTV.setText(game.getNemesisName());
            NemesisHPTV.setText(String.valueOf(game.getNemesisHP()));
            GraveholdHPTV.setText(String.valueOf(game.getGraveholdHP()));
            WonTV.setText(game.getWon()?"won":"lost");
            for (model.Player player:
                 game.getPlayers()) {
                LinearLayout ll = new LinearLayout(ShowSingleGameActivity.this);
                ll.setOrientation(LinearLayout.VERTICAL);
                TextView PlayerNameTV = new TextView(ShowSingleGameActivity.this);
                TextView PlayerMageNameTV = new TextView(ShowSingleGameActivity.this);
                PlayerNameTV.setText(player.getPlayerName());
                PlayerMageNameTV.setText(player.getMageName());
                ll.addView(PlayerNameTV);
                ll.addView(PlayerMageNameTV);
                PlayerList.addView(ll);
            }


        }
    }
}