package com.sistema.helpdesk.model;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GestorIncidentesService {

    // 1. Instancia única (Patrón Singleton)
    private static GestorIncidentesService instancia;

    private final List<Ticket> listaTickets = new ArrayList<>();
    private final Map<String, TecnicoObserver> observadores = new HashMap<>();
    private Long contadorId = 1L;

    // 2. Constructor privado (Singleton)
    private GestorIncidentesService() {
        observadores.put("Tecnico_Redes", new TecnicoObserver("Técnico de Redes"));
        observadores.put("Tecnico_Software", new TecnicoObserver("Técnico de Software"));
    }

    // 3. Punto de acceso global (Singleton)
    public static synchronized GestorIncidentesService getInstance() {
        if (instancia == null) {
            instancia = new GestorIncidentesService();
        }
        return instancia;
    }

    // Crear ticket usando la FÁBRICA (Factory Method)
    public Ticket crearTicket(String tipo, String titulo, String descripcion, Categoria categoria, Prioridad prioridad, String detalleExtra) {
        Ticket nuevoTicket = TicketFactory.crearTicket(tipo, titulo, descripcion, categoria, prioridad, detalleExtra);
        nuevoTicket.setId(contadorId++);
        listaTickets.add(nuevoTicket);
        return nuevoTicket;
    }

    public List<Ticket> obtenerTodos() {
        return listaTickets;
    }

    // Asignar técnico y NOTIFICAR (Observer)
    public Ticket asignarTecnico(Long id, String nombreTecnico) {
        for (Ticket ticket : listaTickets) {
            if (ticket.getId().equals(id)) {
                ticket.setTecnicoAsignado(nombreTecnico);
                ticket.setEstado(Estado.EN_PROCESO);

                // Disparar la notificación
                TecnicoObserver observador = observadores.get(nombreTecnico);
                if (observador != null) {
                    observador.notificar("Se te ha asignado el ticket #" + id + ": " + ticket.getTitulo());
                }
                return ticket;
            }
        }
        return null;
    }

    // 4. NUEVO: Resolver un ticket por ID
    public Ticket resolverTicket(Long id) {
        for (Ticket ticket : listaTickets) {
            if (ticket.getId().equals(id)) {
                ticket.setEstado(Estado.RESUELTO);
                return ticket;
            }
        }
        return null;
    }

    // 5. NUEVO: Eliminar un ticket por ID
    public boolean eliminarTicket(Long id) {
        return listaTickets.removeIf(ticket -> ticket.getId().equals(id));
    }
}