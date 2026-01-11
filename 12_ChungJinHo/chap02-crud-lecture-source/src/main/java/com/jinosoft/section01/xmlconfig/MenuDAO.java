package com.jinosoft.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 데이터베이스의 Menu 테이블에 접근하여 CRUD 작업을 수행하는 Data Access Object (DAO) 클래스입니다.
 * <p>
 * MyBatis의 SqlSession을 통해 Mapper에 정의된 SQL을 실행합니다.
 * </p>
 */
public class MenuDAO {

    /**
     * 모든 메뉴 목록을 조회합니다.
     *
     * @param sqlSession MyBatis SqlSession 객체
     * @return 조회된 메뉴 목록 (List&lt;MenuDTO&gt;)
     */
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    /**
     * 메뉴 코드로 특정 메뉴를 상세 조회합니다.
     *
     * @param sqlSession MyBatis SqlSession 객체
     * @param menuCode   조회할 메뉴의 코드
     * @return 조회된 메뉴 정보 (MenuDTO), 존재하지 않으면 null
     */
    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        return sqlSession.selectOne("MenuMapper.selectMenuByMenuCode", menuCode);
    }

    /**
     * 새로운 메뉴를 등록합니다.
     *
     * @param sqlSession MyBatis SqlSession 객체
     * @param menu       등록할 메뉴 정보가 담긴 DTO
     * @return 등록 성공 시 1, 실패 시 0
     */
    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    /**
     * 기존 메뉴의 정보를 수정합니다.
     *
     * @param sqlSession MyBatis SqlSession 객체
     * @param menu       수정할 내용이 담긴 메뉴 DTO (메뉴 코드로 식별)
     * @return 수정 성공 시 1, 실패 시 0
     */
    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    /**
     * 메뉴 코드를 이용하여 메뉴를 삭제합니다.
     *
     * @param sqlSession MyBatis SqlSession 객체
     * @param menuCode   삭제할 메뉴의 코드
     * @return 삭제 성공 시 1, 실패 시 0
     */
    public int deleteMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("MenuMapper.deleteMenu", menuCode);
    }

}
