package com.project.swimming_ticket.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TicketSaleResponseDto {

    private Long id;
    private String customerName;
    private int numberOfTickets;
    private LocalDate date;
}

