package edu.cnm.deepdive.powerlist1.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;

public class PowerListWithGoal extends PowerList {

  @Relation(entity = Goal.class, entityColumn = "goal_id", parentColumn = "goal_id")
  private Goal goal;

  public Goal getGoal() {
    return goal;
  }

  public void setGoal(Goal goal) {
    this.goal = goal;
  }


}
