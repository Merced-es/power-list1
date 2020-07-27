package edu.cnm.deepdive.powerlist1.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;

public class GoalWithList extends Goal {

  @Relation(entity = PowerList.class, entityColumn = "goal_id", parentColumn = "goal_id")
  private PowerList powerList;

  public PowerList getPowerList() {
    return powerList;
  }

  public void setPowerList(PowerList powerList) {
    this.powerList = powerList;
  }
}
