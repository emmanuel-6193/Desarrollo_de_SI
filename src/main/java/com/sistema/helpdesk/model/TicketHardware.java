package com.sistema.helpdesk.model;

public class TicketHardware extends Ticket {
    private String dispositivoAfectado;

    public TicketHardware(String titulo, String descripcion, Categoria categoria, Prioridad prioridad, String detalleExtra) {
        super(titulo, descripcion, categoria, prioridad);
        this.dispositivoAfectado = detalleExtra;
    }

    public String getDispositivoAfectado() {
        return dispositivoAfectado;
    }

    public void setDispositivoAfectado(String dispositivoAfectado) {
        this.dispositivoAfectado = dispositivoAfectado;
    }
}