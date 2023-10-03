package com.jeanpiere.consumirapis.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.jeanpiere.consumirapis.CursosActivity;
import com.jeanpiere.consumirapis.Models.Cursos;
import com.jeanpiere.consumirapis.Models.Estudiantes;
import com.jeanpiere.consumirapis.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class AdapterStudents extends RecyclerView.Adapter<AdapterStudents.ViewHolder> {

    private List<Estudiantes> estudiantesList;
    private Context context;

    public AdapterStudents(List<Estudiantes> estudiantes, Context context) {
        if (estudiantes == null) {
            this.estudiantesList = new ArrayList<>();
        } else {
            this.estudiantesList = estudiantes;
        }
        this.context = context;
    }

    public void setEstudiantes(List<Estudiantes> estudiantes) {
        this.estudiantesList = estudiantes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vista_estudents, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Estudiantes estudiante = estudiantesList.get(position);

        holder.textId.setText("ID: " + estudiante.getId());
        holder.textNombre.setText("Nombre: " + estudiante.getNombre());
        holder.textEdad.setText("Edad: " + estudiante.getEdad());
        holder.textEmail.setText("Email: " + estudiante.getEmail());
        Picasso.get().load(estudiante.getImagen_url()).into(holder.imageView);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Estudiantes estudiante = estudiantesList.get(adapterPosition);
                    Intent intent = new Intent(context, CursosActivity.class);
                    intent.putExtra("position", adapterPosition);
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return estudiantesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textId;
        TextView textNombre;
        TextView textEdad;
        TextView textEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.image_view_estudents);
            textId = itemView.findViewById(R.id.text_id_estudents);
            textNombre = itemView.findViewById(R.id.text_nombre_estudents);
            textEdad = itemView.findViewById(R.id.text_edad_estudents);
            textEmail = itemView.findViewById(R.id.text_email_students);
        }
    }
}

