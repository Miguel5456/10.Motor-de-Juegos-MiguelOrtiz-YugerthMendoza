package com.motorjuegos;

import com.motorjuegos.jugador.Jugador;
import com.motorjuegos.partida.Partida;
import com.motorjuegos.partida.ReglaJuego;
import com.motorjuegos.ranking.Ranking;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(
                "========================================"
        );

        System.out.println(
                "     MOTOR DE JUEGOS MULTIJUGADOR"
        );

        System.out.println(
                "========================================"
        );


        // ==============================
        // CREAR JUGADORES
        // ==============================

        Jugador jugador1 = new Jugador(
                1L,
                "PlayerOne",
                "playerone@gmail.com"
        );

        Jugador jugador2 = new Jugador(
                2L,
                "PlayerTwo",
                "playertwo@gmail.com"
        );

        Jugador jugador3 = new Jugador(
                3L,
                "PlayerThree",
                "playerthree@gmail.com"
        );


        // ==============================
        // CREAR PARTIDA 1
        // ==============================

        ReglaJuego regla = new ReglaJuego(
                "Partida estándar",
                "El jugador con mayor puntuación gana."
        );

        Partida partida1 = new Partida(
                1L,
                "Partida #1",
                4,
                regla
        );

        partida1.agregarJugador(jugador1);
        partida1.agregarJugador(jugador2);

        partida1.iniciar();

        partida1.finalizar(jugador1);


        // ==============================
        // CREAR PARTIDA 2
        // ==============================

        Partida partida2 = new Partida(
                2L,
                "Partida #2",
                4,
                regla
        );

        partida2.agregarJugador(jugador1);
        partida2.agregarJugador(jugador3);

        partida2.iniciar();

        partida2.finalizar(jugador3);


        // ==============================
        // CREAR PARTIDA 3
        // ==============================

        Partida partida3 = new Partida(
                3L,
                "Partida #3",
                4,
                regla
        );

        partida3.agregarJugador(jugador1);
        partida3.agregarJugador(jugador2);

        partida3.iniciar();

        partida3.finalizar(jugador1);


// ==============================
// OBTENER RANKING SINGLETON
// ==============================

        Ranking ranking =
                Ranking.getInstancia();

        Ranking otroRanking =
                Ranking.getInstancia();

        System.out.println(
                "\n¿Es la misma instancia? "
                        + (ranking == otroRanking)
        );

// ==============================
// ACTUALIZAR RANKING
// ==============================

        ranking.actualizar(
                List.of(
                        jugador1,
                        jugador2,
                        jugador3
                )
        );


// ==============================
// MOSTRAR RANKING
// ==============================

        ranking.mostrar();
    }
}