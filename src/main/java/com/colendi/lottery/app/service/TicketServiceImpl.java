package com.colendi.lottery.app.service;

import com.colendi.lottery.app.data.models.Ticket;
import com.colendi.lottery.app.data.payloads.request.TicketRequest;
import com.colendi.lottery.app.data.payloads.response.MessageResponse;
import com.colendi.lottery.app.data.repository.TicketRepository;
import com.colendi.lottery.app.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public MessageResponse createTicket(TicketRequest ticketRequest) {
        Integer userId = ticketRequest.getUserId();

        if (userRepository.existsById(userId)) {
            Ticket newTicket = new Ticket();
            newTicket.setUserId(userId);
            newTicket.setPrice(ticketRequest.getPrice());
            newTicket.setLotteryName(ticketRequest.getLotteryName());
            newTicket.setLotteryStartDate(ticketRequest.getLotteryStartDate());
            newTicket.setLotteryEndDate(ticketRequest.getLotteryEndDate());
            newTicket.setCreateDateToNow();

            ticketRepository.save(newTicket);
            return new MessageResponse("New ticket created successfully");
        } else {
            return new MessageResponse("User not found, ticket could not be created.");
        }
    }

    @Override
    public void deleteTicket(UUID ticketId) {
        ticketRepository.deleteById(ticketId.toString());
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

    @Override
    public Optional<Ticket> updateTicket(UUID ticketId, TicketRequest ticketRequest) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(String.valueOf(ticketId));
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();

            ticket.setId(String.valueOf(ticketRequest.getTicketId()));

            ticketRepository.save(ticket);
        }
        return optionalTicket;
    }

}