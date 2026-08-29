package com.motorjuegos.ranking;

import com.motorjuegos.jugador.Jugador;

public class EntradaRanking {

    private Jugador jugador;
    private int posicion;
    private int puntuacion;

    public EntradaRanking(
            Jugador jugador,
            int posicion,
            int puntuacion) {

        this.jugador = jugador;
        this.posicion = posicion;
        this.puntuacion = puntuacion;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}
