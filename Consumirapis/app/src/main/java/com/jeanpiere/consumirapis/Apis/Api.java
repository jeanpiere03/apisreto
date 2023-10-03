package com.jeanpiere.consumirapis.Apis;

import com.jeanpiere.consumirapis.Models.Cursos;
import com.jeanpiere.consumirapis.Models.Estudiantes;
import com.jeanpiere.consumirapis.Models.ResponseData;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("dg7lduzuo/raw/upload/v1696366827/dg5n51dvtzfh78dlmoxy.json")
    Call<ResponseData> getEstudents();

    @GET("dg7lduzuo/raw/upload/v1696366827/dg5n51dvtzfh78dlmoxy.json")
    Call<List<Cursos>> getCursos();
}
