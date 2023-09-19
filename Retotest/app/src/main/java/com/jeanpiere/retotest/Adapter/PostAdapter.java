package com.jeanpiere.retotest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jeanpiere.retotest.CommentsActivity;
import com.jeanpiere.retotest.R;
import com.jeanpiere.retotest.model.Post;
import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Post> posts;
    private Context context;

    //const
    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    //llamada de represantacion de la vistaapi :)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vistaapi, parent, false);
        return new ViewHolder(view);
    }

    //asociacion de datos
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.titleTextView.setText(post.getTitle());
        holder.bodyTextView.setText(post.getBody());
        holder.rightTextView.setText(String.valueOf(post.getId()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CommentsActivity.class);
                intent.putExtra("postId", post.getId());
                context.startActivity(intent);
            }
        });

    }


    //llamado de class
    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView bodyTextView;
        TextView rightTextView;

        //obtener referencia

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView1);
            bodyTextView = itemView.findViewById(R.id.bodyTextView2);
            rightTextView = itemView.findViewById(R.id.rightTextView3);
        }
    }
}
