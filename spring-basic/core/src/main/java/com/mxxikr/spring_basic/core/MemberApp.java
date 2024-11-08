package com.mxxikr.spring_basic.core;

import com.mxxikr.spring_basic.core.member.Grade;
import com.mxxikr.spring_basic.core.member.Member;
import com.mxxikr.spring_basic.core.member.MemberService;
import com.mxxikr.spring_basic.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("newMember = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
