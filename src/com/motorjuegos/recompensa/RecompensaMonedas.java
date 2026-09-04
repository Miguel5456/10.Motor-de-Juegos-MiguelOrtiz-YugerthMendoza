package com.motorjuegos.recompensa;

public class RecompensaMonedas extends Recompensa {

    public RecompensaMonedas(int cantidad) {
        super(
                "Monedas",
                "Monedas obtenidas dentro del juego",
                cantidad
        );
    }

    @Override
    public void entregar() {
        System.out.println(
                "Se entregaron "
                        + getCantidad()
                        + " monedas."
        );
    }
}
