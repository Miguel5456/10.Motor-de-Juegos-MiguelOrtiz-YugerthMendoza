package com.motorjuegos.fabrica;

import com.motorjuegos.partida.ReglaCasual;
import com.motorjuegos.partida.ReglaJuego;
import com.motorjuegos.recompensa.Recompensa;
import com.motorjuegos.recompensa.RecompensaCasual;

public class FabricaJuegoCasual implements FabricaJuego {

    @Override
    public ReglaJuego crearRegla() {
        return new ReglaCasual();
    }

    @Override
    public Recompensa crearRecompensa(int cantidad) {
        return new RecompensaCasual(cantidad);
    }
}