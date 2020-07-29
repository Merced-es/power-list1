package edu.cnm.deepdive.powerlist1.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.entity.Item;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;
import edu.cnm.deepdive.powerlist1.model.pojo.GoalWithList;
import edu.cnm.deepdive.powerlist1.model.pojo.PowerListWithItems;
import edu.cnm.deepdive.powerlist1.service.GoalRepository;
import edu.cnm.deepdive.powerlist1.service.ItemRepository;
import edu.cnm.deepdive.powerlist1.service.PowerListRepository;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final GoalRepository goalRepository;
  private final PowerListRepository powerListRepository;
  private final ItemRepository itemRepository;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;
  private final MutableLiveData<List<Goal>> goals;
  private final MutableLiveData<List<PowerList>> powerLists;
  private final MutableLiveData<Goal> goal;
  private final MutableLiveData<PowerList> powerList;


  public MainViewModel(@NonNull Application application) {
    super(application);
    goalRepository = new GoalRepository(application);
    powerListRepository = new PowerListRepository(application);
    itemRepository = new ItemRepository(application);
    goal = new MutableLiveData<>();
    goals = new MutableLiveData<>();
    powerList = new MutableLiveData<>();
    powerLists = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();

  }

  public LiveData<List<PowerListWithItems>> getPowerLists() {
    return powerListRepository.getAll();
  }

  public LiveData<PowerList> getPowerList() { return powerList; }

  public LiveData<List<Goal>> getGoals() { return goalRepository.getAll(); }

  public LiveData<Goal> getGoal() { return goal; }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void setGoalId(long id) {
    throwable.setValue(null);
    pending.add(
        goalRepository.get(id)
            .subscribe(
                (goal) -> this.goal.postValue(goal),
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  public void saveGoal(Goal goal) {
    throwable.setValue(null);
    pending.add(
        goalRepository.save(goal)
            .subscribe(
                () -> {
                },
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  public void deleteGoal(Goal goal) {
    throwable.setValue(null);
    pending.add(
        goalRepository.delete(goal)
            .subscribe(
                () -> {
                },
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  public void setListId(long id) {
    throwable.setValue(null);
    pending.add(
        powerListRepository.get(id)
            .subscribe(
                (powerList) -> this.powerList.postValue(powerList),
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  public void savePowerList(PowerList powerList) {
    throwable.setValue(null);
    pending.add(
        powerListRepository.save(powerList)
            .subscribe(
                () -> {
                },
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  public void deletePowerList(PowerList powerList) {
    throwable.setValue(null);
    pending.add(
        powerListRepository.delete(powerList)
            .subscribe(
                () -> {
                },
                (throwable) -> this.throwable.postValue(throwable)
            )
    );
  }

  public void saveItem(Item item) {
    throwable.setValue(null);
    pending.add(
        itemRepository.save(item)
            .subscribe(
                () -> {
                },
                (throwable) -> this.throwable.postValue(throwable)

            )
    );
  }
  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }

}