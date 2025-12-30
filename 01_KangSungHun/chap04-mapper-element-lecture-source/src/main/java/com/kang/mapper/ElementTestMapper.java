package com.kang.mapper;

import com.kang.dto.CategoryAndMenuDTO;
import com.kang.dto.MenuAndCategoryDTO;
import com.kang.dto.MenuDTO;

import java.util.List;

public interface ElementTestMapper {
    List<MenuDTO> selectResultMapTest();

    List<MenuAndCategoryDTO> selectResultMapAssociationTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}