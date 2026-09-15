package com.motorjuegos.partida;

public class ReglaCompetitiva extends ReglaJuego {

    public ReglaCompetitiva() {
        super(
                "Reglas Competitivas",
                "Partida competitiva que afecta el ranking de los jugadores."
        );
    }

    @Override
    public boolean validarReglas() {
        return true;
    }
}