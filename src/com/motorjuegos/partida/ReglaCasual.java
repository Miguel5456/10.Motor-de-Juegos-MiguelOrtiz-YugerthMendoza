package com.motorjuegos.partida;

public class ReglaCasual extends ReglaJuego {

    public ReglaCasual() {
        super(
                "Reglas Casual",
                "Partida casual sin impacto en el ranking competitivo."
        );
    }

    @Override
    public boolean validarReglas() {
        return true;
    }
}