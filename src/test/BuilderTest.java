package test;

import com.motorjuegos.partida.Partida;
import com.motorjuegos.partida.PartidaBuilder;
import com.motorjuegos.partida.ReglaCasual;
import com.motorjuegos.partida.ReglaJuego;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class BuilderTest {

    @Test
    void debeConstruirPartidaConDatosConfigurados() {
        ReglaJuego regla = new ReglaCasual();

        Partida partida = new PartidaBuilder()
                .setId(1L)
                .setNombre("Partida de prueba")
                .setCapacidadMaxima(4)
                .setReglaJuego(regla)
                .build();

        assertNotNull(partida,
                "La partida construida no debe ser nula");

        assertEquals(1L, partida.getId(),
                "El ID debe ser 1");

        assertEquals("Partida de prueba", partida.getNombre(),
                "El nombre debe coincidir");

        assertSame(regla, partida.getReglaJuego(),
                "La partida debe conservar la regla configurada");
    }
}
