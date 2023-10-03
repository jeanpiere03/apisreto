package com.jeanpiere.consumirapis.Models;

public class Tareas {
    private int id;
    private String titulo;
    private String descripcion;
    private String nivel;
    private String fecha_entrega;

    public Tareas(int id, String titulo, String descripcion, String nivel, String fechaEntrega) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.fecha_entrega = fechaEntrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getFechaEntrega() {
        return fecha_entrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fecha_entrega = fechaEntrega;
    }
}
