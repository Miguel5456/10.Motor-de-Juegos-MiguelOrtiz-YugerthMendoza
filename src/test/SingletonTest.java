package test;

import com.motorjuegos.ranking.Ranking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {

    @Test
    void debeDevolverLaMismaInstancia() {
        Ranking primero = Ranking.getInstancia();
        Ranking segundo = Ranking.getInstancia();

        assertSame(
                primero,
                segundo,
                "Las dos referencias deben apuntar a la misma instancia"
        );
    }
}