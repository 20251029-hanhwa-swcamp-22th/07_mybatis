package com.beyond.mapper;

import com.beyond.dto.CategoryAndMenuDTO;
import com.beyond.dto.MenuAndCategoryDTO;
import com.beyond.dto.MenuDTO;

import java.util.List;

public interface ElementTestMapper {
  List<MenuDTO> selectResultMapTest();

  List<MenuAndCategoryDTO> selectResultMapAssociationTest();

  List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}