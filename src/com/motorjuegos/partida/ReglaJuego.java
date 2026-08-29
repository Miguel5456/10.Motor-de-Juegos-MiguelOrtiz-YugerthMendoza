package com.motorjuegos.partida;

public class ReglaJuego {

    private String nombre;
    private String descripcion;

    public ReglaJuego(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public boolean validarReglas() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}