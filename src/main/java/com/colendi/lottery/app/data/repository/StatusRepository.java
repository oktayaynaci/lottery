package com.colendi.lottery.app.data.repository;

import com.colendi.lottery.app.data.models.Status;
import com.colendi.lottery.app.data.models.Ticket;
import com.colendi.lottery.app.data.models.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByTicketAndTicketStatus(Ticket ticket, TicketStatus status);
}
