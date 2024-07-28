package com.example.aeonsendstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import Adapter.GamesListViewAdapter;
import model.Game;
import model.Player;

public class MainActivity extends AppCompatActivity {
    private ListView gamesListLV;
    private ArrayList<Game> gamesList;
    private Button addGameButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gamesListLV = (ListView) findViewById(R.id.games_list);
        addGameButton = (Button) findViewById(R.id.games_add_button);
        gamesList = new ArrayList<>();

        GamesListViewAdapter adapter = new GamesListViewAdapter(gamesList, getLayoutInflater(), MainActivity.this);
        gamesListLV.setAdapter(adapter);
        addGameButton.setOnClickListener(v -> {
            addGame();
            adapter.notifyDataSetChanged();
            Log.d("xxx", "# of games: "+gamesList.size());
        });
    }
    private void addGame(){
        ArrayList<Player> game1players = new ArrayList<>();
        game1players.add(new Player(
                "Jian",
                "Szymon"
        ));
        game1players.add(new Player(
                "Brima",
                "Bartek"
        ));
        Game game1 = new Game(
                game1players,
                "Gnieworodny",
                7,
                0,
                true,
                "0 HP nemesis",
                new Date(),
                false,
                null
        );
        gamesList.add(game1);
    }
}