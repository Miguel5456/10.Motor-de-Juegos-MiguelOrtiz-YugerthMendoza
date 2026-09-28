package com.motorjuegos.chat;

public class MensajeChat extends Mensaje {

    public MensajeChat(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void enviar(String contenido) {

        canal.enviar(
                "Mensaje de jugador: "
                        + contenido
        );
    }
}