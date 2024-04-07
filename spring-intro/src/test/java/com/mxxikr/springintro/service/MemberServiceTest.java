package com.mxxikr.springintro.service;

import com.mxxikr.springintro.domain.Member;
import com.mxxikr.springintro.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberServiceTest {
    private final MemberService memberService = new MemberService();
    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    public void joinTest() throws Exception {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long serviceId = memberService.join(member);

        // then
        Member findMember = memberRepository.findById(serviceId).get();
        assertEquals(member.getName(), findMember.getName());
    }
}
