package com.motorjuegos.recompensa;

public class RecompensaItem extends Recompensa {

    public RecompensaItem(int cantidad) {
        super(
                "Item",
                "Objeto obtenido dentro del juego",
                cantidad
        );
    }

    @Override
    public void entregar() {
        System.out.println(
                "Se entregaron "
                        + getCantidad()
                        + " items."
        );
    }
}