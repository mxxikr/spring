package com.mxxikr.springintro.service;

import com.mxxikr.springintro.domain.Member;
import com.mxxikr.springintro.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {
    private final MemberService memberService = new MemberService();
    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입 테스트
     */
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

    /**
     * 중복 회원 예외 테스트
     */
    @Test
    public void duplicateMemberTest() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2)); // 예외가 발생해야함

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
