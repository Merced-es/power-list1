package edu.cnm.deepdive.powerlist1.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = @Index(value = "name", unique = true),
    foreignKeys = @ForeignKey(
        entity = PowerList.class,
        parentColumns = "list_id",
        childColumns = "list_id",
        onDelete = ForeignKey.SET_NULL
    )
)

public class Item {

  @PrimaryKey
  @ColumnInfo(name = "item_id")
  private long itemId;

  @ColumnInfo(name = "list_id", index = true)
  private long listId;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String name;

  @ColumnInfo(index = true, collate = ColumnInfo.NOCASE)
  private String description;

  @ColumnInfo(name = "media_uri")
  private String mediaUri;

  public Item() {
  }

  public long getItemId() {
    return itemId;
  }

  public void setItemId(long itemId) {
    this.itemId = itemId;
  }

  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getMediaUri() {
    return mediaUri;
  }

  public void setMediaUri(String mediaUri) {
    this.mediaUri = mediaUri;
  }

  public Long getListId() {
    return listId;
  }

  public void setListId(long listId) {
    this.listId = listId;
  }
}
