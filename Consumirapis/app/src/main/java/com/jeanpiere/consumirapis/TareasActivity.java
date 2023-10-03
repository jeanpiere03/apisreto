package com.jeanpiere.consumirapis;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jeanpiere.consumirapis.Adapters.AdapterTareas;
import com.jeanpiere.consumirapis.Apis.Api;
import com.jeanpiere.consumirapis.Apis.ApiManager;
import com.jeanpiere.consumirapis.Models.Tareas;
import com.jeanpiere.consumirapis.Models.Cursos;
import com.jeanpiere.consumirapis.Models.Estudiantes;
import com.jeanpiere.consumirapis.Models.ResponseData;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TareasActivity extends AppCompatActivity {
    private List<Tareas> tareas;
    private RecyclerView recyclerView;
    private AdapterTareas tareasAdapter;

    private int position = 0; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);

        recyclerView = findViewById(R.id.recycler_view_tareas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tareas = new ArrayList<>();
        tareasAdapter = new AdapterTareas(tareas, this, position);
        recyclerView.setAdapter(tareasAdapter);


        if (getIntent().getExtras() != null) {
            position = getIntent().getIntExtra("position", 0);
        }

        obtenerTareasDelCurso();
    }

    private void obtenerTareasDelCurso() {
        ApiManager apiManager = new ApiManager();
        Call<ResponseData> call = apiManager.getEstudents();
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                ResponseData mData = response.body();
                if (mData != null && response.isSuccessful()) {
                    if (mData.getEstudiantes().size() > position) {
                        Estudiantes selectedStudent = mData.getEstudiantes().get(position);
                        if (selectedStudent.getCursos() != null) {
                            List<Cursos> cursos = selectedStudent.getCursos();
                            if (cursos.size() > 0) {
                                List<Tareas> tareasDelCurso = cursos.get(0).getTareas();
                                if (tareasDelCurso != null) {
                                    tareasAdapter.setTareas(tareas);
                                    tareas.addAll(tareasDelCurso);
                                    tareasAdapter.notifyDataSetChanged();
                                } else {
                                    System.out.println ("No hay tareas para este curso.");
                                }
                            }
                        } else {
                            System.out.println ("bruno es burro.");
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(TareasActivity.this, "Error de conexión.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
