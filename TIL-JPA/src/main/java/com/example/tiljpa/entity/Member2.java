package com.example.tiljpa.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Member2 {
    @Id
    private String id;

    private String username;

    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    private Team2 team2;


    @OneToMany(mappedBy = "member2",fetch = FetchType.LAZY)
    private List<Order>orders;
}
