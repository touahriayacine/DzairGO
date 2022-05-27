package com.example.dzairgo.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dzairgo.R;
import com.example.dzairgo.adapters.Adapter;
import com.example.dzairgo.utils.Article;
import com.example.dzairgo.utils.Contenu;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class ActualityFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager lm ;
    ArrayList<Article> articles;
    int lastScrol = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actuality, container, false);
        articles = generateData(view.getContext());
        lm = new LinearLayoutManager(view.getContext());
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(lm);
        Adapter adapter = new Adapter(articles);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Article> generateData(Context c){
        articles = new ArrayList<>();
        articles.add(new Article("Festival de la musique symphonique" , c.getDrawable(R.drawable.violon) , "2022-10-04" , "09:55" , 45 , new Contenu() , "Tlemcen"));
        articles.add(new Article("Festival de la musique symphonique" , c.getDrawable(R.drawable.violon) , "2022-10-4", "09:55" , 45 , new Contenu() , "Tlemcen"));
        articles.add(new Article("Festival de la musique symphonique" , c.getDrawable(R.drawable.violon) , "2022-10-6" , "10:06" , 45 , new Contenu() , "Tlemcen"));
        articles.add(new Article("Festival de la musique symphonique" , c.getDrawable(R.drawable.violon) , "2022-8-4", "12:40" , 45 , new Contenu() , "Tlemcen"));
        articles.add(new Article("Festival de la musique symphonique" , c.getDrawable(R.drawable.violon) ,"2010-7-5", "23:05" , 45 , new Contenu() , "Tlemcen"));
        articles.add(new Article("Festival de la musique symphonique" , c.getDrawable(R.drawable.violon) , "2012-9-4","15:23", 45 , new Contenu() , "Tlemcen"));
        return articles;
    }
    private void setFullScreen(View view){
        view.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if(lastScrol<i1){
                    //scrolldown
                    Toast.makeText(view.getContext(), "scroll down", Toast.LENGTH_SHORT).show();
                }
                if(i1<lastScrol){
                    //scrollup
                    Toast.makeText(view.getContext(), "scroll up", Toast.LENGTH_SHORT).show();
                }
                lastScrol = i1;
            }
        });

    }

}