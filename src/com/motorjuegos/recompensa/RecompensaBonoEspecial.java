package com.motorjuegos.recompensa;

public class RecompensaBonoEspecial
        extends RecompensaDecorator {

    private String beneficio;

    public RecompensaBonoEspecial(
            Recompensa recompensa,
            String beneficio) {

        super(recompensa);
        this.beneficio = beneficio;
    }

    @Override
    public void entregar() {

        recompensa.entregar();

        System.out.println(
                "Beneficio especial: "
                        + beneficio
        );
    }
}