package com.jinosoft.section01.xmlconfig;

import lombok.*;

/**
 * 메뉴 정보를 담기 위한 Data Transfer Object (DTO) 클래스입니다.
 * <p>
 * tbl_menu 테이블의 컬럼과 1:1로 매핑되는 필드를 가지고 있습니다.
 * Lombok 어노테이션을 사용하여 Getter, Setter, 생성자, ToString 메소드를 자동으로 생성합니다.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MenuDTO {
  private int menuCode;
  private String menuName;
  private int menuPrice;
  private int categoryCode;
  private String orderableStatus;
}
