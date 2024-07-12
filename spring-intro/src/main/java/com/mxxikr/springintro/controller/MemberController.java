package com.mxxikr.springintro.controller;

import com.mxxikr.springintro.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// @Controller 어노테이션을 사용하면 스프링 컨테이너에 컨트롤러로 등록
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
