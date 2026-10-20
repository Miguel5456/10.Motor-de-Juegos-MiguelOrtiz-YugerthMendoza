
package com.motorjuegos.flyweight;

import java.util.HashMap;
import java.util.Map;

public class PersonajeFactory {

    private final Map<String, TipoPersonaje> tipos =
            new HashMap<>();

    public TipoPersonaje obtenerTipo(
            String nombre,
            String modelo,
            String habilidadBase) {

        String clave = nombre + "|" + modelo + "|" + habilidadBase;

        if (!tipos.containsKey(clave)) {
            tipos.put(
                    clave,
                    new TipoPersonaje(nombre, modelo, habilidadBase)
            );

            System.out.println(
                    "Nuevo tipo de personaje creado: " + nombre
            );
        }

        return tipos.get(clave);
    }

    public int cantidadTiposCompartidos() {
        return tipos.size();
    }
}
