package edu.cnm.deepdive.powerlist1.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.powerlist1.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist1.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.pojo.GoalWithList;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class GoalRepository {

  private final ListDatabase database;
  private final GoalDao goalDao;
  private final ItemDao itemDao;
  private final Context context;

  public GoalRepository(Context context) {
    this.context = context;
    database = ListDatabase.getInstance();
    goalDao = database.getGoalDao();
    itemDao = database.getItemDao();
  }

  public LiveData<List<Goal>> getAll() {
    return goalDao.selectAll();
  }

  public Single<Goal> get(long id) {
    return goalDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(Goal goal) {
    if (goal.getId() == 0) {
      return Completable.fromSingle(goalDao.insert(goal))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(goalDao.update(goal))
          .subscribeOn(Schedulers.io());

    }
  }

  public Completable delete(Goal goal) {
    if (goal.getId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(goalDao.delete(goal))
          .subscribeOn(Schedulers.io());
    }
  }

}

