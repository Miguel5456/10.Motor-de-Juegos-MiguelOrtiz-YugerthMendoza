package com.motorjuegos.recompensa;

public class CreadorRecompensaMonedas extends CreadorRecompensa {

    @Override
    public Recompensa crearRecompensa(int cantidad) {
        return new RecompensaMonedas(cantidad);
    }
}