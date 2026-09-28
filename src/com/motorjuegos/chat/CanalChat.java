package com.motorjuegos.chat;

public class CanalChat implements CanalEnvio {

    @Override
    public void enviar(String mensaje) {

        System.out.println(
                "[CHAT] " + mensaje
        );
    }
}