package org.ho.transaction.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/* DTO(Data Transfer Object)
 * - 계층간 이동(클래스 사이 이동)
 * - 전달하고 싶은 데이터만 필드로 작성
 * - View <-> Controller <-> Service
 * - 순수 데이터 컨테이너
 *  */
@Getter
@Setter
@ToString
public class OrderDTO {
  private String orderDate;
  private String orderTime;
  private int totalOrderPrice;
}