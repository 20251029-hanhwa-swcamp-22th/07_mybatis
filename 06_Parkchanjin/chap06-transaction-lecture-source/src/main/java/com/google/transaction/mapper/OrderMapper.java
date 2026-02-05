package com.google.transaction.mapper;


import com.google.transaction.domain.Order;
import com.google.transaction.domain.OrderMenu;
import org.apache.ibatis.annotations.Mapper;
// Mybatis가 알아서 프록시를 통해 DAO 역할을 해줌
// Mybatis 가 해당 인터페이스를 구현하여 객체(proxy)로 만들고
// 이를 Bean으로 등록
@Mapper
public interface OrderMapper {

  void insertOrder(Order order);

  void insertOrderMenu(OrderMenu menu);
}
