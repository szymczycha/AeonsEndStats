package Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Game;
import Model.Player;

@Dao
public interface PlayersDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addPlayer(Player player);

    @Update
    public void updatePlayer(Player player);

    @Delete
    public void deletePlayer(Player player);

    @Query("select * from games")
    public List<Player> getAll();

    @Query("select * from games where id ==:gameId")
    public Player getPlayer(int gameId);
}
