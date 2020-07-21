package edu.cnm.deepdive.powerlist1.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;
import edu.cnm.deepdive.powerlist1.model.pojo.PowerListWithItem;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface PowerListDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(List list);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(List... lists);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<List> lists);

  @Update
  Single<Integer> update(List... lists);

  @Delete
  Single<Integer> delete(PowerList lists);

  @Query("SELECT * FROM PowerList WHERE list_id = :listId")
  Single<PowerList> selectById(long listId);

  @Transaction
  @Query("SELECT * FROM PowerList ORDER BY listName")
  LiveData<List<PowerListWithItem>> selectAll();

}
