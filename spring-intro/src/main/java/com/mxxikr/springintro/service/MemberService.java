package com.mxxikr.springintro.service;

import com.mxxikr.springintro.domain.Member;
import com.mxxikr.springintro.repository.MemberRepository;

import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름을 가진 회원은 중복 회원으로 가입 불가
        Optional<Member> result = memberRepository.findByName(member.getName());    
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        memberRepository.save(member);
        return member.getId();
    }
}
