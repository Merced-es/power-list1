package edu.cnm.deepdive.powerlist1.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.powerlist1.model.entity.Item;
import edu.cnm.deepdive.powerlist1.model.entity.List;

public class ListWithItem extends List {

  @Relation(entity = Item.class, entityColumn = "item_id", parentColumn = "item_id")
  private Item item;

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
}
