package com.jeanpiere.consumirapis;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jeanpiere.consumirapis.Apis.ApiManager;
import com.jeanpiere.consumirapis.Adapters.AdapterStudents;
import com.jeanpiere.consumirapis.Models.Estudiantes;
import com.jeanpiere.consumirapis.Models.ResponseData;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterStudents adapter;
    private ApiManager apiManager;
    List<Estudiantes> estudiantes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_students);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apiManager = new ApiManager();
        adapter = new AdapterStudents(estudiantes, this);
        recyclerView.setAdapter(adapter);

       apiManager.getEstudents().enqueue(new Callback<ResponseData>() {
           @Override
           public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
               ResponseData mData = response.body();
               if (mData != null && response.isSuccessful()) {
                   //estudiantes = response.body();
                   System.out.println("==============================================");
                   System.out.println("Lista de Estudiantes: " + mData.getEstudiantes());
                   System.out.println("==============================================");
                   estudiantes = mData.getEstudiantes();
                   adapter.setEstudiantes(estudiantes);
                   adapter.notifyDataSetChanged();
               } else {
                   Toast.makeText(MainActivity.this, "Error eres malo", Toast.LENGTH_SHORT).show();
               }
           }
           @Override
           public void onFailure(Call<ResponseData> call, Throwable t) {
               Toast.makeText(MainActivity.this, "Error al conectarse", Toast.LENGTH_SHORT).show();
           }
       });

    }

}
