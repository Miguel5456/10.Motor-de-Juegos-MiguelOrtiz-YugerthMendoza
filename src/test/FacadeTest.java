package test;


import com.motorjuegos.MotorJuego;
import com.motorjuegos.facade.MotorJuegoFacade;
import com.motorjuegos.jugador.Jugador;
import com.motorjuegos.partida.ReglaCasual;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class FacadeTest {

    @Test
    void debeRegistrarJugadorMedianteLaFachada() {
        MotorJuego motor = new MotorJuego();
        MotorJuegoFacade facade = new MotorJuegoFacade(motor);

        Jugador jugador = new Jugador(
                1L,
                "PlayerFacade",
                "player@test.com"
        );

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(
                    salida, true, StandardCharsets.UTF_8
            ));

            facade.registrarJugador(jugador);

        } finally {
            System.setOut(salidaOriginal);
        }

        assertEquals(1, motor.getJugadores().size());
        assertSame(jugador, motor.getJugadores().get(0));
        assertTrue(salida.toString(StandardCharsets.UTF_8)
                .contains("PlayerFacade"));
    }

    @Test
    void debeCrearYEjecutarPartidaMedianteLaFachada() {
        MotorJuego motor = new MotorJuego();
        MotorJuegoFacade facade = new MotorJuegoFacade(motor);

        Jugador jugador1 = new Jugador(
                1L, "PlayerUno", "uno@test.com"
        );

        Jugador jugador2 = new Jugador(
                2L, "PlayerDos", "dos@test.com"
        );

        facade.registrarJugador(jugador1);
        facade.registrarJugador(jugador2);

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(
                    salida, true, StandardCharsets.UTF_8
            ));

            facade.iniciarPartida(
                    100L,
                    "PartidaFacade",
                    4,
                    new ReglaCasual()
            );

        } finally {
            System.setOut(salidaOriginal);
        }

        assertEquals(1, motor.getPartidas().size());
        assertEquals("PartidaFacade",
                motor.getPartidas().get(0).getNombre());

        String resultado = salida.toString(StandardCharsets.UTF_8);
        assertTrue(resultado.contains("PartidaFacade"));
    }
}

