package com.ohgiraffers.dto;

import lombok.*;

import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryAndMenuDTO {
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

    private List<MenuDTO> menuList; // 이번엔 여러개라 변경
}