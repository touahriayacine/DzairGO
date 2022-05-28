package com.example.dzairgo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dzairgo.R;
import com.example.dzairgo.utils.Commentaire;

import org.w3c.dom.Comment;
import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {
    ArrayList<Commentaire> commentaires;

    public CommentAdapter(ArrayList<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    @NonNull
    @Override
    public CommentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_comment, parent, false);
        CommentAdapter.MyViewHolder holder = new CommentAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.MyViewHolder holder, int position) {
        holder.comment.setText(commentaires.get(position).getCommentaire());
//        holder.img.setImageDrawable(commentaires.get(position).getCommentateur().getImageUrl());
        holder.img.setImageDrawable(holder.itemView.getResources().getDrawable(R.drawable.user_fill));
        holder.commentateur.setText(commentaires.get(position).getCommentateur().getFullName());
        holder.date_time.setText(commentaires.get(position).getDate_com() + " " + commentaires.get(position).getTime_Com());
    }

    @Override
    public int getItemCount() {
        return commentaires.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView commentateur;
        TextView comment;
        TextView date_time;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.comment_avatar);
            commentateur = (TextView) itemView.findViewById(R.id.commentateur);
            comment = (TextView) itemView.findViewById(R.id.comment);
            date_time = (TextView) itemView.findViewById(R.id.date_time_comment);

        }
    }
}
