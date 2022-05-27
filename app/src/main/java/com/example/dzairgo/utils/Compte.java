package com.example.dzairgo.utils;

import android.graphics.drawable.Drawable;

public class Compte {
    private String fullName;
    private Drawable imageUrl;

    public Compte(String fullName, Drawable imageUrl) {
        this.fullName = fullName;
        this.imageUrl = imageUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Drawable getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Drawable imageUrl) {
        this.imageUrl = imageUrl;
    }
}
