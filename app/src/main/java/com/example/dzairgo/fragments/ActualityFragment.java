package com.example.dzairgo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dzairgo.R;
import com.example.dzairgo.activities.MainActivity;
import com.example.dzairgo.adapters.ArticleAdapter;
import com.example.dzairgo.adapters.PannelAdapter;
import com.example.dzairgo.utils.Article;

import java.util.ArrayList;


public class ActualityFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager lm;
    ImageView banner;
    RecyclerView pannel;
    RecyclerView.LayoutManager lm2;
    TextView a_la_une_title;
    TextView populaire_title;
    TextView abonne_title;
    ArrayList<Article> articles;
    ArticleAdapter articleAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actuality, container, false);
        articles = new ArrayList<>();
        articles.addAll(((MainActivity) (view.getContext())).articles);
        lm = new LinearLayoutManager(view.getContext());
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(lm);
        articleAdapter = new ArticleAdapter(articles);
        recyclerView.setAdapter(articleAdapter);
        lm2 = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        pannel = (RecyclerView) view.findViewById(R.id.panel);
        pannel.setLayoutManager(lm2);
        PannelAdapter pannelAdapter = new PannelAdapter(((MainActivity) view.getContext()).images);
        pannel.setAdapter(pannelAdapter);
        a_la_une_title = (TextView) view.findViewById(R.id.a_la_une_title);
        populaire_title = (TextView) view.findViewById(R.id.populaire_title);
        abonne_title = (TextView) view.findViewById(R.id.abonne_title);
        configPopulaireBtn();
        configAbonneBtn();
        configAlaUneBtn();
        return view;
    }

    private void configAlaUneBtn(){
        a_la_une_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                articles.addAll(((MainActivity) (view.getContext())).articles);
                articleAdapter.notifyDataSetChanged();
                a_la_une_title.setTextColor(view.getResources().getColor(R.color.green, view.getContext().getTheme()));
                abonne_title.setTextColor(view.getResources().getColor(R.color.grey6 , view.getContext().getTheme()));
                populaire_title.setTextColor(view.getResources().getColor(R.color.grey6 , view.getContext().getTheme()));

            }
        });
    }
    private void configPopulaireBtn(){
        populaire_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                articles.clear();
                articleAdapter.notifyDataSetChanged();
                a_la_une_title.setTextColor(view.getResources().getColor(R.color.grey6, view.getContext().getTheme()));
                abonne_title.setTextColor(view.getResources().getColor(R.color.grey6 , view.getContext().getTheme()));
                populaire_title.setTextColor(view.getResources().getColor(R.color.green , view.getContext().getTheme()));
            }
        });
    }
    private void configAbonneBtn(){
        abonne_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                articles.clear();
                articleAdapter.notifyDataSetChanged();
                a_la_une_title.setTextColor(view.getResources().getColor(R.color.grey6, view.getContext().getTheme()));
                abonne_title.setTextColor(view.getResources().getColor(R.color.green , view.getContext().getTheme()));
                populaire_title.setTextColor(view.getResources().getColor(R.color.grey6 , view.getContext().getTheme()));
            }
        });
    }

//    private void scrollConfig(){
//    }

}