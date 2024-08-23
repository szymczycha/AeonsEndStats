package Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Game;

@Dao
public interface GamesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addGame(Game game);

    @Update
    public void updateGame(Game game);

    @Delete
    public void deleteGame(Game game);

    @Query("select * from games")
    public List<Game> getAll();

    @Query("select * from games where id ==:gameId")
    public Game getGame(int gameId);
}
