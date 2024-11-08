package com.mxxikr.spring_basic.core.order;

import com.mxxikr.spring_basic.core.discount.DiscountPolicy;
import com.mxxikr.spring_basic.core.discount.FixDiscountPolicy;
import com.mxxikr.spring_basic.core.member.Member;
import com.mxxikr.spring_basic.core.member.MemberRepository;
import com.mxxikr.spring_basic.core.member.MemoryMemberRepository;

// 주문 서비스 구현체
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository(); // 회원 찾을 때 필요
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 할인 정책

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 찾기
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 정책에 할인 금액 넘기기

        return new Order(memberId, itemName, itemPrice, discountPrice); // 최종 생성된 주문 반환
    }
}
