package com.my.section01;

import org.apache.ibatis.annotations.Select;

public interface Mapper {

  @Select("SELECT NOW()")
  public java.util.Date selectDate();
}
