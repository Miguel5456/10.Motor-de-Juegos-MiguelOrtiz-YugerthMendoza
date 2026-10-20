
package com.motorjuegos.facade;

import com.motorjuegos.MotorJuego;
import com.motorjuegos.jugador.Jugador;
import com.motorjuegos.partida.Partida;
import com.motorjuegos.partida.ReglaJuego;
import com.motorjuegos.fabrica.FabricaJuego;
import com.motorjuegos.economia.ProcesadorPago;
import com.motorjuegos.chat.Mensaje;
import com.motorjuegos.comunidad.GrupoComunidad;

public class MotorJuegoFacade {

    private final MotorJuego motor;

    public MotorJuegoFacade(MotorJuego motor) {
        this.motor = motor;
    }

    // Registrar un jugador en el motor
    public void registrarJugador(Jugador jugador) {
        motor.registrarJugador(jugador);
    }

    // Crear y ejecutar una partida
    public void iniciarPartida(
            Long id,
            String nombre,
            int capacidadMaxima,
            ReglaJuego reglaJuego) {

        Partida partida = motor.crearPartida(
                id,
                nombre,
                capacidadMaxima,
                reglaJuego
        );

        for (Jugador jugador : motor.getJugadores()) {
            partida.agregarJugador(jugador);
        }

        motor.ejecutarPartida(partida);
    }

    // Crear y ejecutar una partida mediante Abstract Factory
    public void iniciarPartida(
            Long id,
            String nombre,
            int capacidadMaxima,
            FabricaJuego fabrica) {

        Partida partida = motor.crearPartida(
                id,
                nombre,
                capacidadMaxima,
                fabrica
        );

        for (Jugador jugador : motor.getJugadores()) {
            partida.agregarJugador(jugador);
        }

        motor.ejecutarPartida(partida, fabrica);
    }

    // Consultar el ranking
    public void mostrarRanking() {
        motor.actualizarRanking();
        motor.mostrarRanking();
    }

    // Procesar una compra de monedas
    public void comprarMonedas(
            Jugador jugador,
            int monedas,
            double monto,
            ProcesadorPago procesadorPago) {

        motor.realizarCompra(
                jugador,
                monedas,
                monto,
                procesadorPago
        );
    }

    // Enviar una notificación
    public void notificar(
            Mensaje mensaje,
            String contenido) {

        motor.enviarMensaje(mensaje, contenido);
    }

    // Mostrar una comunidad
    public void mostrarComunidad(
            GrupoComunidad comunidad) {

        motor.mostrarComunidad(comunidad);
    }
}
