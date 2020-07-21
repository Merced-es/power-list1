package edu.cnm.deepdive.powerlist1.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.powerlist1.model.entity.Item;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;

public class ItemWithList extends Item {

  @Relation(entity = PowerList.class, entityColumn = "list_id", parentColumn = "list_id")
  private PowerList powerList;

  public PowerList getPowerList() {
    return powerList;
  }

  public void setPowerList(PowerList powerList) {
    this.powerList = powerList;
  }

}
