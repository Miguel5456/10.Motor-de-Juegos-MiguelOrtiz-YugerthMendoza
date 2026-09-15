package com.motorjuegos.fabrica;

import com.motorjuegos.partida.ReglaJuego;
import com.motorjuegos.recompensa.Recompensa;

public interface FabricaJuego {

    ReglaJuego crearRegla();

    Recompensa crearRecompensa(int cantidad);
}
