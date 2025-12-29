package com.ohgiraffers.transaction.service;

import com.ohgiraffers.transaction.domain.Order;
import com.ohgiraffers.transaction.domain.OrderMenu;
import com.ohgiraffers.transaction.dto.OrderDTO;
import com.ohgiraffers.transaction.dto.OrderMenuDTO;
import com.ohgiraffers.transaction.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
/* DTO(Data Transfer Object)
* 계층간 이동 (클래스 사이 이동)
* 전달하고 싶은 데이터만 팔드로 작성
* View <-> Contiller <-> Service
* 순수 데이터 컨테이너*/


/* Domein
* 해결하려는 비즈니스 영역의 핵심모델
* DB 테이블과 1:1 매핑되는 객체
* Service <-> DAO(Repository, Mapper) <-> DB
* 하나의 Entity(개체)를 의미
* 테이블과 같은 모양으로 데이터를 취급하느 객체*/

/* rollbackFor = Runtimeinseption
Spring은 기본적으로
* 모든 예외를 Unchecked로 변환
* 서버가 절대 꺼지지 않게 (예외발생X)*/

@Service

public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /**
     * 주문 등록 메서드
     * @param orderDTO
     * @param orderMenuDTOs
     */

    @Transactional (
            isolation = Isolation.DEFAULT, // 하나의 트랜잭션으로 처리
            propagation = Propagation.REQUIRED, // 트랜잭션이 있으면 참여, 없으면 생성
             rollbackFor = Exception.class // 발생한 예외 종류관계없이 모두 출력

    )
    public void registerOrder(
            OrderDTO orderDTO, List<OrderMenuDTO> orderMenuDTOs
    ){

        // DTO -> Domain 변환
        Order order = new Order();
        order.setOrderDate(orderDTO.getOrderDate());
        order.setOrderTime(orderDTO.getOrderTime());
        order.setTotalOrderPrice(orderDTO.getTotalOrderPrice());

        // tbl_order에 주문 정보 삽입 (Domain을 전달)
        orderMapper.insertOrder(order);

        // tbl_order 테이블에 삽입된 order_code 번호 얻어오기
        int orderCode = order.getOrderCode();

        // DTO -> Domain 변환
        List<OrderMenu> orderMenus = orderMenuDTOs.stream().map(dto -> {
            OrderMenu om = new OrderMenu();
            om.setMenuCode(dto.getMenuCode());
            om.setOrderAmount(dto.getOrderAmount());

            // 주문 등록 후 auto generated 된 orderCode를 각 주문 메뉴에 설정
            om.setOrderCode(orderCode);
            return om;
        }).collect(Collectors.toList());

        // 메뉴 정보 삽입
        orderMenus.forEach(orderMenu -> {
            orderMapper.insertOrderMenu(orderMenu);
        });

    }
}
