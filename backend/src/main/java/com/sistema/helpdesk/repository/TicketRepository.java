package com.sistema.helpdesk.repository;

import com.sistema.helpdesk.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<Ticket, Long> {
}