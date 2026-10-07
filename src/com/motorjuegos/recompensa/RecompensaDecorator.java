package com.motorjuegos.recompensa;

public abstract class RecompensaDecorator {

    protected Recompensa recompensa;

    public RecompensaDecorator(
            Recompensa recompensa) {

        this.recompensa = recompensa;
    }

    public abstract void entregar();

    public String getNombre() {
        return recompensa.getNombre();
    }

    public String getDescripcion() {
        return recompensa.getDescripcion();
    }

    public int getCantidad() {
        return recompensa.getCantidad();
    }
}
