package com.motorjuegos.chat;

public class MensajeSistema extends Mensaje {

    public MensajeSistema(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void enviar(String contenido) {

        canal.enviar(
                "MENSAJE DEL SISTEMA: "
                        + contenido
        );
    }
}
