package org.ho.transaction.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.ho.transaction.domain.Order;
import org.ho.transaction.domain.OrderMenu;

// Mybatis가 해당 인터페이스를 구현하여 객체(proxy)로 만들고
// 이를 Bean으로 등록
@Mapper
public interface OrderMapper {
  void insertOrder(Order order);

  void insertOrderMenu(OrderMenu orderMenu);
}
