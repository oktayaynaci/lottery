package com.colendi.lottery.app.data.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Ticket {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;*/
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "userId")
    private Integer userId;

    public Ticket() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}














