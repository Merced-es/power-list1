package edu.cnm.deepdive.powerlist1.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.powerlist1.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist1.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist1.model.dao.ListDao;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.entity.Item;
import edu.cnm.deepdive.powerlist1.model.pojo.ListType;
import edu.cnm.deepdive.powerlist1.service.ListDatabase.Converters;
import java.util.Date;
import java.util.List;

@Database(
    entities = {Goal.class, List.class, Item.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class, ListType.class})
public abstract class ListDatabase extends RoomDatabase {

  private static final String DB_NAME = "goal_db";

  private static Application context;

  public static void setContext(Application context) {
    edu.cnm.deepdive.powerlist1.service.ListDatabase.context = context;
  }

  public abstract GoalDao getGoalDao();

  public abstract ListDao getListDao();

  public abstract ItemDao getItemDao();

  public static edu.cnm.deepdive.powerlist1.service.ListDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final edu.cnm.deepdive.powerlist1.service.ListDatabase INSTANCE =
        Room.databaseBuilder(context, edu.cnm.deepdive.powerlist1.service.ListDatabase.class, DB_NAME)
            .build();

  }


  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }

  }

}
