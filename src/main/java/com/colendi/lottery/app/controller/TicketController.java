package com.colendi.lottery.app.controller;

import com.colendi.lottery.app.data.models.Ticket;
import com.colendi.lottery.app.data.payloads.request.TicketRequest;
import com.colendi.lottery.app.data.payloads.response.MessageResponse;
import com.colendi.lottery.app.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addTicket( @RequestBody TicketRequest ticket) {
        MessageResponse newTicket = ticketService.createTicket(ticket);
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Ticket> getUserById (@PathVariable("id") UUID id) {
        Ticket ticket = ticketService.getASingleTicket(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets () {
        List<Ticket> tickets = ticketService.getAllTicket();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") String ticketId) {
        ticketService.deleteTicket(UUID.fromString(ticketId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-by-user/{id}")
    public ResponseEntity<?> getByUserId(@PathVariable("id") String userId) {
        List<Ticket> tickets = ticketService.getASingleTicketByUserId(Integer.parseInt(userId));
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

}
