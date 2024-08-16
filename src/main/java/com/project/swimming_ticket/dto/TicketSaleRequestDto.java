package com.project.swimming_ticket.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TicketSaleRequestDto {

    private String customerName;
    private int numberOfTickets;
    private LocalDate date;
}
