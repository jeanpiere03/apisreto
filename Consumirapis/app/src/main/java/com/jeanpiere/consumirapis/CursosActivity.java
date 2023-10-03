package com.jeanpiere.consumirapis;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import com.jeanpiere.consumirapis.Adapters.AdapterCursos;
import com.jeanpiere.consumirapis.Apis.Api;
import com.jeanpiere.consumirapis.Apis.ApiManager;
import com.jeanpiere.consumirapis.Models.Cursos;
import com.jeanpiere.consumirapis.Models.Estudiantes;
import com.jeanpiere.consumirapis.Models.ResponseData;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CursosActivity extends AppCompatActivity {
    private List<Cursos> cursos;
    private RecyclerView recyclerView;
    private AdapterCursos cursosAdapter;

    private Integer position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        recyclerView = findViewById(R.id.RecyclerView_Cursos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cursos = new ArrayList<>();
        cursosAdapter = new AdapterCursos(cursos, getApplicationContext());
        recyclerView.setAdapter(cursosAdapter);

        if (getIntent().getExtras() != null) {
            position = getIntent().getIntExtra("position", 0);
        }

        showPrueba();
    }

    public void showPrueba() {
        ApiManager apiManager = new ApiManager();
        Call<ResponseData> call = apiManager.getEstudents();
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                ResponseData mData = response.body();
                System.out.println("==================================");
                System.out.println("Lista de Estudiantes: " + mData.getEstudiantes());
                System.out.println("==================================");
                if (mData != null && response.isSuccessful()) {
                    if (mData.getEstudiantes().size() > position) {
                        Estudiantes selectedStudent = mData.getEstudiantes().get(position);
                        if (mData.getEstudiantes().get(position).getCursos() != null) {
                            List<Cursos> cursos = mData.getEstudiantes().get(position).getCursos();
                            System.out.println(cursos);
                            cursosAdapter.setCursos(cursos);
                        } else {
                            System.out.println("No hay cursos asignados para este estudiante.");
                        }
                    } else {
                        System.out.println("Respuesta Nula");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(CursosActivity.this, "ERROR DE CONEXIÓN", Toast.LENGTH_SHORT).show();
            }
        });
    }
}




