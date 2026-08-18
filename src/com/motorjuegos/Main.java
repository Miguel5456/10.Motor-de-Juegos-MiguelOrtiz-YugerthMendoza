package com.motorjuegos;

import com.motorjuegos.jugador.Jugador;

public class Main {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println(" MOTOR DE JUEGOS MULTIJUGADOR");
        System.out.println("================================");

        // Crear jugador
        Jugador jugador =
                new Jugador(
                        1L,
                        "PlayerOne",
                        "playerone@gmail.com"
                );

        // Conectar jugador
        jugador.conectar();

        // Actualizar perfil
        jugador.getPerfil().actualizar(
                "Player One",
                "guerrero.png",
                "Jugador competitivo"
        );

        // Registrar resultados
        jugador.getEstadisticas().registrarVictoria();
        jugador.getEstadisticas().registrarVictoria();
        jugador.getEstadisticas().registrarDerrota();

        // Mostrar información
        jugador.mostrarInformacion();

        // Desconectar
        jugador.desconectar();
    }
}