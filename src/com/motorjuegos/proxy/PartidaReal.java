
package com.motorjuegos.proxy;

public class PartidaReal implements AccesoPartida {

    private final String nombrePartida;

    public PartidaReal(String nombrePartida) {
        this.nombrePartida = nombrePartida;
    }

    @Override
    public void consultarPartida(String nombreJugador) {
        System.out.println(
                nombreJugador
                        + " está consultando la partida: "
                        + nombrePartida
        );
        System.out.println("Información de la partida cargada.");
    }
}
