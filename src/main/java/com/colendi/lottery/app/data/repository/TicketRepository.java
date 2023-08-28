package com.colendi.lottery.app.data.repository;

import com.colendi.lottery.app.data.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    List<Ticket> findByUserId(Integer userId);

    Ticket save(Ticket ticket);

    @Query("SELECT u.id as user_id, u.email, u.firstName, u.lastName, t.id as ticket_id, t.userId " +
            "FROM User u LEFT JOIN Ticket t ON t.userId = u.id WHERE u.id = :userId")
    List<Object[]> findUserById(Integer userId);

}
