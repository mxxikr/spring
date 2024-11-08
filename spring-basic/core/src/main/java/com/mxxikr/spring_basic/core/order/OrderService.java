package com.mxxikr.spring_basic.core.order;

// 주문 서비스 인터페이스
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}