package com.motorjuegos.economia;

public class PasarelaPagoExterna {

    public void procesarTransaccion(
            String usuario,
            double valor) {

        System.out.println(
                "Transacción procesada por pasarela externa: "
                        + usuario
                        + " - $"
                        + valor
        );
    }
}