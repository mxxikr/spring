package com.mxxikr.springintro.controller;

import com.mxxikr.springintro.domain.Member;
import com.mxxikr.springintro.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// @Controller 어노테이션을 사용하면 스프링 컨테이너에 컨트롤러로 등록
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원 등록 폼 화면으로 이동
     * @return
     */
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    /**
     * 회원 등록
     * @param form
     * @return
     */
    @PostMapping("/members/new")
    public String create(MemberForm form) {
    Member member = new Member();
    member.setName(form.getName()); // 회원 이름 설정

    memberService.join(member);

    return "redirect:/"; // 홈 화면으로 리다이렉트
    }
}
