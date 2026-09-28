package com.motorjuegos.economia;

public class AdaptadorPago implements ProcesadorPago {

    private PasarelaPagoExterna pasarela;

    public AdaptadorPago(PasarelaPagoExterna pasarela) {
        this.pasarela = pasarela;
    }

    @Override
    public void procesarPago(
            String jugador,
            double monto) {

        pasarela.procesarTransaccion(
                jugador,
                monto
        );
    }
}