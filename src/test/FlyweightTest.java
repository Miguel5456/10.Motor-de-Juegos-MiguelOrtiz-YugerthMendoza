package test;


import com.motorjuegos.flyweight.PersonajeFactory;
import com.motorjuegos.flyweight.TipoPersonaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlyweightTest {

    @Test
    void debeCompartirElMismoTipoDePersonaje() {
        PersonajeFactory fabrica = new PersonajeFactory();

        TipoPersonaje personaje1 = fabrica.obtenerTipo(
                "Guerrero",
                "Modelo3D_Guerrero",
                "Espada"
        );

        TipoPersonaje personaje2 = fabrica.obtenerTipo(
                "Guerrero",
                "Modelo3D_Guerrero",
                "Espada"
        );

        assertSame(personaje1, personaje2);
        assertEquals(1, fabrica.cantidadTiposCompartidos());
    }

    @Test
    void debeCrearUnTipoNuevoCuandoLosDatosSonDiferentes() {
        PersonajeFactory fabrica = new PersonajeFactory();

        TipoPersonaje guerrero = fabrica.obtenerTipo(
                "Guerrero",
                "Modelo3D_Guerrero",
                "Espada"
        );

        TipoPersonaje mago = fabrica.obtenerTipo(
                "Mago",
                "Modelo3D_Mago",
                "Magia"
        );

        assertNotSame(guerrero, mago);
        assertEquals(2, fabrica.cantidadTiposCompartidos());
    }

    @Test
    void debeConservarLosDatosDelTipoCompartido() {
        PersonajeFactory fabrica = new PersonajeFactory();

        TipoPersonaje tipo = fabrica.obtenerTipo(
                "Arquero",
                "Modelo3D_Arquero",
                "Arco"
        );

        assertEquals("Arquero", tipo.getNombre());
        assertEquals("Modelo3D_Arquero", tipo.getModelo());
        assertEquals("Arco", tipo.getHabilidadBase());
    }
}
