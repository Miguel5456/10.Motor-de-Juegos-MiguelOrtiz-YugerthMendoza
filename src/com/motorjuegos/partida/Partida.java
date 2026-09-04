package com.motorjuegos.partida;

import com.motorjuegos.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    private Long id;
    private String nombre;

    private EstadoPartida estado;

    private int capacidadMaxima;

    private List<Jugador> jugadores;

    private ReglaJuego reglaJuego;

    private Resultado resultado;

    public Partida(
            Long id,
            String nombre,
            int capacidadMaxima,
            ReglaJuego reglaJuego) {

        this.id = id;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.reglaJuego = reglaJuego;

        this.estado = EstadoPartida.ESPERANDO;

        this.jugadores = new ArrayList<>();
    }

    // =========================
    // GESTIÓN DE JUGADORES
    // =========================

    public void agregarJugador(Jugador jugador) {

        if (estado != EstadoPartida.ESPERANDO) {

            System.out.println(
                    "No se pueden agregar jugadores. "
                            + "La partida ya comenzó."
            );

            return;
        }

        if (jugadores.size() >= capacidadMaxima) {

            System.out.println(
                    "La partida está llena."
            );

            return;
        }

        jugadores.add(jugador);

        System.out.println(
                jugador.getNombreUsuario()
                        + " se unió a la partida."
        );
    }

    public void eliminarJugador(Jugador jugador) {

        if (jugadores.remove(jugador)) {

            System.out.println(
                    jugador.getNombreUsuario()
                            + " salió de la partida."
            );

        } else {

            System.out.println(
                    "El jugador no pertenece a la partida."
            );
        }
    }

    // =========================
    // CONTROL DE PARTIDA
    // =========================

    public void iniciar() {

        if (jugadores.size() < 2) {

            System.out.println(
                    "Se necesitan al menos 2 jugadores."
            );

            return;
        }

        estado = EstadoPartida.INICIADA;

        System.out.println(
                "\nLa partida '"
                        + nombre
                        + "' ha comenzado."
        );
    }

    public Jugador simularGanador() {

        if (estado != EstadoPartida.INICIADA) {
            System.out.println("La partida no está activa.");
            return null;
        }

        if (jugadores.size() < 2) {
            System.out.println("No hay suficientes jugadores.");
            return null;
        }

        int indiceGanador =
                (int) (Math.random() * jugadores.size());

        return jugadores.get(indiceGanador);
    }

    public void pausar() {

        if (estado == EstadoPartida.INICIADA) {

            estado = EstadoPartida.PAUSADA;

            System.out.println(
                    "La partida ha sido pausada."
            );
        }
    }

    public void reanudar() {

        if (estado == EstadoPartida.PAUSADA) {

            estado = EstadoPartida.INICIADA;

            System.out.println(
                    "La partida ha sido reanudada."
            );
        }
    }

    // =========================
    // FINALIZAR PARTIDA
    // =========================

    public void finalizar(Jugador ganador) {

        if (estado != EstadoPartida.INICIADA) {

            System.out.println(
                    "La partida no está activa."
            );

            return;
        }

        if (!jugadores.contains(ganador)) {

            System.out.println(
                    "El ganador debe pertenecer a la partida."
            );

            return;
        }

        estado = EstadoPartida.FINALIZADA;

        resultado = new Resultado(
                ganador,
                100
        );

        // Actualizar estadísticas
        ganador.getEstadisticas()
                .registrarVictoria();

        for (Jugador jugador : jugadores) {

            if (jugador != ganador) {

                jugador.getEstadisticas()
                        .registrarDerrota();
            }
        }

        System.out.println(
                "\nLa partida ha finalizado."
        );

        System.out.println(
                "Ganador: "
                        + ganador.getNombreUsuario()
        );
    }

    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoPartida getEstado() {
        return estado;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public ReglaJuego getReglaJuego() {
        return reglaJuego;
    }

    public Resultado getResultado() {
        return resultado;
    }
}