package edu.cnm.deepdive.powerlist1.service;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.powerlist1.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist1.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist1.model.dao.PowerListDao;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.entity.Item;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;
import edu.cnm.deepdive.powerlist1.model.pojo.ListType;
import edu.cnm.deepdive.powerlist1.service.ListDatabase.Converters;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;

@Database(
    entities = {Goal.class, PowerList.class, Item.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class, ListType.class})
public abstract class ListDatabase extends RoomDatabase {

  private static final String DB_NAME = "goal_db";

  private static Application context;

  public static void setContext(Application context) {
   ListDatabase.context = context;
  }

  public abstract GoalDao getGoalDao();

  public abstract PowerListDao getPowerListDao();

  public abstract ItemDao getItemDao();

  public static ListDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final ListDatabase INSTANCE =
        Room.databaseBuilder(context, ListDatabase.class, DB_NAME)
            .addCallback(new Callback(context))
            .build();

  }


  private static class Callback extends RoomDatabase.Callback {

    private final Context context;

    private Callback(Context context) {
      this.context = context;
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      ListDatabase database = ListDatabase.getInstance();
      GoalDao goalDao = database.getGoalDao();
      Goal goal1 = new Goal();
      goal1.setTitle("Buy House");
      goal1.setText("save down payment");
      Goal goal2 = new Goal();
      goal2.setTitle("Lose 6 lbs");
      goal2.setText("track macros");

      goalDao.insert(goal1, goal2)
          .subscribeOn(Schedulers.io())
          .subscribe();

    }
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
