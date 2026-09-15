package com.motorjuegos.recompensa;

public class RecompensaCasual extends Recompensa {

    public RecompensaCasual(int cantidad) {
        super(
                "Recompensa Casual",
                "Recompensa obtenida en una partida casual.",
                cantidad
        );
    }

    @Override
    public void entregar() {
        System.out.println(
                "Se entregaron "
                        + getCantidad()
                        + " unidades de recompensa casual."
        );
    }
}