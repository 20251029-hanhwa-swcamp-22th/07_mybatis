package com.ohgiraffers.dto;


import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuDTO {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    private  CategoryDTO category;
        /*
    1. 중복 코드 줄이기
    2. 카테고리 코드에서 가져온 것이라고 구분
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
     */
}