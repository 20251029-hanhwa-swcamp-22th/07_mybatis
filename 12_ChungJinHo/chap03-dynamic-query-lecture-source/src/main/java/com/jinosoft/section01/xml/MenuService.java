package com.jinosoft.section01.xml;

import com.jinosoft.common.MenuDTO;
import com.jinosoft.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.jinosoft.common.Template.getSqlSession;

public class MenuService {

  public void selectMenuByPrice(int price) {
    SqlSession sqlSession = getSqlSession();
    DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    Map<String, Integer> priceMap = new HashMap<>();
    priceMap.put("price", price);

    List<MenuDTO> menuList = mapper.selectMenuByPrice(priceMap);

    if (menuList != null && !menuList.isEmpty()) {
      menuList.forEach(System.out::println);
    } else {
      System.out.println("검색 결과가 없습니다.");
    }

    sqlSession.close();
  }

  public void searchMenu(SearchCriteria searchCriteria) {
    SqlSession sqlSession = getSqlSession();
    DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

    if (menuList != null && !menuList.isEmpty()) {
      menuList.forEach(System.out::println);
    } else {
      System.out.println("검색 결과가 없습니다.");
    }

    sqlSession.close();
  }

  public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
    SqlSession sqlSession = getSqlSession();
    DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);

    if (menuList != null && !menuList.isEmpty()) {
      menuList.forEach(System.out::println);
    } else {
      System.out.println("검색 결과가 없습니다.");
    }

    sqlSession.close();
  }

  public void searchMenuByRandomMenuCode(Set<Integer> randomMenuCodeList) {
    SqlSession sqlSession = getSqlSession();
    DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    Map<String, Set<Integer>> criteria = new HashMap<>();
    criteria.put("randomMenuCodeList", randomMenuCodeList);

    List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(criteria);

    if (menuList != null && !menuList.isEmpty()) {
      menuList.forEach(System.out::println);
    } else {
      System.out.println("검색 결과가 없습니다.");
    }

    sqlSession.close();
  }

  public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
    SqlSession sqlSession = getSqlSession();
    DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(criteria);

    if (menuList != null && !menuList.isEmpty()) {
      menuList.forEach(System.out::println);
    } else {
      System.out.println("검색 결과가 없습니다.");
    }

    sqlSession.close();
  }

  public void modifyMenu(Map<String, Object> criteria) {
    SqlSession sqlSession = getSqlSession();
    DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    int result = mapper.updateMenu(criteria);

    if (result > 0) {
      System.out.println("메뉴 수정 성공!");
      sqlSession.commit();
    } else {
      System.out.println("메뉴 수정 실패...");
      sqlSession.rollback();
    }

    sqlSession.close();
  }
}
