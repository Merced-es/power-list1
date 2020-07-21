package edu.cnm.deepdive.powerlist1.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;

public class GoalWithList extends Goal {

  @Relation(entity = PowerList.class, entityColumn = "list_id", parentColumn = "list_id")
  private PowerList powerListId;

  public PowerList getPowerList() {
    return powerListId;
  }

  public void setPowerList(PowerList powerList) {
    this.powerListId = powerListId;
  }
}
