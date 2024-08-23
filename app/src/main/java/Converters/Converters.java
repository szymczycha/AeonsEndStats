package Converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import Model.Player;

public class Converters {
    @TypeConverter
    public static List<Player> fromString(String value){
        Type listType = new TypeToken<List<Player>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromPlayerList(List<Player> list){
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static Date fromTimestamp(String value){
        return Date.from(Instant.parse(value));
    }

    @TypeConverter
    public static String fromDate(Date date){
        return date.toInstant().toString();
    }
}
