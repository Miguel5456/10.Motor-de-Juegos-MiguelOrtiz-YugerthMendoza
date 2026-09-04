package com.motorjuegos.recompensa;

public class RecompensaExperiencia extends Recompensa {

    public RecompensaExperiencia(int cantidad) {
        super(
                "Experiencia",
                "Experiencia obtenida dentro del juego",
                cantidad
        );
    }

    @Override
    public void entregar() {
        System.out.println(
                "Se entregaron "
                        + getCantidad()
                        + " puntos de experiencia."
        );
    }
}