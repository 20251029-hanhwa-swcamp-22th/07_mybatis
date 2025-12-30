package com.kth.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryAndMenuDTO {
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

    private List<MenuDTO> menuList;
}