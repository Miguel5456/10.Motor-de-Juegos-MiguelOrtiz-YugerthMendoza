package com.motorjuegos;

import com.motorjuegos.jugador.Jugador;
import com.motorjuegos.partida.Partida;
import com.motorjuegos.partida.ReglaJuego;
import com.motorjuegos.ranking.Ranking;
import com.motorjuegos.recompensa.CreadorRecompensa;
import com.motorjuegos.recompensa.CreadorRecompensaExperiencia;
import com.motorjuegos.recompensa.CreadorRecompensaItem;
import com.motorjuegos.recompensa.CreadorRecompensaMonedas;
import com.motorjuegos.recompensa.Recompensa;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("     MOTOR DE JUEGOS MULTIJUGADOR");
        System.out.println("========================================");

        // Crear el motor
        MotorJuego motor = new MotorJuego();

        // Crear jugadores
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

        // Registrar jugadores en el motor
        motor.registrarJugador(jugador1);
        motor.registrarJugador(jugador2);
        motor.registrarJugador(jugador3);

        // Crear regla de juego
        ReglaJuego regla = new ReglaJuego(
                "Partida estándar",
                "El jugador con mayor puntuación gana."
        );

        // ================================
        // RECOMPENSAS - FACTORY METHOD
        // ================================

      /*  CreadorRecompensa creadorMonedas =
                new CreadorRecompensaMonedas();

        Recompensa recompensaMonedas =
                creadorMonedas.crearRecompensa(100);

        jugador1.recibirRecompensa(recompensaMonedas);

        CreadorRecompensa creadorExperiencia =
                new CreadorRecompensaExperiencia();

        Recompensa recompensaExperiencia =
                creadorExperiencia.crearRecompensa(50);

        jugador1.recibirRecompensa(recompensaExperiencia);

        CreadorRecompensa creadorItem =
                new CreadorRecompensaItem();

        Recompensa recompensaItem =
                creadorItem.crearRecompensa(1);

        jugador1.recibirRecompensa(recompensaItem); */

// ================================
// SIMULACIÓN DE PARTIDAS
// ================================

        motor.simularPartidas(5, regla);

        // ================================
        // SINGLETON - RANKING
        // ================================

        Ranking ranking = Ranking.getInstancia();

        Ranking otroRanking = Ranking.getInstancia();

        System.out.println(
                "\n¿Es la misma instancia? "
                        + (ranking == otroRanking)
        );

        // Actualizar y mostrar ranking mediante el motor

        motor.mostrarRanking();
    }
}