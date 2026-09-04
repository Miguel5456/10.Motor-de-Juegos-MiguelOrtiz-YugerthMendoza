package com.motorjuegos.recompensa;

public class CreadorRecompensaItem extends CreadorRecompensa {

    @Override
    public Recompensa crearRecompensa(int cantidad) {
        return new RecompensaItem(cantidad);
    }
}