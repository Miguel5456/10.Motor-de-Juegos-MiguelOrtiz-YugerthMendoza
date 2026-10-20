
package com.motorjuegos.proxy;

import java.util.HashSet;
import java.util.Set;

public class ProxyPartida implements AccesoPartida {

    private final AccesoPartida partidaReal;
    private final Set<String> jugadoresAutorizados;

    public ProxyPartida(
            String nombrePartida,
            Set<String> jugadoresAutorizados) {

        this.partidaReal = new PartidaReal(nombrePartida);
        this.jugadoresAutorizados = new HashSet<>(
                jugadoresAutorizados
        );
    }
    @Override
    public void consultarPartida(String nombreJugador) {
        if (jugadoresAutorizados.contains(nombreJugador)) {
            System.out.println(
                    "Proxy: acceso autorizado para "
                            + nombreJugador
            );
            partidaReal.consultarPartida(nombreJugador);
        } else {
            System.out.println(
                    "Proxy: acceso denegado para "
                            + nombreJugador
            );
        }
    }
}
