package com.jinosoft.section02.javaconfig;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * MyBatis의 Mapper 인터페이스입니다.
 * <p>
 * XML 파일 대신 자바 어노테이션(@Select, @Insert, @Update, @Delete)을 사용하여 SQL을 정의합니다.
 * </p>
 */
public interface MenuMapper {

    /**
     * 모든 메뉴를 조회합니다.
     * <p>
     * 
     * @Results 어노테이션을 사용하여 DB 컬럼명(snake_case)과 DTO 필드명(camelCase)을 매핑합니다.
     *          </p>
     * @return 조회된 전체 메뉴 목록
     */
    @Results(id = "menuResultMap", value = {
            @Result(id = true, property = "menuCode", column = "menu_code"),
            @Result(property = "menuName", column = "menu_name"),
            @Result(property = "menuPrice", column = "menu_price"),
            @Result(property = "categoryCode", column = "category_code"),
            @Result(property = "orderableStatus", column = "orderable_status")
    })
    @Select("SELECT menu_code, menu_name, menu_price, category_code, orderable_status FROM tbl_menu WHERE orderable_status = 'Y' ORDER BY menu_code")
    List<MenuDTO> selectAllMenu();

    /**
     * 특정 메뉴 코드를 가진 메뉴를 조회합니다.
     * <p>
     * 
     * @ResultMap 어노테이션을 사용하여 위에서 정의한 "menuResultMap" 매핑 규칙을 재사용합니다.
     *            </p>
     * @param menuCode 조회할 메뉴의 코드
     * @return 조회된 메뉴 정보
     */
    @ResultMap("menuResultMap")
    @Select("SELECT menu_code, menu_name, menu_price, category_code, orderable_status FROM tbl_menu WHERE menu_code = #{ menuCode }")
    MenuDTO selectMenuByMenuCode(int menuCode);

    /**
     * 새로운 메뉴를 등록합니다.
     *
     * @param menu 등록할 메뉴 객체
     * @return 등록 성공 시 1, 실패 시 0
     */
    @Insert("INSERT INTO tbl_menu (menu_name, menu_price, category_code, orderable_status) VALUES (#{ menuName }, #{ menuPrice }, #{ categoryCode }, 'Y')")
    int insertMenu(MenuDTO menu);

    /**
     * 기존 메뉴 정보를 수정합니다.
     *
     * @param menu 수정할 메뉴 객체
     * @return 수정 성공 시 1, 실패 시 0
     */
    @Update("UPDATE tbl_menu SET menu_name = #{ menuName }, menu_price = #{ menuPrice }, category_code = #{ categoryCode } WHERE menu_code = #{ menuCode }")
    int updateMenu(MenuDTO menu);

    /**
     * 특정 메뉴를 삭제합니다.
     *
     * @param menuCode 삭제할 메뉴의 코드
     * @return 삭제 성공 시 1, 실패 시 0
     */
    @Delete("DELETE FROM tbl_menu WHERE menu_code = #{ menuCode }")
    int deleteMenu(int menuCode);

}
