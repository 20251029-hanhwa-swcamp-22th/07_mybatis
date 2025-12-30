package com.ohgiraffers.dto;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuAndCategoryDTO {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private CategoryDTO category;
    private String orderableStatus;
}