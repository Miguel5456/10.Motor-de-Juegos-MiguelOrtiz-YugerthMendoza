package com.motorjuegos.partida;

public class PartidaBuilder {

    private Long id;
    private String nombre;
    private int capacidadMaxima;
    private ReglaJuego reglaJuego;

    public PartidaBuilder setId(Long id) {
        this.id = id;
        return this;
    }
    public PartidaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public PartidaBuilder setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        return this;
    }
    public PartidaBuilder setReglaJuego(ReglaJuego reglaJuego) {
        this.reglaJuego = reglaJuego;
        return this;
    }

    public Partida build() {
        return new Partida(
                id,
                nombre,
                capacidadMaxima,
                reglaJuego
        );
    }
}