package com.google.mapper;

import com.google.dto.CategoryAndMenuDTO;
import com.google.dto.MenuAndCategoryDTO;
import com.google.dto.MenuDTO;

import java.util.List;

public interface ElementTestMapper {
  List<MenuDTO> selectResultMapTest();

  List<MenuAndCategoryDTO> selectResultMapAssociationTest();

  List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}
