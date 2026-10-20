
package com.motorjuegos.flyweight;

public class Personaje {

    private final String jugador;
    private final int posicionX;
    private final int posicionY;
    private final TipoPersonaje tipo;
    public Personaje(
            String jugador,
            int posicionX,
            int posicionY,
            TipoPersonaje tipo) {
        this.jugador = jugador;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.tipo = tipo;
    }
    public void mostrar() {
        tipo.mostrar(jugador, posicionX, posicionY);
    }
    public TipoPersonaje getTipo() {
        return tipo;
    }
}

