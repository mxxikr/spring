package com.mxxikr.springintro.domain;

public class Member {
    private Long id; // 데이터 저장 위한 시스템 id
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
