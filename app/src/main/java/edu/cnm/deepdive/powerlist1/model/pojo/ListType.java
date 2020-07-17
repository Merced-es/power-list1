package edu.cnm.deepdive.powerlist1.model.pojo;

import androidx.room.TypeConverter;

public enum ListType {
  POWER_LIST, VISION_BOARD;

  @TypeConverter
  public static edu.cnm.deepdive.powerlist1.model.pojo.ListType integerToListType(Integer value) {
    return (value == null) ? null : edu.cnm.deepdive.powerlist1.model.pojo.ListType.values()[value];
  }

  @TypeConverter
  public static Integer listTypeToInteger(edu.cnm.deepdive.powerlist1.model.pojo.ListType value) {
    return (value == null) ? null : value.ordinal();
  }

}
