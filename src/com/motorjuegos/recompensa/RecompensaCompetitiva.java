package com.motorjuegos.recompensa;

public class RecompensaCompetitiva extends Recompensa {

    public RecompensaCompetitiva(int cantidad) {
        super(
                "Recompensa Competitiva",
                "Recompensa obtenida en una partida competitiva.",
                cantidad
        );
    }

    @Override
    public void entregar() {
        System.out.println(
                "Se entregaron "
                        + getCantidad()
                        + " unidades de recompensa competitiva."
        );
    }
}