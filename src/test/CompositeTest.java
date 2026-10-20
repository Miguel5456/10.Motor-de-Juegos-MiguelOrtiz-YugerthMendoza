package test;

import com.motorjuegos.comunidad.ComponenteComunidad;
import com.motorjuegos.comunidad.GrupoComunidad;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompositeTest {

    @Test
    void debeMostrarGrupoYComponentesAgregados() {
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(salida, true, StandardCharsets.UTF_8));

            GrupoComunidad grupo = new GrupoComunidad("Gaming Colombia");

            ComponenteComunidad componente = new ComponenteComunidad() {
                @Override
                public void mostrar() {
                    System.out.println("Componente de prueba");
                }

                @Override
                public void agregar(ComponenteComunidad componente) {
                    // Este componente hoja no contiene otros componentes.
                }

                @Override
                public void eliminar(ComponenteComunidad componente) {
                    // Este componente hoja no contiene otros componentes.
                }
            };

            grupo.agregar(componente);
            grupo.mostrar();

        } finally {
            System.setOut(salidaOriginal);
        }

        String resultado = salida.toString(StandardCharsets.UTF_8);

        assertTrue(resultado.contains("Comunidad: Gaming Colombia"),
                "Debe mostrarse el nombre del grupo");

        assertTrue(resultado.contains("Componente de prueba"),
                "Debe mostrarse el componente agregado");
    }
}
