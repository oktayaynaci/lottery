package com.colendi.lottery.app.service;

import com.colendi.lottery.app.data.models.Status;
import com.colendi.lottery.app.data.models.TicketStatus;

import java.util.UUID;

public interface StatusService {
    Status createStatusForTicket(UUID ticketId, TicketStatus ticketStatus);

}