package edu.cnm.deepdive.powerlist1.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.powerlist1.model.dao.GoalDao;
import edu.cnm.deepdive.powerlist1.model.dao.ItemDao;
import edu.cnm.deepdive.powerlist1.model.dao.PowerListDao;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.pojo.GoalWithList;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class GoalRepository {

  private final edu.cnm.deepdive.powerlist1.service.ListDatabase database;
  private final GoalDao goalDao;
  private final PowerListDao powerListDao;
  private final ItemDao itemDao;
  private final Context context;

  public GoalRepository(Context context) {
    this.context = context;
    database = edu.cnm.deepdive.powerlist1.service.ListDatabase.getInstance();
    goalDao = database.getGoalDao();
    powerListDao = database.getListDao();
    itemDao = database.getItemDao();
  }

  public LiveData<List<GoalWithList>> getAll() {
    return goalDao.selectAll();
  }

  public Single<Goal> get(long id) {
    return goalDao.selectById(id)
        .subscribeOn(Schedulers.io());
  }

  public Completable save(Goal goal) {
    if (goal.getGoalId() == 0) {
      return Completable.fromSingle(goalDao.insert(goal))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(goalDao.update(goal))
          .subscribeOn(Schedulers.io());

    }
  }

  public Completable delete(Goal goal) {
    if (goal.getGoalId() == 0) {
      return Completable.fromAction(() -> {})
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(goalDao.delete(goal))
          .subscribeOn(Schedulers.io());
    }
  }

}

