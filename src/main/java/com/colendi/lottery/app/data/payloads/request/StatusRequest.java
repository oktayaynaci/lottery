package com.colendi.lottery.app.data.payloads.request;

import com.colendi.lottery.app.data.models.TicketStatus;

import java.util.UUID;

public class StatusRequest {
    private TicketStatus ticketStatus;


    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}

