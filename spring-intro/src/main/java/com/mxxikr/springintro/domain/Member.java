package com.mxxikr.springintro.domain;

/**
 * 회원 도메인 클래스
 */
public class Member {
    private Long id; // 데이터 저장 위한 시스템 id
    private String name; // 고객이 입력할 회원 이름

    /**
     * id 반환
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * id 설정
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * name 반환
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * name 설정
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
