package com.example.dzairgo.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class Commentaire {
    private Compte commentateur;
    private String date_com;
    private String time_Com;
    private String commentaire;
    public Commentaire(){}
    public Commentaire(Compte commentateur, String date_com, String time_Com, String commentaire) {
        this.commentateur = commentateur;
        this.date_com = date_com;
        this.time_Com = time_Com;
        this.commentaire = commentaire;
    }

    public Compte getCommentateur() {
        return commentateur;
    }

    public void setCommentateur(Compte commentateur) {
        this.commentateur = commentateur;
    }

    public String getDate_com() {
        return date_com;
    }

    public void setDate_com(String date_com) {
        this.date_com = date_com;
    }

    public String getTime_Com() {
        return time_Com;
    }

    public void setTime_Com(String time_Com) {
        this.time_Com = time_Com;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
