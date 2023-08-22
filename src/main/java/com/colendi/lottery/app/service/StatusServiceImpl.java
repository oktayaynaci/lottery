package com.colendi.lottery.app.service;

import com.colendi.lottery.app.data.models.Status;
import com.colendi.lottery.app.data.models.Ticket;
import com.colendi.lottery.app.data.models.TicketStatus;
import com.colendi.lottery.app.data.repository.StatusRepository;
import com.colendi.lottery.app.data.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository, TicketRepository ticketRepository) {
        this.statusRepository = statusRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Status createStatusForTicket(UUID ticketId, TicketStatus ticketStatus) {
        Ticket ticket = ticketRepository.findById(String.valueOf(ticketId))
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        Status status = new Status();
        status.setTicket(ticket);
        status.setTicketStatus(ticketStatus);
        status.setCreatedAt(LocalDateTime.now());

        return statusRepository.save(status);
    }
}

