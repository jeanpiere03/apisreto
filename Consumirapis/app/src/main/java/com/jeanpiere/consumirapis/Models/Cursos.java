package com.jeanpiere.consumirapis.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cursos {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("profesor")
    @Expose
    private String profesor;
    @SerializedName("calificacion")
    @Expose
    private int calificacion;
    @SerializedName("imagen_url")
    @Expose
    private String imagen_url;

    @SerializedName("tareas")
    @Expose
    private List<Tareas> tareas;

    public List<Tareas> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tareas> tareas) {
        this.tareas = tareas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    @Override
    public String toString() {
        return "Cursos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", profesor='" + profesor + '\'' +
                ", calificacion=" + calificacion +
                ", imagen_url='" + imagen_url + '\'' +
                ", tareas=" + tareas +
                '}';
    }
}
