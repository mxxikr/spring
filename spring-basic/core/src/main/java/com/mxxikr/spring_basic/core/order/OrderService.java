package com.mxxikr.spring_basic.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
