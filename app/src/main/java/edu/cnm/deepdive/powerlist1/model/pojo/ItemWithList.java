package edu.cnm.deepdive.powerlist1.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.powerlist1.model.entity.Item;
import edu.cnm.deepdive.powerlist1.model.entity.List;

public class ItemWithList extends Item {

  @Relation(entity = List.class, entityColumn = "list_id", parentColumn = "list_id")
  private List list;

  public List getList() {
    return list;
  }

  public void setList(List list) {
    this.list = list;
  }

}