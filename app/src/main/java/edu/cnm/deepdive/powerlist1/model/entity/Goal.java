package edu.cnm.deepdive.powerlist1.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;


@Entity(
    indices = @Index(value = "title", unique = true)
)
public class Goal {


  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "goal_id")
  private long goalId;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String title;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String text = "";


  public long getGoalId() {
    return goalId;
  }

  public void setGoalId(long goalId) {
    this.goalId = goalId;
  }

  @NonNull
  public String getTitle() {
    return title;
  }

  public void setTitle(@NonNull String title) {
    this.title = title;
  }

  @NonNull
  public String getText() {
    return text;
  }

  public void setText(@NonNull String text) {
    this.text = text;
  }

  @NonNull
  @Override
  public String toString() {
    return text;
  }
}


