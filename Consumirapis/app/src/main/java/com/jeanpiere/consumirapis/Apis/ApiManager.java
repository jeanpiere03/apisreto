package com.jeanpiere.consumirapis.Apis;

import com.jeanpiere.consumirapis.Models.Cursos;
import com.jeanpiere.consumirapis.Models.Estudiantes;
import com.jeanpiere.consumirapis.Models.ResponseData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class ApiManager {
    private static final String BASE_URL = "https://res.cloudinary.com/";

    private final Api api;

    public ApiManager() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    public Call<ResponseData> getEstudents() {
        return api.getEstudents();
    }

    public Call<List<Cursos>> getCursos() {
        return api.getCursos();
    }
}

