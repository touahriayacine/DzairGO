package com.example.dzairgo.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dzairgo.R;
import com.example.dzairgo.activities.LireArticleActivity;
import com.example.dzairgo.utils.Article;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private ArrayList<Article> articles;
  public Adapter(ArrayList<Article> articles){
      this.articles = articles;
  }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_article ,parent,false);
        MyViewHolder holder =  new MyViewHolder(view) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        holder.wilaya.setText(articles.get(position).getWilaya());
        holder.article_img.setImageDrawable(articles.get(position).getImageUrl());
        holder.article_title.setText(articles.get(position).getTitre());
        holder.time_passed.setText(articles.get(position).getDate_pub() + " " + articles.get(position).getTime_pub());
        holder.nbComments.setText(articles.get(position).getNb_commentaires()+"");
        holder.oneArticle.setTag(position);
        holder.oneArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchReadingArticleActivity(view , (int)view.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView wilaya;
        TextView article_title;
        TextView time_passed;
        TextView nbComments;
        ImageView article_img;
        ConstraintLayout oneArticle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            wilaya = (TextView) itemView.findViewById(R.id.wilaya);
            article_title = (TextView) itemView.findViewById(R.id.article_title);
            time_passed = (TextView) itemView.findViewById(R.id.time_passed);
            nbComments = (TextView) itemView.findViewById(R.id.nb_comments);
            article_img = (ImageView) itemView.findViewById(R.id.image_article);
            oneArticle = (ConstraintLayout) itemView.findViewById(R.id.one_article);
        }
    }
    private void launchReadingArticleActivity(View view , int position){
        Intent intent = new Intent(view.getContext() , LireArticleActivity.class);
        intent.putExtra("article" , position);
        view.getContext().startActivity(intent);
    }

}
