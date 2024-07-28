package Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aeonsendstats.R;
import com.example.aeonsendstats.ShowSingleGameActivity;
import com.google.gson.Gson;

import java.util.List;

import model.Game;

public class GamesListViewAdapter extends BaseAdapter {
    private List<Game> gamesList;
    private LayoutInflater layoutInflater;
    private Context context;
    public GamesListViewAdapter(List<Game> gamesList, LayoutInflater layoutInflater, Context context){
        this.gamesList = gamesList;
        this.context = context;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return gamesList.size();
    }

    @Override
    public Game getItem(int i) {
        return gamesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
//        not sure what this is which is bad :>
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.games_list_item, container, false);
        }

        ((TextView) convertView.findViewById(R.id.games_list_item_nemesis_text))
                .setText(getItem(position).getNemesisName());
        ((TextView) convertView.findViewById(R.id.games_list_item_won_text))
                .setText(getItem(position).getWon()?"win":"loss");
        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ShowSingleGameActivity.class);
            Gson gson = new Gson();
            String jsonstring = gson.toJson(gamesList.get(position));
            intent.putExtra("game", jsonstring);
            context.startActivity(intent);
        });
        return convertView;
    }

}
