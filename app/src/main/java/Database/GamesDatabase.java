package Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import Converters.Converters;
import Dao.GamesDao;
import Dao.PlayersDao;
import Model.Game;
import Model.Player;

@Database(entities = {Game.class, Player.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class GamesDatabase extends RoomDatabase {
    public abstract GamesDao getGamesDao();
    public abstract PlayersDao getPlayersDao();
}
