package com.sistema.helpdesk.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RED")
public class TicketRed extends Ticket {

    private String switchAfectado;

    public TicketRed() {}

    public TicketRed(String titulo, String descripcion, Categoria categoria, Prioridad prioridad, String switchAfectado) {
        super(titulo, descripcion, categoria, prioridad);
        this.switchAfectado = switchAfectado;
    }

    public String getSwitchAfectado() { return switchAfectado; }
    public void setSwitchAfectado(String switchAfectado) { this.switchAfectado = switchAfectado; }
}