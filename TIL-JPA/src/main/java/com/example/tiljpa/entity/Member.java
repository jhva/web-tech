package com.example.tiljpa.entity;


import com.example.tiljpa.dto.RoleType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
//@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(
//        name = "NAME_AGE_UNIQUE",
//        columnNames = {"NAME", "AGE"}
//)})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "name", nullable = false, length = 10)
    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    public Team team;
//
//    @OneToOne
//    private Locker locker;

//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
}
