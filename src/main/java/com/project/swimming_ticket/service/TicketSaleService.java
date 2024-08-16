package com.project.swimming_ticket.service;

import com.project.swimming_ticket.dto.TicketSaleRequestDto;
import com.project.swimming_ticket.dto.TicketSaleResponseDto;
import com.project.swimming_ticket.model.TicketSale;
import com.project.swimming_ticket.repository.TicketSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketSaleService {

    @Autowired
    private TicketSaleRepository repository;

    public List<TicketSaleResponseDto> getAllTicketSales() {
        return repository.findAll().stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public TicketSaleResponseDto getTicketSaleById(Long id) {
        return repository.findById(id)
                .map(this::convertToResponseDto)
                .orElse(null);
    }

    public TicketSaleResponseDto saveTicketSale(TicketSaleRequestDto requestDto) {
        TicketSale ticketSale = convertToEntity(requestDto);
        TicketSale savedTicketSale = repository.save(ticketSale);
        return convertToResponseDto(savedTicketSale);
    }

    public void deleteTicketSale(Long id) {
        repository.deleteById(id);
    }

    private TicketSale convertToEntity(TicketSaleRequestDto requestDto) {
        TicketSale ticketSale = new TicketSale();
        ticketSale.setCustomerName(requestDto.getCustomerName());
        ticketSale.setNumberOfTickets(requestDto.getNumberOfTickets());
        ticketSale.setDate(requestDto.getDate());
        return ticketSale;
    }

    private TicketSaleResponseDto convertToResponseDto(TicketSale ticketSale) {
        TicketSaleResponseDto responseDto = new TicketSaleResponseDto();
        responseDto.setId(ticketSale.getId());
        responseDto.setCustomerName(ticketSale.getCustomerName());
        responseDto.setNumberOfTickets(ticketSale.getNumberOfTickets());
        responseDto.setDate(ticketSale.getDate());
        return responseDto;
    }
}

