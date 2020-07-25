package edu.cnm.deepdive.powerlist1.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.pojo.GoalWithList;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface GoalDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(Goal goal);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Goal... goals);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Goal> goals);

  @Update
  Single<Integer> update(Goal... goals);

  @Delete
  Single<Integer> delete(Goal... goals);

  @Transaction
  @Query("SELECT * FROM Goal ORDER BY title")
  LiveData<List<Goal>> selectAll();

  @Query("SELECT * FROM Goal WHERE goal_id = :goalId")
  Single<Goal> selectById(long goalId);

}
