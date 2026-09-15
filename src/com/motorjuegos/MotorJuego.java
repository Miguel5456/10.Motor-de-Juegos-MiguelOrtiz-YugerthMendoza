package com.motorjuegos;

import com.motorjuegos.jugador.Jugador;
import com.motorjuegos.partida.Partida;
import com.motorjuegos.partida.ReglaJuego;
import com.motorjuegos.ranking.Ranking;
import com.motorjuegos.fabrica.FabricaJuego;
import com.motorjuegos.recompensa.CreadorRecompensa;
import com.motorjuegos.recompensa.CreadorRecompensaMonedas;
import com.motorjuegos.recompensa.Recompensa;
import com.motorjuegos.recompensa.CreadorRecompensaExperiencia;
import com.motorjuegos.fabrica.FabricaJuego;
import com.motorjuegos.comunidad.Comunidad;
import com.motorjuegos.partida.PartidaBuilder;


import java.util.ArrayList;
import java.util.List;

public class MotorJuego {

    private List<Jugador> jugadores;
    private List<Partida> partidas;
    private Ranking ranking;


    public MotorJuego() {
        this.jugadores = new ArrayList<>();
        this.partidas = new ArrayList<>();
        this.ranking = Ranking.getInstancia();
    }

    public void registrarJugador(Jugador jugador) {
        jugadores.add(jugador);

        System.out.println(
                "Jugador registrado en el motor: "
                        + jugador.getNombreUsuario()
        );
    }

    public Partida crearPartida(
            Long id,
            String nombre,
            int capacidadMaxima,
            ReglaJuego reglaJuego) {

        Partida partida = new Partida(
                id,
                nombre,
                capacidadMaxima,
                reglaJuego
        );

        partidas.add(partida);

        System.out.println(
                "Partida creada: " + nombre
        );

        return partida;
    }

    public Partida crearPartida(
            Long id,
            String nombre,
            int capacidadMaxima,
            FabricaJuego fabrica) {

        ReglaJuego regla = fabrica.crearRegla();

        Partida partida = new Partida(
                id,
                nombre,
                capacidadMaxima,
                regla
        );

        partidas.add(partida);

        System.out.println(
                "Partida creada: " + nombre
        );

        return partida;
    }

    public Partida crearPartidaConBuilder(
            Long id,
            String nombre,
            int capacidadMaxima,
            ReglaJuego reglaJuego) {

        Partida partida =
                new PartidaBuilder()
                        .setId(id)
                        .setNombre(nombre)
                        .setCapacidadMaxima(capacidadMaxima)
                        .setReglaJuego(reglaJuego)
                        .build();

        partidas.add(partida);

        System.out.println(
                "Partida creada con Builder: "
                        + nombre
        );

        return partida;
    }

    // ================================
// PROTOTYPE - CREAR COMUNIDAD
// ================================

    public Comunidad crearComunidadConPrototype(
            Comunidad prototipo) {

        Comunidad nuevaComunidad =
                (Comunidad) prototipo.clonar();

        System.out.println(
                "Comunidad creada mediante Prototype: "
                        + nuevaComunidad.getNombre()
        );

        return nuevaComunidad;
    }

    public void ejecutarPartida(Partida partida) {

        partida.iniciar();

        Jugador ganador = partida.simularGanador();


        if (ganador != null) {
            partida.finalizar(ganador);

            entregarRecompensaGanador(ganador);

            actualizarRanking();
        }
    }

    public void ejecutarPartida(
            Partida partida,
            FabricaJuego fabrica) {

        partida.iniciar();

        Jugador ganador = partida.simularGanador();

        if (ganador != null) {
            partida.finalizar(ganador);

            entregarRecompensaGanador(ganador, fabrica);

            actualizarRanking();
        }
    }

    public void simularPartidas(int cantidad, ReglaJuego reglaJuego) {

        for (int i = 1; i <= cantidad; i++) {

            Partida partida = crearPartida(
                    (long) i,
                    "Partida #" + i,
                    4,
                    reglaJuego
            );

            for (Jugador jugador : jugadores) {
                partida.agregarJugador(jugador);
            }

            ejecutarPartida(partida);
        }
    }

    public void entregarRecompensaGanador(Jugador ganador) {

        CreadorRecompensa creadorMonedas =
                new CreadorRecompensaMonedas();

        Recompensa monedas =
                creadorMonedas.crearRecompensa(50);

        ganador.recibirRecompensa(monedas);
        monedas.entregar();

        CreadorRecompensa creadorExperiencia =
                new CreadorRecompensaExperiencia();

        Recompensa experiencia =
                creadorExperiencia.crearRecompensa(20);

        ganador.recibirRecompensa(experiencia);
        experiencia.entregar();
    }

    public void entregarRecompensaGanador(
            Jugador ganador,
            FabricaJuego fabrica) {

        Recompensa recompensa =
                fabrica.crearRecompensa(50);

        ganador.recibirRecompensa(recompensa);

        recompensa.entregar();
    }

    public void actualizarRanking() {
        ranking.actualizar(jugadores);
    }

    public void mostrarRanking() {
        ranking.mostrar();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public Ranking getRanking() {
        return ranking;
    }
}