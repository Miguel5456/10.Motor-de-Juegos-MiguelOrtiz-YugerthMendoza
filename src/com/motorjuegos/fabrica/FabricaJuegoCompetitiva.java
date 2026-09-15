package com.motorjuegos.fabrica;

import com.motorjuegos.partida.ReglaCompetitiva;
import com.motorjuegos.partida.ReglaJuego;
import com.motorjuegos.recompensa.Recompensa;
import com.motorjuegos.recompensa.RecompensaCompetitiva;

public class FabricaJuegoCompetitiva implements FabricaJuego {

    @Override
    public ReglaJuego crearRegla() {
        return new ReglaCompetitiva();
    }

    @Override
    public Recompensa crearRecompensa(int cantidad) {
        return new RecompensaCompetitiva(cantidad);
    }
}