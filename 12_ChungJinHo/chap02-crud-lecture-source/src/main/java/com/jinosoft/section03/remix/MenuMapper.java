package com.jinosoft.section03.remix;

import java.util.List;

/**
 * MyBatis의 Mapper 인터페이스입니다.
 * <p>
 * XML Mapper 파일과 연결되어 SQL을 실행합니다.
 * 이 인터페이스의 풀 패키지명(com.jinosoft.section03.remix.MenuMapper)은
 * XML Mapper의 namespace 속성과 정확히 일치해야 합니다.
 * </p>
 */
public interface MenuMapper {

    /**
     * 모든 메뉴를 조회합니다.
     *
     * @return 조회된 전체 메뉴 목록
     */
    List<MenuDTO> selectAllMenu();

    /**
     * 특정 메뉴 코드를 가진 메뉴를 조회합니다.
     *
     * @param menuCode 조회할 메뉴의 코드
     * @return 조회된 메뉴 정보
     */
    MenuDTO selectMenuByMenuCode(int menuCode);

    /**
     * 새로운 메뉴를 등록합니다.
     *
     * @param menu 등록할 메뉴 객체
     * @return 등록 성공 시 1, 실패 시 0
     */
    int insertMenu(MenuDTO menu);

    /**
     * 기존 메뉴 정보를 수정합니다.
     *
     * @param menu 수정할 메뉴 객체
     * @return 수정 성공 시 1, 실패 시 0
     */
    int updateMenu(MenuDTO menu);

    /**
     * 특정 메뉴를 삭제합니다.
     *
     * @param menuCode 삭제할 메뉴의 코드
     * @return 삭제 성공 시 1, 실패 시 0
     */
    int deleteMenu(int menuCode);

}
