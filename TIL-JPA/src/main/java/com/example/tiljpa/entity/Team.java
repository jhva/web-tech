package com.example.tiljpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;

    /**
     * 팀은과 회원은 일대 다 관계
     * @mappedBy : 양방향 매핑일 때 사용하는데, 반대쪽 매핑의 필드 이름을 값으로 주면된다 .
     */
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

}
