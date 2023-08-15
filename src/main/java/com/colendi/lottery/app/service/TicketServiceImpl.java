package com.colendi.lottery.app.service;

import com.colendi.lottery.app.data.models.Ticket;
import com.colendi.lottery.app.data.payloads.request.TicketRequest;
import com.colendi.lottery.app.data.payloads.response.MessageResponse;
import com.colendi.lottery.app.data.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;


    @Override
    public MessageResponse createTicket(TicketRequest ticketRequest) {
        // if(userExists)
        //    saveToDb();
        // else
        //    return error;


        Ticket newTicket = new Ticket();
        newTicket.setUserId(ticketRequest.getUserId());
        ticketRepository.save(newTicket);
        return new MessageResponse("New ticket created successfully");
    }

    @Override
    public void deleteTicket(UUID ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    @Override
    public Ticket getASingleTicket(UUID ticketId) {
        return null;
    }


    @Override
    public List<Ticket> getASingleTicketByUserId(Integer userId) {
        return ticketRepository.findByUserId(userId);
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }
}
