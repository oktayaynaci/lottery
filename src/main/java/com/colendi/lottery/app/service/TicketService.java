package com.colendi.lottery.app.service;

import com.colendi.lottery.app.data.models.Ticket;
import com.colendi.lottery.app.data.payloads.request.TicketRequest;
import com.colendi.lottery.app.data.payloads.response.MessageResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface TicketService {
    MessageResponse createTicket(TicketRequest ticketRequest);

    void deleteTicket(UUID ticketId);

    Ticket getASingleTicket(UUID ticketId);

    List<Ticket> getASingleTicketByUserId(Integer userId);

    List<Ticket> getAllTicket();

    Optional<Ticket> updateTicket(UUID ticketId, TicketRequest ticketRequest);

}