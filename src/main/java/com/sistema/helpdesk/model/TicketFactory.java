package com.sistema.helpdesk.model;

public class TicketFactory {

    public static Ticket crearTicket(
            String tipo, 
            String titulo, 
            String descripcion, 
            Categoria categoria, 
            Prioridad prioridad, 
            String detalleExtra) {

        if ("RED".equalsIgnoreCase(tipo)) {
            return new TicketRed(titulo, descripcion, categoria, prioridad, detalleExtra);
        } else if ("SOFTWARE".equalsIgnoreCase(tipo)) {
            return new TicketSoftware(titulo, descripcion, categoria, prioridad, detalleExtra);
        }
        throw new IllegalArgumentException("Tipo de ticket no soportado: " + tipo);
    }
}