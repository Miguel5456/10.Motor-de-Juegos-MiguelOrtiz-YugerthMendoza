package test;


import com.motorjuegos.comunidad.Comunidad;
import com.motorjuegos.comunidad.Prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PrototypeTest {

    @Test
    void debeClonarComunidadSinCompartirElMismoObjeto() {
        Comunidad original = new Comunidad(
                1L,
                "Gaming Colombia",
                "Comunidad de jugadores",
                20
        );

        Prototype resultado = original.clonar();

        assertNotNull(resultado,
                "La copia no debe ser nula");

        assertNotSame(original, resultado,
                "La copia debe ser un objeto diferente");

        Comunidad copia = (Comunidad) resultado;

        assertEquals(original.getId(), copia.getId(),
                "La copia debe conservar el ID");

        assertEquals(original.getNombre(), copia.getNombre(),
                "La copia debe conservar el nombre");

        assertEquals(original.getDescripcion(), copia.getDescripcion(),
                "La copia debe conservar la descripción");

        assertEquals(original.getCapacidadMaxima(), copia.getCapacidadMaxima(),
                "La copia debe conservar la capacidad máxima");
    }
}

