package com.jeanpiere.retotest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jeanpiere.retotest.R;
import com.jeanpiere.retotest.model.Comments;
import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {
    private List<Comments> comments;
    private Context context;

    public CommentsAdapter(Context context, List<Comments> comments) {
        this.context = context;
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.commentsapi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comments comment = comments.get(position);
        holder.nameTextView.setText(comment.getName());
        holder.emailTextView.setText(comment.getEmail());
        holder.bodyTextView.setText(comment.getBody());
        holder.rightTextView.setText(String.valueOf(comment.getId()));
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView emailTextView;
        TextView bodyTextView;
        TextView rightTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextViewComments);
            emailTextView = itemView.findViewById(R.id.emailTextViewComments);
            bodyTextView = itemView.findViewById(R.id.bodyTextViewComments);
            rightTextView = itemView.findViewById(R.id.rightTextView4);
        }
    }
}
