package com.jeanpiere.retotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.cardview.widget.CardView;
import android.view.View;
import com.jeanpiere.retotest.Adapter.PostAdapter;
import com.jeanpiere.retotest.R;
import com.jeanpiere.retotest.api.PostApi;
import com.jeanpiere.retotest.model.Post;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<Post> posts;
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi = retrofit.create(PostApi.class);




        Call<List<Post>> call = postApi.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Log.e("API Error", "Código: " + response.code());
                    return;
                }

                posts = response.body();
                postAdapter = new PostAdapter(MainActivity.this, posts);
                recyclerView.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("API Error", t.getMessage());
            }
        });



    }
}
