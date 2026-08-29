package com.motorjuegos.ranking;

import com.motorjuegos.jugador.Jugador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ranking {

    // ==========================================
    // INSTANCIA ÚNICA
    // ==========================================

    private static Ranking instancia;

    // ==========================================
    // ATRIBUTOS
    // ==========================================

    private String nombre;

    private List<EntradaRanking> entradas;

    // ==========================================
    // CONSTRUCTOR PRIVADO
    // ==========================================

    private Ranking(String nombre) {

        this.nombre = nombre;
        this.entradas = new ArrayList<>();
    }

    // ==========================================
    // MÉTODO SINGLETON
    // ==========================================

    public static Ranking getInstancia() {

        if (instancia == null) {

            instancia = new Ranking("Ranking Global");
        }

        return instancia;
    }

    // ==========================================
    // ACTUALIZAR RANKING
    // ==========================================

    public void actualizar(List<Jugador> jugadores) {

        // Crear una copia modificable de la lista
        List<Jugador> jugadoresOrdenados =
                new ArrayList<>(jugadores);

        // Ordenar de mayor a menor puntuación
        jugadoresOrdenados.sort(
                Comparator.comparingInt(
                        jugador ->
                                -jugador.getEstadisticas()
                                        .getPuntos()
                )
        );

        entradas.clear();

        int posicion = 1;

        for (Jugador jugador : jugadoresOrdenados) {

            EntradaRanking entrada =
                    new EntradaRanking(
                            jugador,
                            posicion,
                            jugador.getEstadisticas()
                                    .getPuntos()
                    );

            entradas.add(entrada);

            posicion++;
        }
    }

    // ==========================================
    // MOSTRAR RANKING
    // ==========================================

    public void mostrar() {

        System.out.println(
                "\n========== "
                        + nombre
                        + " =========="
        );

        for (EntradaRanking entrada : entradas) {

            System.out.println(
                    entrada.getPosicion()
                            + ". "
                            + entrada.getJugador()
                            .getNombreUsuario()
                            + " - "
                            + entrada.getPuntuacion()
                            + " puntos"
            );
        }

        System.out.println(
                "============================"
        );
    }

    // ==========================================
    // GETTERS
    // ==========================================

    public List<EntradaRanking> getEntradas() {
        return entradas;
    }

    public String getNombre() {
        return nombre;
    }
}
