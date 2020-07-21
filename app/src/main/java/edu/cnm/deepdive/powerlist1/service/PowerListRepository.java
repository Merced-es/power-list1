package edu.cnm.deepdive.powerlist1.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.powerlist1.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist1.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist1.model.dao.PowerListDao;
import edu.cnm.deepdive.powerlist1.model.entity.Item;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;
import edu.cnm.deepdive.powerlist1.model.pojo.PowerListWithItem;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.List;

public class PowerListRepository {

  private final ListDatabase database;
  private final GoalDao goalDao;
  private final PowerListDao powerListDao;
  private final ItemDao itemDao;
  private final Context context;

  public PowerListRepository(Context context) {
    this.context = context;
    database = ListDatabase.getInstance();
    goalDao = database.getGoalDao();
    powerListDao = database.getListDao();
    itemDao = database.getItemDao();
  }

  public Single<PowerList> get(long id) {
    return powerListDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public LiveData<java.util.List<PowerListWithItem>> getAll() {
    return powerListDao.selectAll();
  }

  public Completable save(PowerList powerList) {
    if (powerList.getListId() == 0) {
      return Completable.fromSingle(itemDao.insert((Collection<Item>) powerList))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(itemDao.update((List) powerList))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(PowerList powerList) {
    if (powerList.getListId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(powerListDao.delete(powerList))
          .subscribeOn(Schedulers.io());
    }
  }
}
