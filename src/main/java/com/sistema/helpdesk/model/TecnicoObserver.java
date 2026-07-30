package com.sistema.helpdesk.model;

public class TecnicoObserver implements Observer {
    private String nombre;

    public TecnicoObserver(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("🚨 [NOTIFICACIÓN TECNICO - " + nombre.toUpperCase() + "]: " + mensaje);
    }

    public String getNombre() {
        return nombre;
    }
}