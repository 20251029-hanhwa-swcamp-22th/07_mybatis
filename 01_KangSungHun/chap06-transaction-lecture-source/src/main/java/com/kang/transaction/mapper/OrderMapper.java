package com.kang.transaction.mapper;

import com.kang.transaction.domain.Order;
import com.kang.transaction.domain.OrderMenu;
import com.kang.transaction.dto.OrderMenuDTO;
import org.apache.ibatis.annotations.Mapper;

// Mybatis가 해당 인터페이스를 구현한 객체(proxy)로 만들고
// 이를 Bean으로 등록

@Mapper
public interface OrderMapper {

    void insertOrder(Order order);

    void insertOrderMenu(OrderMenu orderMenu);

}
