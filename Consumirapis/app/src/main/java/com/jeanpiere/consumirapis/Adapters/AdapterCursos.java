package com.jeanpiere.consumirapis.Adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jeanpiere.consumirapis.CursosActivity;
import com.jeanpiere.consumirapis.Models.Cursos;
import com.jeanpiere.consumirapis.R;
import com.jeanpiere.consumirapis.TareasActivity;
import com.squareup.picasso.Picasso;
import java.util.List;

public class AdapterCursos extends RecyclerView.Adapter<AdapterCursos.ViewHolder> {

    private List<Cursos> cursosList;
    private Context context;

    public AdapterCursos(List<Cursos> cursos, Context context) {
        this.cursosList = cursos;
        this.context = context;
    }

    public void setCursos(List<Cursos> cursos) {
        this.cursosList = cursos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vista_curso, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cursos curso = cursosList.get(position);

        holder.textIdCurso.setText("ID: " + curso.getId());
        holder.textNombreCurso.setText("Nombre: " + curso.getNombre());
        holder.textCodigoCurso.setText("Código: " + curso.getCodigo());
        holder.textProfesorCurso.setText("Profesor: " + curso.getProfesor());
        holder.textCalificacionCurso.setText("Calificación: " + curso.getCalificacion());
        Picasso.get().load(curso.getImagen_url()).into(holder.imageViewCurso);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Cursos cursoSeleccionado = cursosList.get(adapterPosition);
                    Intent intent = new Intent(context, TareasActivity.class);
                    intent.putExtra("position", adapterPosition);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        if (cursosList != null) {
            return cursosList.size();
        } else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewCurso;
        TextView textIdCurso;
        TextView textNombreCurso;
        TextView textCodigoCurso;
        TextView textProfesorCurso;
        TextView textCalificacionCurso;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCurso = itemView.findViewById(R.id.image_view_curso);
            textIdCurso = itemView.findViewById(R.id.text_id_curso);
            textNombreCurso = itemView.findViewById(R.id.text_nombre_curso);
            textCodigoCurso = itemView.findViewById(R.id.text_codigo_curso);
            textProfesorCurso = itemView.findViewById(R.id.text_profesor);
            textCalificacionCurso = itemView.findViewById(R.id.text_calificacion);
        }
    }
}
