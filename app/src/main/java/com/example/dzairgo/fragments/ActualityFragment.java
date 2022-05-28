package com.example.dzairgo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.example.dzairgo.R;
import com.example.dzairgo.activities.MainActivity;
import com.example.dzairgo.adapters.ArticleAdapter;


public class ActualityFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager lm ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actuality, container, false);
        lm = new LinearLayoutManager(view.getContext());
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(lm);
        ArticleAdapter articleAdapter = new ArticleAdapter(((MainActivity)(view.getContext())).articles);
        recyclerView.setAdapter(articleAdapter);
        return view;
    }

}