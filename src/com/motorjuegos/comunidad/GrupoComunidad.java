package com.motorjuegos.comunidad;

import java.util.ArrayList;
import java.util.List;

public class GrupoComunidad implements ComponenteComunidad {
    private String nombre;
    private List<ComponenteComunidad> componentes;
    public GrupoComunidad(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }
    @Override
    public void mostrar() {
        System.out.println(
                "\nComunidad: " + nombre
        );

        for (ComponenteComunidad componente : componentes) {
            componente.mostrar();
        }
    }
    @Override
    public void agregar(
            ComponenteComunidad componente) {

        componentes.add(componente);
    }
    @Override
    public void eliminar(
            ComponenteComunidad componente) {
        componentes.remove(componente);
    }
}
