package com.example.aeonsendstats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;

import Adapter.GamesListViewAdapter;
import Database.GamesDatabase;
import Model.Game;
import Model.Player;

public class MainActivity extends AppCompatActivity {
    private ListView gamesListLV;
    private ArrayList<Game> gamesList;
    private FloatingActionButton addGameButton;
    private GamesDatabase gamesDatabase;
    private GamesListViewAdapter adapter;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gamesListLV = (ListView) findViewById(R.id.games_list);
        addGameButton = (FloatingActionButton) findViewById(R.id.games_add_button);
        gamesList = new ArrayList<>();
        gamesDatabase = Room.databaseBuilder(getApplicationContext(), GamesDatabase.class, getString(R.string.games_database_name)).build();
        adapter = new GamesListViewAdapter(
                gamesList,
                getLayoutInflater(),
                gamesDatabase,
                MainActivity.this
        );
        gamesListLV.setAdapter(adapter);
        handler = new Handler();

        Thread initialRefresh = new Thread(new Runnable() {
            @Override
            public void run() {
                refreshGames(handler);
            }
        });
        initialRefresh.start();

        addGameButton.setOnClickListener(v -> {
            Thread addGameThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    addGameToDatabase();
                }
            });
            addGameThread.start();

            try {
                addGameThread.join();
            } catch (InterruptedException e) {
                Log.e("xxx", "When adding new game something happened");
            }
            Thread refreshGames = new Thread(new Runnable() {
                @Override
                public void run() {
                    refreshGames(handler);
                    Log.d("xxx", "# of games: "+gamesList.size());
                }
            });
            refreshGames.start();
        });
    }
    private void refreshGames(Handler handler){
        ArrayList<Game> listOfGames = (ArrayList<Game>) gamesDatabase.getGamesDao().getAll();
        gamesList.clear();
        gamesList.addAll(listOfGames);
        handler.post(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }
    private void addGameToDatabase(){
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
                "Gnieworodny" + (gamesList.size() + 1),
                7,
                0,
                true,
                "0 HP nemesis",
                new Date(),
                false,
                null
        );
        gamesDatabase.getGamesDao().addGame(game1);
    }
}