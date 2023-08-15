package com.colendi.lottery.app.data.repository;

import com.colendi.lottery.app.data.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {

    List<Ticket> findByUserId(Integer userId);

    Ticket save(Ticket ticket);

    @Query("SELECT t1.id, t1.firstName, t1.lastName, t1.email, t2.ticketId, t2.userId " +
            "FROM Table1 t1 INNER JOIN Table2 t2 ON t1.id = t2.userId")
    List<Object[]> customJoinQuery();

}
