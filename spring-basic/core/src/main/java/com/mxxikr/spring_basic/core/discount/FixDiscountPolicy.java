package com.mxxikr.spring_basic.core.discount;

import com.mxxikr.spring_basic.core.member.Grade;
import com.mxxikr.spring_basic.core.member.Member;

// 정액 할인 정책 구현체
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
