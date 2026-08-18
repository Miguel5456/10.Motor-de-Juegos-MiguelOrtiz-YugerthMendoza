package com.motorjuegos.jugador;

public class Perfil {

    private String nombre;
    private String avatar;
    private String descripcion;

    public Perfil() {

        this.nombre = "Sin configurar";
        this.avatar = "default.png";
        this.descripcion = "";
    }

    // =========================
    // MÉTODOS
    // =========================

    public void actualizar(
            String nombre,
            String avatar,
            String descripcion) {

        this.nombre = nombre;
        this.avatar = avatar;
        this.descripcion = descripcion;
    }

    public void mostrar() {

        System.out.println("\n=== PERFIL ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Avatar: " + avatar);
        System.out.println("Descripción: " + descripcion);
    }

    // =========================
    // GETTERS
    // =========================

    public String getNombre() {
        return nombre;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // =========================
    // SETTERS
    // =========================

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}