package com.mxxikr.springintro.service;

import com.mxxikr.springintro.domain.Member;
import com.mxxikr.springintro.repository.MemberRepository;
import com.mxxikr.springintro.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * 생성자를 통한 의존성 주입
     * MemoryMemberRepository 객체를 주입
     */
    @Autowired
    public MemberService(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member); // 회원 저장
        return member.getId(); // 회원 id 반환
    }

    /**
     * 중복 회원 검증
     * .ifPresent() : Optional에 값이 있으면 실행
     * .orElseGet() : Optional에 값이 있으면 꺼내고 없으면 뒤에 있는 것을 실행
     * .orElseThrow() : Optional에 값이 있으면 꺼내고 없으면 예외를 던짐
     *
     * IllegalArgumentException : 잘못된 인자를 전달했을 때 발생하는 예외
     */
    public void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * id로 회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
