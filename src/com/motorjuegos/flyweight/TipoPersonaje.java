
package com.motorjuegos.flyweight;

public class TipoPersonaje {

    private final String nombre;
    private final String modelo;
    private final String habilidadBase;

    public TipoPersonaje(
            String nombre,
            String modelo,
            String habilidadBase) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.habilidadBase = habilidadBase;
    }

    public void mostrar(String jugador, int posicionX, int posicionY) {
        System.out.println(
                "Jugador: " + jugador
                        + " | Tipo: " + nombre
                        + " | Modelo: " + modelo
                        + " | Habilidad: " + habilidadBase
                        + " | Posición: (" + posicionX + ", " + posicionY + ")"
        );
    }

    public String getNombre() {
        return nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public String getHabilidadBase() {
        return habilidadBase;
    }
}
