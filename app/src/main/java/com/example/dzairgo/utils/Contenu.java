package com.example.dzairgo.utils;

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
}
