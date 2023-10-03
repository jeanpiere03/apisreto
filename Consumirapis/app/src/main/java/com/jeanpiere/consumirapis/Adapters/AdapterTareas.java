package com.jeanpiere.consumirapis.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jeanpiere.consumirapis.Models.Tareas;
import com.jeanpiere.consumirapis.R;
import com.jeanpiere.consumirapis.TareasActivity;

import java.util.List;

public class AdapterTareas extends RecyclerView.Adapter<AdapterTareas.ViewHolder> {

    private final int position;
    private List<Tareas> tareasList;
    private Context context;

    public AdapterTareas(List<Tareas> tareas, Context context, int position) {
        this.tareasList = tareas;
        this.context = context;
        this.position = position;
    }


    public void setTareas(List<Tareas> tareas) {
        this.tareasList = tareas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vista_tareas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tareas tarea = tareasList.get(position);

        holder.textIdTarea.setText("ID: " + tarea.getId());
        holder.textTituloTarea.setText("Título: " + tarea.getTitulo());
        holder.textDescripcionTarea.setText("Descripción: " + tarea.getDescripcion());
        holder.textNivelTarea.setText("Nivel: " + tarea.getNivel());
        holder.textFechaEntrega.setText("Fecha de Entrega: " + tarea.getFechaEntrega());


    }

    @Override
    public int getItemCount() {
        if (tareasList != null) {
            return tareasList.size();
        } else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textIdTarea;
        TextView textTituloTarea;
        TextView textDescripcionTarea;
        TextView textNivelTarea;
        TextView textFechaEntrega;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textIdTarea = itemView.findViewById(R.id.text_id_tarea);
            textTituloTarea = itemView.findViewById(R.id.text_titulo_tarea);
            textDescripcionTarea = itemView.findViewById(R.id.text_descripcion_tarea);
            textNivelTarea = itemView.findViewById(R.id.text_nivel_tarea);
            textFechaEntrega = itemView.findViewById(R.id.text_fecha_etrenga_tarea);
        }
    }
}


