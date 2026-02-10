package com.google.springmybatis.section01.factorybean;

import lombok.AllArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor // 필드 전체 초기화용 생성자 추가
public class MenuService {
  // open 과 close가 자동으로 되는 템플릿
  private final SqlSessionTemplate sqlSession;

  /*public MenuService (SqlSessionTemplate sqlSession) {
    this.sqlSession = sqlSession;
  }*/

  public List<MenuDTO> findAllMenuByOrderableStatus(String orderableStatus) {

    List<MenuDTO> menus
        = sqlSession
        .getMapper(MenuMapper.class)
        .findAllMenuByOrderableStatus(orderableStatus);

    if (menus != null) { // select 성공 시
      menus.forEach(menu -> { // 모든 메뉴 요소에 하나씩 접근
        if ("Y".equals(menu.getOrderableStatus())) {
          menu.setMenuName(menu.getMenuName() + "(주문 가능)");
        } else {
          menu.setMenuName(menu.getMenuName() + "(주문 불가능)");
        }
      });

    }
    return menus;

  }
}
