package com.colendi.lottery.app.controller;


import com.colendi.lottery.app.data.models.Status;
import com.colendi.lottery.app.data.models.TicketStatus;
import com.colendi.lottery.app.data.payloads.request.StatusRequest;
import com.colendi.lottery.app.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping("/update/{ticketId}")
    public ResponseEntity<String> updateStatus(@PathVariable UUID ticketId, @RequestBody StatusRequest ticketStatus) {
        try {
            Status newStatus = statusService.createStatusForTicket(ticketId, ticketStatus.getTicketStatus());
            return new ResponseEntity<>("Status updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
