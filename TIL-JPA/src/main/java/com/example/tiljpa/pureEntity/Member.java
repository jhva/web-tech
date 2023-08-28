package com.example.tiljpa.pureEntity;


import lombok.AllArgsConstructor;

public class Member {


    public Member(String id, String username) {
        this.id = id;
        this.username = username;
    }

    private String id;
    private String username;
//    private Team team;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Team getTeam() {
//        return team;
//    }

//    public void setTeam(Team team) {
//        this.team = team;
//    }
}
