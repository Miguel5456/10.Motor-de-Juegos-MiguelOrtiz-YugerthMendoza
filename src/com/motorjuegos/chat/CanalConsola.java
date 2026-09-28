package com.motorjuegos.chat;

public class CanalConsola implements CanalEnvio {

    @Override
    public void enviar(String mensaje) {

        System.out.println(
                "[CONSOLA] " + mensaje
        );
    }
}