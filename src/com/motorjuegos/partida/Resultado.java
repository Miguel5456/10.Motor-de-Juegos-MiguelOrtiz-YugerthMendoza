package com.motorjuegos.partida;

import com.motorjuegos.jugador.Jugador;

public class Resultado {

    private Jugador ganador;
    private int puntuacion;

    public Resultado(Jugador ganador, int puntuacion) {
        this.ganador = ganador;
        this.puntuacion = puntuacion;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void mostrarResultado() {

        System.out.println("\n=== RESULTADO ===");
        System.out.println(
                "Ganador: " + ganador.getNombreUsuario()
        );
        System.out.println(
                "Puntuación: " + puntuacion
        );
    }
}