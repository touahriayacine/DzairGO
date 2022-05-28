package com.example.dzairgo.utils;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.text.Layout;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.dzairgo.R;
import com.example.dzairgo.activities.LireArticleActivity;
import com.example.dzairgo.utils.Commentaire;

import java.util.ArrayList;
import java.util.Map;

public class Contenu {
    private Map<ElementType,Object> structure; // EX: <Image , url>
    private ArrayList<Commentaire> commentaires;
    public Contenu(Map<ElementType, Object> structure, ArrayList<Commentaire> commentaires) {
        this.structure = structure;
        this.commentaires = commentaires;
    }

    public Map<ElementType, Object> getStructure() {
        return structure;
    }

    public void setStructure(Map<ElementType, Object> structure) {
        this.structure = structure;
    }

    public ArrayList<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(ArrayList<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public void addElement(ElementType type , Object element){
        this.structure.put(type ,  element);
    }

    public void createElements(Context c , ConstraintLayout parent){
        int i = 0;
        View lastView = null;
        for (Map.Entry<ElementType, Object> entry : this.structure.entrySet()) {
            ElementType elementType = entry.getKey();
            Object o = entry.getValue();
            if (elementType.equals(ElementType.TEXT)) {
                lastView = createText((String) o, c , parent , i == 0?true:false , lastView , i);
            }
            if (elementType.equals(ElementType.IMAGE)) {
                lastView = createImage((Drawable) o, c, parent ,  i == 0?true:false , lastView , i);
            }
            if (elementType.equals(ElementType.VIDEO)) {
                lastView = createVideo((MediaStore.Video) o, c , parent , i == 0?true:false , lastView , i);
            }
            i++;
        }
    }
    private View createImage(Drawable img , Context c , ConstraintLayout parent , boolean isFirstElement , View topElement , int id){
        ImageView newImg = new ImageView(c);
        newImg.setId(id);
        newImg.setImageDrawable(img);
        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT , ConstraintLayout.LayoutParams.WRAP_BEHAVIOR_VERTICAL_ONLY);
        lp.height = (int) c.getResources().getDisplayMetrics().heightPixels / 2;
        newImg.setLayoutParams(lp);
        if(isFirstElement) {
            lp.topToTop = parent.getId();
        }else{
            lp.topMargin = 20;
            lp.topToBottom = topElement.getId();
        }
        lp.startToStart = parent.getId();
        lp.endToEnd = parent.getId();
        parent.addView(newImg);
        return  newImg;
    }
    private View createText(String txt , Context c , ConstraintLayout parent , boolean isFirstElement , View topElement , int id){
        TextView newText = new TextView(c);
        newText.setId(id);
        newText.setText(txt);
        newText.setTextColor(c.getResources().getColor(R.color.grey2));
        newText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        Typeface tf = c.getResources().getFont(R.font.roboto_regular);
        newText.setTypeface(tf);
        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT , ConstraintLayout.LayoutParams.WRAP_CONTENT);
       if(isFirstElement) {
           lp.topToTop = parent.getId();
       }else{
           lp.topMargin = 20;
           lp.topToBottom = topElement.getId();
       }
        newText.setLayoutParams(lp);
        parent.addView(newText);
        return newText;
    }
    private View createVideo(MediaStore.Video video , Context c , ConstraintLayout parent, boolean isFirstElement , View topElement , int id){
        return null;
    }
    public void addCommentaire(Commentaire c){
        this.commentaires.add(c);
    }
}
