package com.kth.section01.xml;

import com.kth.common.MenuDTO;
import com.kth.common.SearchCriteria;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DynamicSqlMapper {

    List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByRandomMenuCode(Map<String, Set<Integer>> criteria);

    List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> criteria);

    int updateMenu(Map<String, Object> criteria);
}