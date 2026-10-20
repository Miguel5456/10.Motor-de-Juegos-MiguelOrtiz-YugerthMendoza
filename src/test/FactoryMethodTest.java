package test;

import com.motorjuegos.recompensa.CreadorRecompensaMonedas;
import com.motorjuegos.recompensa.Recompensa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class FactoryMethodTest {

    @Test
    void debeCrearUnaRecompensaDeMonedas() {
        CreadorRecompensaMonedas creador =
                new CreadorRecompensaMonedas();

        Recompensa recompensa = creador.crearRecompensa(50);

        assertNotNull(recompensa,
                "La recompensa creada no debe ser nula");

        assertInstanceOf(Recompensa.class, recompensa,
                "Debe crearse una instancia de Recompensa");
    }
}
