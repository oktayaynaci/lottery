package com.colendi.lottery.app.data.models;

import com.colendi.lottery.app.data.models.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@RequiredArgsConstructor
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

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Status> statuses = new ArrayList<>();

    public void setCreateDateToNow() {
        this.createDate = LocalDateTime.now();
    }

}
