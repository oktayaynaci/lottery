package com.colendi.lottery.app.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus ticketStatus;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    @JsonBackReference
    private Ticket ticket;

    @Column(nullable = false)
    private LocalDateTime createdAt;

}
