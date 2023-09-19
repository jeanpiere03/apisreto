package com.jeanpiere.retotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.jeanpiere.retotest.api.CommentsApi;
import com.jeanpiere.retotest.Adapter.CommentsAdapter;
import com.jeanpiere.retotest.model.Comments;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsActivity extends AppCompatActivity {
    private List<Comments> commentsList;
    private RecyclerView recyclerView;
    private CommentsAdapter commentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        recyclerView = findViewById(R.id.recyclerViewComments);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        // Obtener el ID del post seleccionado desde el Intent de MainActivity
        int postId = getIntent().getIntExtra("postId", -1);
        if (postId != -1) {
            // Configura Retrofit para hacer la llamada a la API de comentarios
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/") // Reemplaza con la URL de tu API
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            CommentsApi commentsApi = retrofit.create(CommentsApi.class);


            Call<List<Comments>> call = commentsApi.getCommentsByPost(postId);
            call.enqueue(new Callback<List<Comments>>() {
                @Override
                public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        commentsList = response.body();


                        commentsAdapter = new CommentsAdapter(CommentsActivity.this, commentsList);


                        recyclerView.setAdapter(commentsAdapter);
                    }
                }
                @Override
                public void onFailure(Call<List<Comments>> call, Throwable t) {

                }
            });
        }
    }
}
