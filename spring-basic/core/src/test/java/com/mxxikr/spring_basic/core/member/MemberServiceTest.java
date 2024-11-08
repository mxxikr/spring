package com.mxxikr.spring_basic.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    private MemberService memberService = new MemberServiceImpl();
    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMemeber = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMemeber);  // 검증 코드
    }
}
