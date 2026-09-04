package com.motorjuegos.jugador;

import com.motorjuegos.recompensa.Recompensa;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private Long id;
    private String nombreUsuario;
    private String correo;

    private Perfil perfil;
    private Estadisticas estadisticas;

    private List<Recompensa> recompensas;

    public Jugador(Long id, String nombreUsuario, String correo) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.estadisticas = new Estadisticas();
        this.perfil = new Perfil();
        this.recompensas = new ArrayList<>();
    }
    // =========================
    // MÉTODOS
    // =========================

    public void conectar() {
        System.out.println(nombreUsuario + " se ha conectado.");
    }

    public void desconectar() {
        System.out.println(nombreUsuario + " se ha desconectado.");
    }

    public void mostrarInformacion() {

        System.out.println("\n=== INFORMACIÓN DEL JUGADOR ===");
        System.out.println("ID: " + id);
        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Correo: " + correo);

        perfil.mostrar();
        estadisticas.mostrar();
    }

    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    // =========================
    // SETTERS
    // =========================

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void recibirRecompensa(Recompensa recompensa) {
        recompensas.add(recompensa);

        System.out.println(
                nombreUsuario
                        + " recibió la recompensa: "
                        + recompensa.getNombre()
        );
    }

    public List<Recompensa> getRecompensas() {
        return recompensas;
    }

}