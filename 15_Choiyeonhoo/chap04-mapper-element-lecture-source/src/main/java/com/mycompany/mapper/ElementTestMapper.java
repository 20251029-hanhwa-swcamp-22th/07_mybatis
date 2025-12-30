package com.mycompany.mapper;

import com.mycompany.dto.CategoryAndMenuDTO;
import com.mycompany.dto.MenuAndCategoryDTO;
import com.mycompany.dto.MenuDTO;

import java.util.List;

public interface ElementTestMapper {
  List<MenuDTO> selectResultMapTest();

  List<MenuAndCategoryDTO> selectResultMapAssociationTest();

  List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}
