package com.motorjuegos.chat;

public abstract class Mensaje {

    protected CanalEnvio canal;

    public Mensaje(CanalEnvio canal) {
        this.canal = canal;
    }

    public abstract void enviar(String contenido);
}