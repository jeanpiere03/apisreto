package com.jeanpiere.consumirapis.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData {
    @SerializedName("estudiantes")
    @Expose
    private List<Estudiantes> estudiantes;



    public List<Estudiantes> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiantes> estudiantes) {
        this.estudiantes = estudiantes;
    }


    @Override
    public String toString() {
        return "ResponseData{" +
                "estudiantes=" + estudiantes +
                '}';
    }
}
