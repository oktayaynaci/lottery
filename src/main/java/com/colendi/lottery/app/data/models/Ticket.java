package com.colendi.lottery.app.data.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "userId")
    private Integer userId;

    @Column(name= "lotteryName")
    private String lotteryName;

    @Column(name="price")
    private Integer price;

    @Column(name = "lotteryStartDate")
    private LocalDateTime lotteryStartDate;

    @Column(name = "lotteryEndDate")
    private LocalDateTime lotteryEndDate;

    @Column(name = "createDate")
    private LocalDateTime createDate;

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

    public String getLotteryName() {
        return lotteryName;
    }

    public void setLotteryName(String lotteryName) {
        this.lotteryName = lotteryName;
    }

    public Integer getPrice() {return price;}

    public void setPrice(Integer price) {this.price = price;}

    public LocalDateTime getLotteryStartDate() {
        return lotteryStartDate;
    }

    public void setLotteryStartDate(LocalDateTime lotteryStartDate) {
        this.lotteryStartDate = lotteryStartDate;
    }

    public LocalDateTime getLotteryEndDate() {
        return lotteryEndDate;
    }

    public void setLotteryEndDate(LocalDateTime lotteryEndDate) {
        this.lotteryEndDate = lotteryEndDate;
    }
    public void setCreateDateToNow() {
        this.createDate = LocalDateTime.now();
    }

}













