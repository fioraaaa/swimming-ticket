package com.project.swimming_ticket.repository;

import com.project.swimming_ticket.model.TicketSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketSaleRepository extends JpaRepository<TicketSale, Long> {
}

