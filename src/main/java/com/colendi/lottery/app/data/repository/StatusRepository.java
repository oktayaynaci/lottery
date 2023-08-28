package com.colendi.lottery.app.data.repository;

import com.colendi.lottery.app.data.models.Status;
import com.colendi.lottery.app.data.models.Ticket;
import com.colendi.lottery.app.data.models.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    //Optional<Status>findByTicket(Ticket ticket);

    //Optional<Status> findByTicketId(String toString);
    Optional<Status> findByTicketAndTicketStatus(Ticket ticket, TicketStatus won);
    List<Status> findByTicketStatus(TicketStatus won);
}
