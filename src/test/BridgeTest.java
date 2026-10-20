package test;


import com.motorjuegos.chat.CanalChat;
import com.motorjuegos.chat.Mensaje;
import com.motorjuegos.chat.MensajeChat;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeTest {

    @Test
    void debeEnviarMensajePorElCanalDeChat() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(salida, true, StandardCharsets.UTF_8));

            Mensaje mensaje = new MensajeChat(new CanalChat());
            mensaje.enviar("Hola, jugadores");

        } finally {
            System.setOut(salidaOriginal);
        }

        String resultado = salida.toString(StandardCharsets.UTF_8);

        assertTrue(resultado.contains("[CHAT]"),
                "Debe utilizar el canal de chat");

        assertTrue(resultado.contains("Mensaje de jugador: Hola, jugadores"),
                "Debe transmitir el contenido del mensaje");
    }
}
