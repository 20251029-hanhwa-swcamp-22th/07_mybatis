package org.ho.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import static org.ho.section01.xmlconfig.Template.getSqlSession;

import java.util.List;

/* Service 계층
 * - 비즈니스 로직 처리 계층
 * - 요청에 대한 응답 데이터를 만든다
 * - 데이터 가공 또는 DAO(DB CRUD), 트랜잭션 관리
 * */
public class MenuService {

  private final MenuDAO menuDAO;

  public MenuService() {
    this.menuDAO = new MenuDAO();
  }

  /**
   * 전체 메뉴 조회
   *
   * @return menuList
   */
  public List<MenuDTO> selectAllMenu() {

    // 1. SqlSession 얻어오기
    SqlSession sqlSession = getSqlSession();

    // 2. SQL 수행 후 결과 반환 받기
    List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

    // 3. SqlSession 메모리 반환
    sqlSession.close();

    // 4. 결과 반환
    return menuList;
  }

  /**
   * 메뉴 코드가 일치하는 메뉴 조회
   *
   * @param menuCode
   * @return menu
   */
  public MenuDTO selectMenuByMenuCode(int menuCode) {

    SqlSession sqlSession = getSqlSession();

    MenuDTO menu = menuDAO.selectManyByMenuCode(sqlSession, menuCode);

    sqlSession.close();
    return menu;
  }

  public boolean registMenu(MenuDTO menu) {

    SqlSession sqlSession = getSqlSession();

    // insert된 결과 행의 개수를 반환 받아 저장
    int result = menuDAO.insertMenu(sqlSession, menu);

    if (result > 0) sqlSession.commit();
    else sqlSession.rollback();

    sqlSession.close();

    return result > 0;
  }

  /* 메소드명, id 등 : updateMenu */
  public boolean modifyMenu(MenuDTO menu) {
    SqlSession sqlSession = getSqlSession();

    int result = menuDAO.updateMenu(sqlSession, menu);

    if (result > 0) sqlSession.commit();
    else sqlSession.rollback();

    sqlSession.close();

    return result > 0;

  }

  /* 메소드명, id 등 : deleteMenu */
  public boolean deleteMenu(int menuCode) {
    SqlSession sqlSession = getSqlSession();

    int result = menuDAO.deleteMenu(sqlSession, menuCode);

    if (result > 0) sqlSession.commit();
    else sqlSession.rollback();

    sqlSession.close();

    return result > 0;

  }

}