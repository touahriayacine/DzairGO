package com.example.dzairgo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dzairgo.R;
import com.example.dzairgo.adapters.CommentAdapter;
import com.example.dzairgo.utils.Article;
import com.example.dzairgo.utils.Commentaire;
import com.example.dzairgo.utils.Compte;
import com.example.dzairgo.utils.Contenu;
import com.example.dzairgo.utils.ElementType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class LireArticleActivity extends AppCompatActivity {
    Article article;
    ImageView headerImg ;
    TextView wilayaTag;
    TextView articleTitle;
    TextView timePassedPub;
    TextView nbComments;
    ConstraintLayout container;
    ArrayList<Article> articles;
    RecyclerView commentsList;
    RecyclerView.LayoutManager lm;
    CommentAdapter ca;
    public ArrayList<Compte> comptes ;
    public ArrayList<Commentaire> commentaires;
    Compte me;
    RelativeLayout publierBtn;
    EditText comment;
    CircleImageView myAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lire_article);
        Intent i = this.getIntent();
        comptes = genererCompts();
        commentaires = genererCommenetaires();
        articles = generArticles();
        article = articles.get(i.getIntExtra("article" , 0));
        me = comptes.get(i.getIntExtra("me" , 0));
        headerImg = (ImageView) findViewById(R.id.header_img);
        wilayaTag = (TextView) findViewById(R.id.wilaya_tag);
        articleTitle = (TextView) findViewById(R.id.article_big_title);
        timePassedPub = (TextView) findViewById(R.id.time_passed_reading_article);
        nbComments = (TextView) findViewById(R.id.nb_comments_reading_article);
        container = (ConstraintLayout) findViewById(R.id.content_container);
        publierBtn = (RelativeLayout) findViewById(R.id.publier_btn);
        comment = (EditText) findViewById(R.id.comment_edit_text);
        commentsList = (RecyclerView) findViewById(R.id.comments_list);
        myAvatar = (CircleImageView)findViewById(R.id.my_avatar_comment);
//        myAvatar.setImageDrawable(me.getImageUrl());
        myAvatar.setImageDrawable(getDrawable(R.drawable.user_fill));
        configPublierBtn();
        setContent();
        if(article.getNb_commentaires() >0){
            lm = new LinearLayoutManager(this);
            commentsList.setLayoutManager(lm);
             ca = new CommentAdapter(this.article.getContenu().getCommentaires());
            commentsList.setAdapter(ca);
        }
    }

    private void setContent(){
        headerImg.setImageDrawable(article.getImageUrl());
        wilayaTag.setText(article.getWilaya().toUpperCase());
        articleTitle.setText(article.getTitre());
        String date_time = article.getDate_pub() + " " + article.getTime_pub();
        timePassedPub.setText(date_time);
        nbComments.setText(((Integer)article.getNb_commentaires()).toString());
        article.createArticle(this , container);
    }
    private void configPublierBtn(){
        publierBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String commentTxt = comment.getText() + "";
                if(commentTxt.length() >0){
                    Commentaire commentaire = new Commentaire(me , "29 May 2022" , "17:48" , commentTxt);
                    article.getContenu().addCommentaire(commentaire);
                    comment.setText("");
                    if(article.getContenu().getCommentaires().size() == 0){
                        lm = new LinearLayoutManager(view.getContext());
                        commentsList.setLayoutManager(lm);
                        ca = new CommentAdapter(article.getContenu().getCommentaires());
                        commentsList.setAdapter(ca);
                    }else{
                        ca.notifyDataSetChanged();
                    }
                }

            }
        });
    }

    ArrayList<Compte> genererCompts(){
        ArrayList<Compte> comptes = new ArrayList<>();
        comptes.add(new Compte("Laouchedi Karim" , this.getDrawable(R.drawable.person)));
        comptes.add(new Compte("Anfel Boucetta", this.getDrawable(R.drawable.women)));
        comptes.add(new Compte("Athmane Mansour-Bahar" ,this.getDrawable(R.drawable.man_2)));
        comptes.add(new Compte("Karina Saidene" , this.getDrawable(R.drawable.women_2)));
        return comptes;
    }
    ArrayList<Commentaire> genererCommenetaires(){
        ArrayList<Commentaire> commentaires = new ArrayList<>();
        commentaires.add(new Commentaire(comptes.get(1) , "30 Mai 2022" , "15:03" , "Lieu tr??s adapt?? aux enfants, les gens sont gentils et tr??s accueillant, je recommande"));
        commentaires.add(new Commentaire(comptes.get(2) , "5 Juin 2022" , "10:34" , "Endroit tr??s calme et paisible, parfait pour les randonn??es en famille"));
        commentaires.add(new Commentaire(comptes.get(3) , "7 Juin 2022" , "16:20" , "J'aime beaucoup, l'endroit est propre est tr??s bien pr??serv??, les guides sont bien instruits sur l'histoire du lieu. \n" +
                "La nourriture ?? l'int??rieur n'est pas tr??s bonne par contre"));
        commentaires.add(new Commentaire(comptes.get(0) , "27 Mai 2022" , "18:52" , "Tr??s jolie comme endroit, je le visite ?? chaque fois avec mes enfants, la vue est splendide depuis ce lieu"));
        return commentaires;
    }
    ArrayList<Article> generArticles(){
        ArrayList<Article> articles= new ArrayList<>();
        Map<ElementType, Object> structure1 = new HashMap<>();

        structure1.put(ElementType.TEXT , "Le palais des ra??s, ou bastion 23, est un monument historique et architectural class??. Il est aussi un centre polyvalent d'art et de culture. Ouvert au publique depuis novembre 1994. Il est constitu?? de trois palais, cinq maisons, un passage ouvert, une coure centrale, un chemin de ronde et une batterie. Ce palais demeure le dernier et unique t??moin du prolongement de la Casbah jusqu'?? la mer. Il offre aujourd'hui, aux visiteurs, la possibilit?? de se promener dans un environnement historique et culturel exceptionnel");

        structure1.put(ElementType.IMAGE , this.getDrawable(R.drawable.place_1));
        ArrayList<Commentaire> commentaires1 = new ArrayList<>();
        commentaires1.add(this.commentaires.get(0));
        commentaires1.add(this.commentaires.get(1));
        Contenu contenu1 = new Contenu(structure1 ,commentaires1);
        articles.add(new Article("Palais des ra??s (Bastion 23)" , this.getDrawable(R.drawable.place_1) , "27 Mai 2022" , "18:57" , 2 ,contenu1 , "Alger" ));

        Map<ElementType, Object> structure2 = new HashMap<>();

        structure2.put(ElementType.TEXT , "Un parc paysager install?? sur une pente abrupte, en plein centre d'Alger, dans un quartier r??siduel tr??s calme. Le parc Beyrout est toujours en tr??s bon ??tat, avec ses m??mes ??clats d'antan. Le lieu abrite une vari??t?? d'Arbres ombrag??s des all??es spacieux et des espaces verts parfaitement entretenus et gard??s. Le lieu dispose ??galement d'un aire de jeux pour enfants, et il offre, m??me de loin, une vue sur la majestueuse baie d'Alger \n");

        structure2.put(ElementType.IMAGE , this.getDrawable(R.drawable.place_2));
        ArrayList<Commentaire> commentaires2 = new ArrayList<>();
        commentaires2.add(this.commentaires.get(2));
        commentaires2.add(this.commentaires.get(3));
        Contenu contenu2 = new Contenu(structure2, commentaires2);
        articles.add(new Article("Parc de Beyrout (Mont riant)" , this.getDrawable(R.drawable.place_2) , "27 Mai 2022" , "19:08" , 2 ,contenu2 , "Alger" ));

        Map<ElementType, Object> structure3 = new HashMap<>();

        structure3.put(ElementType.TEXT , "??Ce mus??e qui ambitionne d'avoir une vocation historique, ethnologique et d'interpr??tation scientifique, se situe au pied de la Casbah d'Alger dans les imposantes Vo??tes Khireddine, construites en 1814 par Hadj Ali Pacha et qui ont servi d'atelier de r??paration de la flotte sous la r??gence Ottoman avant que les forces coloniales fran??aises n'y installent de grands fours pour fournir du pain ?? leurs soldats. Remontant jusqu'aux p??riodes, pr??historique, antique, m??di??vale et ottomane, le Mus??e de la marine, ??uvre ?? restituer la vie de l'Homme depuis ses premiers contacts avec la mer, en focalisant sur la p??riode ottomane de La R??gence d'Alger qui a pr??c??d?? la colonisation fran??aise de l'Alg??rie?? Explique Mme Amel Mokrani Boukari, directrice du mus??e");

        structure3.put(ElementType.IMAGE , this.getDrawable(R.drawable.place_3));
        ArrayList<Commentaire> commentaires3 = new ArrayList<>();
        commentaires3.add(this.commentaires.get(0));
        Contenu contenu3 = new Contenu(structure3, commentaires3);
        articles.add(new Article("Mus??e nationale publique maritime " , this.getDrawable(R.drawable.place_3) , "27 Mai 2022" , "19:20" , 1 ,contenu3 , "Alger" ));

        Map<ElementType, Object> structure4 = new HashMap<>();

        structure4.put(ElementType.TEXT , "Ce port est un endroit de grand rep??re dans l'histoire de l'Alg??rie, marquant le d??barquement de l'arm??e fran??aise, un 5 juillet 1830. Il compte quatre h??tels class??s, ainsi que plusieurs restaurants impl??ment??s pour se restaurer si besoin. Le parking est disponible pour 200da. On y propose ??galement des petits tours de 45 mins en poney ou en bateau, pour s'offrir un moment agr??able et paisible et profiter de la vue magnifique de ce port ");

        structure4.put(ElementType.IMAGE , this.getDrawable(R.drawable.place_4));
        ArrayList<Commentaire> commentaires4 = new ArrayList<>();
        Contenu contenu4 = new Contenu(structure4, commentaires4);
        articles.add(new Article("Port de Sidi Fredj" , this.getDrawable(R.drawable.place_4) , "27 Mai 2022" , "21:50" , 0 ,contenu4 , "Alger" ));

        Map<ElementType, Object> structure5 = new HashMap<>();

        structure5.put(ElementType.TEXT , "L'ancien parc de Galland a ??t?? inaugur?? en 1915 par Charles de Galland, maire d'Alger de 1910 ?? 1919 et proviseur du lyc??e de Ben Aknoun, qui fit don ?? la ville de ce magnifique terrain. Le parc vient tout juste d'??tre superbement restaur?? et il est donc encore plus beau depuis 2018. Ses jardins en terrasses entrecoup??s d'escaliers, ses voli??res et son plan d'eau en faisant alors l'un des lieux de promenades les plus appr??ci??s des Alg??rois et l'un des plus ??l??gants parc de la ville. Un parc tr??s propre et recommend?? pour tout amoureux des lieux de paix et de prosp??rit?? ");

        structure5.put(ElementType.IMAGE , this.getDrawable(R.drawable.place_5));
        ArrayList<Commentaire> commentaires5 = new ArrayList<>();
        commentaires5.add(this.commentaires.get(0));
        commentaires5.add(this.commentaires.get(1));
        commentaires5.add(this.commentaires.get(2));
        commentaires5.add(this.commentaires.get(3));
        Contenu contenu5 = new Contenu(structure5, commentaires5);
        articles.add(new Article("Parc de Beyrout (Mont riant)" , this.getDrawable(R.drawable.place_5) , "27 Mai 2022" , "22:00" , 4 ,contenu5 , "Alger" ));
        return articles;
    }
}