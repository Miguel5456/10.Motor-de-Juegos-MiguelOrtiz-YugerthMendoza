package test;


import com.motorjuegos.recompensa.Recompensa;
import com.motorjuegos.recompensa.RecompensaBonoEspecial;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {

    @Test
    void debeEntregarRecompensaConBeneficioEspecial() {
        Recompensa recompensa = new Recompensa(
                "Monedas",
                "Monedas para el jugador",
                50
        );

        RecompensaBonoEspecial decorador =
                new RecompensaBonoEspecial(
                        recompensa,
                        "Experiencia doble"
                );

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        PrintStream salidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(
                    salida, true, StandardCharsets.UTF_8
            ));

            decorador.entregar();

        } finally {
            System.setOut(salidaOriginal);
        }

        String resultado = salida.toString(StandardCharsets.UTF_8);

        assertTrue(resultado.contains("Monedas"));
        assertTrue(resultado.contains("50"));
        assertTrue(resultado.contains("Beneficio especial"));
        assertTrue(resultado.contains("Experiencia doble"));
    }

    @Test
    void debeConservarLosDatosDeLaRecompensaOriginal() {
        Recompensa recompensa = new Recompensa(
                "Monedas",
                "Monedas para el jugador",
                50
        );

        RecompensaBonoEspecial decorador =
                new RecompensaBonoEspecial(
                        recompensa,
                        "Experiencia doble"
                );

        assertEquals("Monedas", decorador.getNombre());
        assertEquals(
                "Monedas para el jugador",
                decorador.getDescripcion()
        );
        assertEquals(50, decorador.getCantidad());
    }
}
