package test;


import com.motorjuegos.proxy.AccesoPartida;
import com.motorjuegos.proxy.ProxyPartida;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyTest {

    @Test
    void debePermitirAccesoAJugadorAutorizado() {
        AccesoPartida proxy = new ProxyPartida(
                "Partida competitiva",
                Set.of("PlayerOne", "PlayerTwo")
        );

        String resultado = capturarSalida(
                () -> proxy.consultarPartida("PlayerOne")
        );

        assertTrue(resultado.contains("acceso autorizado"));
        assertTrue(resultado.contains("PlayerOne"));
        assertTrue(resultado.contains("Información de la partida cargada."));
    }

    @Test
    void debeDenegarAccesoAJugadorNoAutorizado() {
        AccesoPartida proxy = new ProxyPartida(
                "Partida competitiva",
                Set.of("PlayerOne", "PlayerTwo")
        );

        String resultado = capturarSalida(
                () -> proxy.consultarPartida("PlayerThree")
        );

        assertTrue(resultado.contains("acceso denegado"));
        assertTrue(resultado.contains("PlayerThree"));
        assertFalse(resultado.contains("Información de la partida cargada."));
    }

    private String capturarSalida(Runnable accion) {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(
                    salida, true, StandardCharsets.UTF_8
            ));

            accion.run();

        } finally {
            System.setOut(salidaOriginal);
        }

        return salida.toString(StandardCharsets.UTF_8);
    }
}

