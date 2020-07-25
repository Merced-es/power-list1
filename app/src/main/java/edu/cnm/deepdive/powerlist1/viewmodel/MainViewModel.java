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
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;
import edu.cnm.deepdive.powerlist1.model.pojo.GoalWithList;
import edu.cnm.deepdive.powerlist1.service.GoalRepository;
import edu.cnm.deepdive.powerlist1.service.PowerListRepository;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final GoalRepository goalRepository;
  private final PowerListRepository powerListRepository;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;
  private final MutableLiveData<Goal> goal;
  private final MutableLiveData<PowerList> powerList;

  public MainViewModel(@NonNull Application application) {
    super(application);
    goalRepository = new GoalRepository(application);
    powerListRepository = new PowerListRepository(application);
    goal = new MutableLiveData<>();
    powerList = new MutableLiveData<>();
    throwable = new MutableLiveData<Throwable>();
    pending = new CompositeDisposable();
  }

  public MutableLiveData<Goal> getGoal() {
    return goal;
  }

  public MutableLiveData<PowerList> getPowerList() {
    return powerList;
  }

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

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }

}