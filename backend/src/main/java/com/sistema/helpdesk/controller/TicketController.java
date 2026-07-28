package com.sistema.helpdesk.controller;

import com.sistema.helpdesk.model.Ticket;
import com.sistema.helpdesk.repository.TicketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    private final TicketRepository ticketRepository;

    // Inyección por constructor (Buena práctica de Spring)
    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping
    public List<Ticket> obtenerTodos() {
        return ticketRepository.findAll();
    }

    @PostMapping
    public Ticket crearTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> obtenerPorId(@PathVariable Long id) {
        return ticketRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> actualizarTicket(@PathVariable Long id, @RequestBody Ticket detallesTicket) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    ticket.setTitulo(detallesTicket.getTitulo());
                    ticket.setDescripcion(detallesTicket.getDescripcion());
                    ticket.setCategoria(detallesTicket.getCategoria());
                    ticket.setPrioridad(detallesTicket.getPrioridad());
                    ticket.setEstado(detallesTicket.getEstado());
                    Ticket actualizado = ticketRepository.save(ticket);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable Long id) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    ticketRepository.delete(ticket);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}