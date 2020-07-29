package edu.cnm.deepdive.powerlist1.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.powerlist1.model.pojo.ListType;

@Entity(
    indices = @Index(value = "list_title", unique = true),
    foreignKeys = @ForeignKey(
        entity = edu.cnm.deepdive.powerlist1.model.entity.Goal.class,
        parentColumns = "goal_id",
        childColumns = "goal_id",
        onDelete = ForeignKey.SET_NULL
    )
)
public class PowerList {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "list_id")
    private long listId;

    @ColumnInfo(name = "list_title", collate = ColumnInfo.NOCASE)
    private String listTitle;

    @ColumnInfo(name = "goal_id", index = true)
    private Long goalId;

    @ColumnInfo(index = true)
    private ListType type;

    @NonNull
    @ColumnInfo(collate = ColumnInfo.NOCASE)
    private String description = "";

    public Long getListId() { return listId; }

    public void setListId(long listId) {
        this.listId = listId;
    }

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public ListType getType() {
        return type;
    }

    public void setType(ListType type) {
        this.type = type;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return listTitle;
    }
}
