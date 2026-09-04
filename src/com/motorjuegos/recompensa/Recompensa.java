package com.motorjuegos.recompensa;

public class Recompensa {

    private String nombre;
    private String descripcion;
    private int cantidad;

    public Recompensa(
            String nombre,
            String descripcion,
            int cantidad) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public void entregar() {
        System.out.println(
                "Recompensa entregada: "
                        + nombre
                        + " - Cantidad: "
                        + cantidad
        );
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }
}