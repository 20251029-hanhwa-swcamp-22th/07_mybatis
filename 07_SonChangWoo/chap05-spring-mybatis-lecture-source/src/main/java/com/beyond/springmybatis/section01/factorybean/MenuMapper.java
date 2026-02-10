package com.beyond.springmybatis.section01.factorybean;

import java.awt.*;
import java.util.List;

public interface MenuMapper {

  List<MenuDTO> findAllMenuByOrderableStatus(String orderableStatus);
}