package test;


import com.motorjuegos.fabrica.FabricaJuego;
import com.motorjuegos.fabrica.FabricaJuegoCasual;
import com.motorjuegos.partida.ReglaCasual;
import com.motorjuegos.partida.ReglaJuego;
import com.motorjuegos.recompensa.Recompensa;
import com.motorjuegos.recompensa.RecompensaCasual;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AbstractFactoryTest {

    @Test
    void debeCrearReglaYRecompensaCasual() {
        FabricaJuego fabrica = new FabricaJuegoCasual();

        ReglaJuego regla = fabrica.crearRegla();
        Recompensa recompensa = fabrica.crearRecompensa(50);

        assertNotNull(regla, "La regla no debe ser nula");
        assertNotNull(recompensa, "La recompensa no debe ser nula");

        assertInstanceOf(
                ReglaCasual.class,
                regla,
                "La fábrica debe crear una regla casual"
        );

        assertInstanceOf(
                RecompensaCasual.class,
                recompensa,
                "La fábrica debe crear una recompensa casual"
        );
    }
}
