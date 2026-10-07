package com.motorjuegos.comunidad;

public class JugadorComunidad implements ComponenteComunidad {

    private String nombre;
    public JugadorComunidad(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void mostrar() {
        System.out.println(
                "Jugador: " + nombre
        );
    }
    @Override
    public void agregar(ComponenteComunidad componente) {
        System.out.println(
                "Un jugador no puede contener otros componentes."
        );
    }
    @Override
    public void eliminar(ComponenteComunidad componente) {
        System.out.println(
                "Un jugador no contiene otros componentes."
        );
    }
}