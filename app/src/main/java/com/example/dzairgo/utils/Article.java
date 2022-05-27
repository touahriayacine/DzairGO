package com.example.dzairgo.utils;

import android.graphics.drawable.Drawable;

import java.time.LocalDate;
import java.time.LocalTime;

public class Article {
    private String titre;
    private Drawable imageUrl;
    private String date_pub;
    private String time_pub;
    private int nb_commentaires;
    private Contenu contenu;
    private String wilaya;

    public Article(String titre, Drawable imageUrl, String date_pub, String time_pub, int nb_commentaires, Contenu contenu, String wilaya) {
        this.titre = titre;
        this.imageUrl = imageUrl;
        this.date_pub = date_pub;
        this.time_pub = time_pub;
        this.nb_commentaires = nb_commentaires;
        this.contenu = contenu;
        this.wilaya = wilaya;
    }

    public String getWilaya() {
        return wilaya;
    }

    public void setWilaya(String wilaya) {
        this.wilaya = wilaya;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Drawable getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Drawable imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate_pub() {
        return date_pub;
    }

    public void setDate_pub(String date_pub) {
        this.date_pub = date_pub;
    }

    public String getTime_pub() {
        return time_pub;
    }

    public void setTime_pub(String time_pub) {
        this.time_pub = time_pub;
    }

    public int getNb_commentaires() {
        return nb_commentaires;
    }

    public void setNb_commentaires(int nb_commentaires) {
        this.nb_commentaires = nb_commentaires;
    }

    public Contenu getContenu() {
        return contenu;
    }

    public void setContenu(Contenu contenu) {
        this.contenu = contenu;
    }
}
