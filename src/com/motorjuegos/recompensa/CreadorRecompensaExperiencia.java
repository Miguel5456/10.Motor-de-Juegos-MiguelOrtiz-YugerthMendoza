package com.motorjuegos.recompensa;

public class CreadorRecompensaExperiencia extends CreadorRecompensa {

    @Override
    public Recompensa crearRecompensa(int cantidad) {
        return new RecompensaExperiencia(cantidad);
    }
}
