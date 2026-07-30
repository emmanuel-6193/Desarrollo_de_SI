package com.sistema.helpdesk.controller;

import com.sistema.helpdesk.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    // Utiliza el Singleton del Gestor de Incidentes
    private final GestorIncidentesService gestorService = GestorIncidentesService.getInstance();

    // GET: Obtener todos los tickets
    @GetMapping
    public List<Ticket> obtenerTodos() {
        return gestorService.obtenerTodos();
    }

    // POST: Crear un nuevo ticket (Factory Method)
    @PostMapping
    public ResponseEntity<Ticket> crearTicket(
            @RequestParam String tipo,
            @RequestParam String titulo,
            @RequestParam String descripcion,
            @RequestParam Categoria categoria,
            @RequestParam Prioridad prioridad,
            @RequestParam(required = false) String detalleExtra) {
        
        Ticket nuevoTicket = gestorService.crearTicket(tipo, titulo, descripcion, categoria, prioridad, detalleExtra);
        return ResponseEntity.ok(nuevoTicket);
    }

    // GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> obtenerPorId(@PathVariable Long id) {
        return gestorService.obtenerTodos().stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT: Asignar un técnico (Observer)
    @PutMapping("/{id}/asignar")
    public ResponseEntity<Ticket> asignarTecnico(@PathVariable Long id, @RequestParam String tecnico) {
        Ticket actualizado = gestorService.asignarTecnico(id, tecnico);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // PUT: Resolver/Solucionar un ticket
    @PutMapping("/{id}/resolver")
    public ResponseEntity<Ticket> resolverTicket(@PathVariable Long id) {
        Ticket resuelto = gestorService.resolverTicket(id);
        if (resuelto != null) {
            return ResponseEntity.ok(resuelto);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE: Eliminar un ticket por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable Long id) {
        boolean eliminado = gestorService.eliminarTicket(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}