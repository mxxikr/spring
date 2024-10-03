package com.mxxikr.springintro;

import com.mxxikr.springintro.repository.JdbcMemberRepository;
import com.mxxikr.springintro.repository.MemberRepository;
import com.mxxikr.springintro.repository.MemoryMemberRepository;
import com.mxxikr.springintro.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration // 스프링 컨테이너가 뜰 때 스프링 빈을 등록
public class SpringConfig {

    private final DataSource dataSource; // 데이터베이스 커넥션을 획득할 때 사용하는 객체

    public SpringConfig(DataSource dataSource) { // 생성자를 통해 DataSource 주입
        this.dataSource = dataSource;
    }

    @Bean // 스프링 빈 등록
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource); // JdbcMemberRepository로 변경
    }
}
