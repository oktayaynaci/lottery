package com.colendi.lottery.app.data.payloads.request;

import jakarta.persistence.Column;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class TicketRequest {

    @NotBlank
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
