package com.motorjuegos.jugador;

public class Estadisticas {

    private int partidasJugadas;
    private int victorias;
    private int derrotas;
    private int puntos;

    public Estadisticas() {

        this.partidasJugadas = 0;
        this.victorias = 0;
        this.derrotas = 0;
        this.puntos = 0;
    }

    // =========================
    // REGISTRAR RESULTADOS
    // =========================

    public void registrarVictoria() {

        partidasJugadas++;
        victorias++;

        // Una victoria otorga 100 puntos
        puntos += 100;
    }

    public void registrarDerrota() {

        partidasJugadas++;
        derrotas++;

        // Una derrota otorga 20 puntos
        puntos += 20;
    }

    // =========================
    // CALCULAR RATIO
    // =========================

    public double calcularRatioVictoria() {

        if (partidasJugadas == 0) {
            return 0;
        }

        return ((double) victorias / partidasJugadas) * 100;
    }

    // =========================
    // MOSTRAR ESTADÍSTICAS
    // =========================

    public void mostrar() {

        System.out.println("\n=== ESTADÍSTICAS ===");

        System.out.println(
                "Partidas jugadas: " + partidasJugadas
        );

        System.out.println(
                "Victorias: " + victorias
        );

        System.out.println(
                "Derrotas: " + derrotas
        );

        System.out.println(
                "Puntos: " + puntos
        );

        System.out.println(
                "Ratio de victoria: "
                        + calcularRatioVictoria()
                        + "%"
        );
    }

    // =========================
    // GETTERS
    // =========================

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getPuntos() {
        return puntos;
    }
}