package com.example.tiljpa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {
    @Id
    private String id;
}
