package test;


import com.motorjuegos.economia.AdaptadorPago;
import com.motorjuegos.economia.PasarelaPagoExterna;
import com.motorjuegos.economia.ProcesadorPago;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdapterTest {

    @Test
    void debeAdaptarElPagoALaPasarelaExterna() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(salida, true, StandardCharsets.UTF_8));

            PasarelaPagoExterna pasarela = new PasarelaPagoExterna();
            ProcesadorPago adaptador = new AdaptadorPago(pasarela);

            adaptador.procesarPago("PlayerOne", 5000.0);

        } finally {
            System.setOut(salidaOriginal);
        }

        String resultado = salida.toString(StandardCharsets.UTF_8);

        assertTrue(resultado.contains("PlayerOne"),
                "Debe enviarse el nombre del jugador");

        assertTrue(resultado.contains("5000.0"),
                "Debe enviarse el monto del pago");

        assertTrue(resultado.contains("Transacción procesada"),
                "La pasarela externa debe procesar la transacción");
    }
}
