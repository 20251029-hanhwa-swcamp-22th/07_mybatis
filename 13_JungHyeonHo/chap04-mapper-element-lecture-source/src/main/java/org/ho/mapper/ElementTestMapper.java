package org.ho.mapper;

import org.ho.dto.CategoryAndMenuDTO;
import org.ho.dto.MenuAndCategoryDTO;
import org.ho.dto.MenuDTO;

import java.util.List;

public interface ElementTestMapper {
  List<MenuDTO> selectResultMapTest();

  List<MenuAndCategoryDTO> selectResultMapAssociationTest();

  List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}
