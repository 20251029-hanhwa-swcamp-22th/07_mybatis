package org.ho.transaction.domain;

import lombok.Getter;
import lombok.Setter;


/* Domain
 * - 해결하려는 비즈니스 영역의 핵심 모델
 * - DB 테이블과 1:1 매핑되는 객체
 * - Service <-> DAO(Repository) <-> DB
 * - 하나의 Entity(개체)를 의미
 * - 테이블과 같은 모양으로 데이터를 취급하는 객체
 *  */
@Getter
@Setter
public class Order {
  private int orderCode;
  private String orderDate;
  private String orderTime;
  private int totalOrderPrice;
}