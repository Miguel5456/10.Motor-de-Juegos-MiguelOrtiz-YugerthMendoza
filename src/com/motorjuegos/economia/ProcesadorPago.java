package com.motorjuegos.economia;

public interface ProcesadorPago {

    void procesarPago(
            String jugador,
            double monto
    );
}