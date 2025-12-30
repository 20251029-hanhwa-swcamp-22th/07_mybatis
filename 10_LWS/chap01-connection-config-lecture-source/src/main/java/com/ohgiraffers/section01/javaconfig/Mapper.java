package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

public interface Mapper { // Mapper 을 통해 Select DATA 시행

    @Select("SELECT NOW()")
    java.util.Date selectDate();
}
