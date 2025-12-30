package com.kth.mapper;

import com.kth.dto.CategoryAndMenuDTO;
import com.kth.dto.MenuAndCategoryDTO;
import com.kth.dto.MenuDTO;

import java.util.List;

public interface ElementTestMapper {
  List<MenuDTO> selectResultMapTest();

  List<MenuAndCategoryDTO> selectResultMapAssociationTest();

  List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}
