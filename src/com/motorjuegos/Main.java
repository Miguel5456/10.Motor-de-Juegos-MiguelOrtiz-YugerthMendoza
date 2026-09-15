package com.motorjuegos;

import com.motorjuegos.fabrica.FabricaJuego;
import com.motorjuegos.fabrica.FabricaJuegoCasual;
import com.motorjuegos.jugador.Jugador;
import com.motorjuegos.partida.Partida;
import com.motorjuegos.partida.ReglaJuego;
import com.motorjuegos.ranking.Ranking;
import com.motorjuegos.partida.PartidaBuilder;
import com.motorjuegos.recompensa.Recompensa;
import com.motorjuegos.fabrica.FabricaJuegoCompetitiva;
import com.motorjuegos.comunidad.Comunidad;


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

        // ================================
// ABSTRACT FACTORY
// ================================

        FabricaJuego fabricaCasual =
                new FabricaJuegoCasual();

        FabricaJuego fabricaCompetitiva =
                new FabricaJuegoCompetitiva();

        // Crear regla de juego
        ReglaJuego regla = new ReglaJuego(
                "Partida estándar",
                "El jugador con mayor puntuación gana."
        );


// ================================
// SIMULACIÓN DE PARTIDAS
// ================================

        motor.simularPartidas(5, regla);

        // ================================
// ABSTRACT FACTORY - PARTIDA CASUAL
// ================================
        Partida partidaCasual =
                motor.crearPartida(
                        6L,
                        "Partida Casual",
                        4,
                        fabricaCasual
                );

        partidaCasual.agregarJugador(jugador1);
        partidaCasual.agregarJugador(jugador2);
        partidaCasual.agregarJugador(jugador3);

        motor.ejecutarPartida(partidaCasual, fabricaCasual);

        // ================================
// BUILDER - PARTIDA CONFIGURADA
// ================================

        Partida partidaBuilder =
                motor.crearPartidaConBuilder(
                        8L,
                        "Partida Builder",
                        4,
                        regla
                );

        partidaBuilder.agregarJugador(jugador1);
        partidaBuilder.agregarJugador(jugador2);
        partidaBuilder.agregarJugador(jugador3);

        motor.ejecutarPartida(partidaBuilder);


        // ================================
// ABSTRACT FACTORY - PARTIDA COMPETITIVA
// ================================
        Partida partidaCompetitiva =
                motor.crearPartida(
                        7L,
                        "Partida Competitiva",
                        4,
                        fabricaCompetitiva
                );

        partidaCompetitiva.agregarJugador(jugador1);
        partidaCompetitiva.agregarJugador(jugador2);
        partidaCompetitiva.agregarJugador(jugador3);

        motor.ejecutarPartida(partidaCompetitiva, fabricaCompetitiva);


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

        // ================================
// ABSTRACT FACTORY - PRUEBA
// ================================

        System.out.println("\n===== PRUEBA ABSTRACT FACTORY =====");


        ReglaJuego reglaCasual =
                fabricaCasual.crearRegla();

        Recompensa recompensaCasual =
                fabricaCasual.crearRecompensa(30);

        System.out.println(
                "Regla creada: "
                        + reglaCasual.getNombre()
        );

        System.out.println(
                "Descripción: "
                        + reglaCasual.getDescripcion()
        );

        recompensaCasual.entregar();

        System.out.println("\n===== PRUEBA FABRICA COMPETITIVA =====");


        ReglaJuego reglaCompetitiva =
                fabricaCompetitiva.crearRegla();

        Recompensa recompensaCompetitiva =
                fabricaCompetitiva.crearRecompensa(50);

        System.out.println(
                "Regla creada: "
                        + reglaCompetitiva.getNombre()
        );

        System.out.println(
                "Descripción: "
                        + reglaCompetitiva.getDescripcion()
        );

        recompensaCompetitiva.entregar();


        // ================================
// PROTOTYPE - COMUNIDAD
// ================================

        Comunidad comunidadOriginal =
                new Comunidad(
                        1L,
                        "Gaming Colombia",
                        "Comunidad para jugadores.",
                        100
                );

        comunidadOriginal.agregarJugador(jugador1);
        comunidadOriginal.agregarJugador(jugador2);

        Comunidad comunidadClonada =
                motor.crearComunidadConPrototype(
                        comunidadOriginal
                );

        comunidadClonada.agregarJugador(jugador3);

        System.out.println(
                "\n===== PRUEBA PROTOTYPE ====="
        );

        System.out.println(
                "Comunidad original: "
                        + comunidadOriginal.getNombre()
        );

        System.out.println(
                "Jugadores original: "
                        + comunidadOriginal.getJugadores().size()
        );

        System.out.println(
                "Comunidad clonada: "
                        + comunidadClonada.getNombre()
        );

        System.out.println(
                "Jugadores clonada: "
                        + comunidadClonada.getJugadores().size()
        );

        System.out.println(
                "¿Son la misma comunidad? "
                        + (comunidadOriginal == comunidadClonada)
        );

    }





}


