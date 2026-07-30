package com.sistema.helpdesk.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SOFTWARE")
public class TicketSoftware extends Ticket {

    private String modulo;

    public TicketSoftware() {}

    public TicketSoftware(String titulo, String descripcion, Categoria categoria, Prioridad prioridad, String modulo) {
        super(titulo, descripcion, categoria, prioridad);
        this.modulo = modulo;
    }

    public String getModulo() { return modulo; }
    public void setModulo(String modulo) { this.modulo = modulo; }
}