package edu.cnm.deepdive.powerlist1.model.pojo;

import androidx.room.Ignore;
import androidx.room.Relation;
import edu.cnm.deepdive.powerlist1.model.entity.Item;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;
import java.util.List;

public class PowerListWithItems extends PowerList {

  @Relation(entity = Item.class, entityColumn = "list_id", parentColumn = "list_id")
  private List<Item> items;

  @Ignore
  private boolean expanded;

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public boolean isExpanded() {
    return expanded;
  }

  public void setExpanded(boolean expanded) {
    this.expanded = expanded;
  }
}
