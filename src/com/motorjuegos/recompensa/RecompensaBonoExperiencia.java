package com.motorjuegos.recompensa;

public class RecompensaBonoExperiencia
        extends RecompensaDecorator {

    private int experienciaExtra;

    public RecompensaBonoExperiencia(
            Recompensa recompensa,
            int experienciaExtra) {

        super(recompensa);
        this.experienciaExtra = experienciaExtra;
    }

    @Override
    public void entregar() {

        recompensa.entregar();

        System.out.println(
                "Bono adicional de experiencia: "
                        + experienciaExtra
                        + " XP"
        );
    }
}
