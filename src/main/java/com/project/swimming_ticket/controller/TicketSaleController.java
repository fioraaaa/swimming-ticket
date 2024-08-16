package com.project.swimming_ticket.controller;

import com.project.swimming_ticket.dto.TicketSaleRequestDto;
import com.project.swimming_ticket.dto.TicketSaleResponseDto;
import com.project.swimming_ticket.service.TicketSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketSaleController {

    @Autowired
    private TicketSaleService service;

    @GetMapping
    public List<TicketSaleResponseDto> getAllTicketSales() {
        return service.getAllTicketSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketSaleResponseDto> getTicketSaleById(@PathVariable Long id) {
        TicketSaleResponseDto ticketSale = service.getTicketSaleById(id);
        if (ticketSale != null) {
            return new ResponseEntity<>(ticketSale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TicketSaleResponseDto> createTicketSale(@RequestBody TicketSaleRequestDto requestDto) {
        TicketSaleResponseDto savedTicketSale = service.saveTicketSale(requestDto);
        return new ResponseEntity<>(savedTicketSale, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketSale(@PathVariable Long id) {
        service.deleteTicketSale(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
