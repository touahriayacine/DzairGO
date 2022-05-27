package com.example.dzairgo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.pm.LauncherActivityInfo;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dzairgo.R;
import com.example.dzairgo.adapters.Adapter;
import com.example.dzairgo.fragments.ActualityFragment;
import com.example.dzairgo.fragments.MapFragment;
import com.example.dzairgo.utils.Article;
import com.example.dzairgo.utils.Contenu;
import com.google.android.material.navigation.NavigationView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    LinearLayout activity_btn;
    LinearLayout carte_btn;
    RelativeLayout backgroundSelectedFragment;
    TextView activityTxt ;
    TextView carteTxt;
    ImageView activityImg;
    ImageView carteImg;
    FragmentManager fragmentManager;
    ImageView search_btn;
//    NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity_btn = (LinearLayout) findViewById(R.id.actuality_btn);
        carte_btn = (LinearLayout) findViewById(R.id.carte_btn);
        backgroundSelectedFragment = (RelativeLayout) findViewById(R.id.selected_fragment_bck);
        activityTxt = (TextView) findViewById(R.id.activity_title_nb);
        carteTxt = (TextView) findViewById(R.id.carte_title_nb);
        activityImg = (ImageView) findViewById(R.id.activity_icon_nb);
        carteImg = (ImageView) findViewById(R.id.map_icon_nb);
//        menu_btn = (ImageView) findViewById(R.id.menu_btn);
//        nv = (NavigationView) findViewById(R.id.side_menu);
//        configMenu();
        configActivityBtn();
        configCarteBtn();
        launchActualityFragment();

    }
    private void configActivityBtn(){
        activity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateNavigationBar(0);
                carteImg.setImageDrawable(view.getResources().getDrawable(R.drawable.pin_black , getTheme()));
                carteTxt.setVisibility(View.GONE);
                activityImg.setImageDrawable(view.getResources().getDrawable(R.drawable.newspaper_blanc , getTheme()));
                activityTxt.setVisibility(View.VISIBLE);
                launchActualityFragment();
            }
        });
    }
    private void configCarteBtn(){
        carte_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateNavigationBar(500);
                carteImg.setImageDrawable(view.getResources().getDrawable(R.drawable.pin_blanc , getTheme()));
                carteTxt.setVisibility(View.VISIBLE);
                activityImg.setImageDrawable(view.getResources().getDrawable(R.drawable.newspaper_black , getTheme()));
                activityTxt.setVisibility(View.GONE);
                launchMapFragment();
            }
        });
    }
    private void animateNavigationBar(int num){
        Animation animation = new TranslateAnimation(0, num,0, 0);
        animation.setDuration(400);
        animation.setFillAfter(true);
        backgroundSelectedFragment.startAnimation(animation);
    }
    private void launchActualityFragment(){
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragments_container, ActualityFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("actualite")
                .commit();
    }
    private void launchMapFragment(){
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragments_container, MapFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("actualite")
                .commit();
    }
//    private void configMenu() {
//        menu_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int width = nv.getWidth();
//                Animation animation = new TranslateAnimation(0,width,0,0);
//                animation.setDuration(300);
//                animation.setFillAfter(true);
//                nv.startAnimation(animation);
//            }
//        });
//    }
}