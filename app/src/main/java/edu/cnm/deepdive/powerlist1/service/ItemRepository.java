package edu.cnm.deepdive.powerlist1.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.powerlist1.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist1.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist1.model.dao.PowerListDao;
import edu.cnm.deepdive.powerlist1.model.entity.Item;
import edu.cnm.deepdive.powerlist1.model.pojo.ItemWithList;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class ItemRepository {

  private final edu.cnm.deepdive.powerlist1.service.ListDatabase database;
  private final GoalDao goalDao;
  private final PowerListDao powerListDao;
  private final ItemDao itemDao;
  private final Context context;

  public ItemRepository(Context context) {
    this.context = context;
    database = ListDatabase.getInstance();
    goalDao = database.getGoalDao();
    powerListDao = database.getListDao();
    itemDao = database.getItemDao();
  }

  public LiveData<List<ItemWithList>> getAll() {
    return itemDao.selectAll();
  }

  public Single<Item> get(long id) {
    return itemDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(edu.cnm.deepdive.powerlist1.model.entity.Item item) {
    if (item.getItemId() == 0) {
      return Completable.fromSingle(itemDao.insert(item))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(itemDao.update((List) item))
          .subscribeOn(Schedulers.io());

    }
  }

  public Completable delete(Item item) {
    if (item.getItemId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(itemDao.delete(item))
          .subscribeOn(Schedulers.io());
    }
  }

}
