package com.jinosoft.section02.javaconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.jinosoft.section02.javaconfig.Template.getSqlSession;

/**
 * 메뉴 관리 비즈니스 로직을 처리하는 서비스 클래스입니다.
 * <p>
 * Controller로부터 요청을 받아 DAO(Mapper)를 통해 데이터베이스 작업을 수행하고,
 * 그 결과를 바탕으로 트랜잭션(Commit, Rollback)을 관리합니다.
 * </p>
 */
public class MenuService {

    /**
     * 모든 메뉴 목록을 조회하는 비즈니스 로직을 수행합니다.
     * <p>
     * SqlSession.getMapper()를 통해 MenuMapper 인터페이스의 구현체를 받아옵니다.
     * </p>
     * 
     * @return 조회된 메뉴 목록 (List&lt;MenuDTO&gt;)
     */
    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        sqlSession.close();

        return menuList;
    }

    /**
     * 메뉴 코드로 특정 메뉴를 상세 조회하는 비즈니스 로직을 수행합니다.
     *
     * @param menuCode 조회할 메뉴의 코드
     * @return 조회된 메뉴 정보 (MenuDTO)
     */
    public MenuDTO selectMenuByMenuCode(int menuCode) {

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO menu = menuMapper.selectMenuByMenuCode(menuCode);

        sqlSession.close();

        return menu;
    }

    /**
     * 새로운 메뉴를 등록하는 비즈니스 로직을 수행합니다.
     * <p>
     * 등록 성공 시 트랜잭션을 커밋하고, 실패 시 롤백합니다.
     * </p>
     *
     * @param menu 등록할 메뉴의 정보가 담긴 DTO
     * @return 등록 성공 여부 (true/false)
     */
    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.insertMenu(menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    /**
     * 기존 메뉴 정보를 수정하는 비즈니스 로직을 수행합니다.
     * <p>
     * 수정 성공 시 트랜잭션을 커밋하고, 실패 시 롤백합니다.
     * </p>
     *
     * @param menu 수정할 내용이 담긴 메뉴 DTO (메뉴 코드로 식별)
     * @return 수정 성공 여부 (true/false)
     */
    public boolean modifyMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.updateMenu(menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    /**
     * 메뉴 코드를 이용하여 메뉴를 삭제하는 비즈니스 로직을 수행합니다.
     * <p>
     * 삭제 성공 시 트랜잭션을 커밋하고, 실패 시 롤백합니다.
     * </p>
     *
     * @param menuCode 삭제할 메뉴의 코드
     * @return 삭제 성공 여부 (true/false)
     */
    public boolean deleteMenu(int menuCode) {

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.deleteMenu(menuCode);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

}