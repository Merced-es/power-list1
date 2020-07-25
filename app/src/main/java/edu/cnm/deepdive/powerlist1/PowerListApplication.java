package edu.cnm.deepdive.powerlist1;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.powerlist1.service.ListDatabase;
import io.reactivex.schedulers.Schedulers;

public class PowerListApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    ListDatabase.setContext(this);
    ListDatabase database = ListDatabase.getInstance();
    database.getGoalDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
    Stetho.initializeWithDefaults(this);
  }
}
