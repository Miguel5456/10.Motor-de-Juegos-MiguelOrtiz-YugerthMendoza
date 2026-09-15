package com.motorjuegos.comunidad;

import com.motorjuegos.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Comunidad implements Prototype {

    private Long id;
    private String nombre;
    private String descripcion;
    private int capacidadMaxima;
    private List<Jugador> jugadores;

    public Comunidad(
            Long id,
            String nombre,
            String descripcion,
            int capacidadMaxima) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidadMaxima = capacidadMaxima;

        this.jugadores = new ArrayList<>();
    }

    // =========================
    // PROTOTYPE
    // =========================

    @Override
    public Prototype clonar() {

        Comunidad copia = new Comunidad(
                this.id,
                this.nombre,
                this.descripcion,
                this.capacidadMaxima
        );

        return copia;
    }

    // =========================
    // GESTIÓN DE JUGADORES
    // =========================

    public void agregarJugador(Jugador jugador) {

        if (jugadores.size() >= capacidadMaxima) {

            System.out.println(
                    "La comunidad está llena."
            );

            return;
        }

        jugadores.add(jugador);

        System.out.println(
                jugador.getNombreUsuario()
                        + " se unió a la comunidad."
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

    public String getDescripcion() {
        return descripcion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}
