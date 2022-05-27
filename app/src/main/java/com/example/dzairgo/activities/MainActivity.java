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
import android.view.ContextMenu;
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
import com.example.dzairgo.utils.Commentaire;
import com.example.dzairgo.utils.Compte;
import com.example.dzairgo.utils.Contenu;
import com.example.dzairgo.utils.ElementType;
import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public ArrayList<Compte> comptes ;
    public ArrayList<Commentaire> commentaires;
    public ArrayList<Article> articles;
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
        comptes = genererCompts();
        commentaires = genererCommenetaires();
        articles = generArticles();
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
        commentaires.add(new Commentaire(comptes.get(1) , "30 Mai 2022" , "15:03" , "Lieu très adapté aux enfants, les gens sont gentils et très accueillant, je recommande"));
        commentaires.add(new Commentaire(comptes.get(2) , "5 Juin 2022" , "10:34" , "Endroit très calme et paisible, parfait pour les randonnées en famille"));
        commentaires.add(new Commentaire(comptes.get(3) , "7 Juin 2022" , "16:20" , "J'aime beaucoup, l'endroit est propre est très bien préservé, les guides sont bien instruits sur l'histoire du lieu. \n" +
                "La nourriture à l'intérieur n'est pas très bonne par contre"));
        commentaires.add(new Commentaire(comptes.get(0) , "27 Mai 2022" , "18:52" , "Très jolie comme endroit, je le visite à chaque fois avec mes enfants, la vue est splendide depuis ce lieu"));
        return commentaires;
    }
    ArrayList<Article> generArticles(){
        ArrayList<Article> articles= new ArrayList<>();
        Map<ElementType, Object> structure = new HashMap<>();
        structure.put(ElementType.TEXT , "Le palais des raïs, ou bastion 23, est un monument historique et architectural classé. Il est aussi un centre polyvalent d'art et de culture. Ouvert au publique depuis novembre 1994. Il est constitué de trois palais, cinq maisons, un passage ouvert, une coure centrale, un chemin de ronde et une batterie.\n" +
                "Ce palais demeure le dernier et unique témoin du prolongement de la Casbah jusqu'à la mer. Il offre aujourd'hui, aux visiteurs, la possibilité de se promener dans un environnement historique et culturel exceptionnel\n");
        structure.put(ElementType.IMAGE , this.getDrawable(R.drawable.place_1));
        ArrayList<Commentaire> commentaires = new ArrayList<>();
        commentaires.add(this.commentaires.get(0));
        commentaires.add(this.commentaires.get(1));
        Contenu contenu1 = new Contenu(structure ,commentaires);
        articles.add(new Article("Palais des raïs (Bastion 23)" , this.getDrawable(R.drawable.place_1) , "27 Mai 2022" , "18:57" , 2 ,contenu1 , "Alger" ));

        structure.clear();
        structure.put(ElementType.TEXT , "Un parc paysager installé sur une pente abrupte, en plein centre d'Alger, dans un quartier résiduel très calme. Le parc Beyrout est toujours en très bon état, avec ses mêmes éclats d'antan. Le lieu abrite une variété d'Arbres ombragés des allées spacieux et des espaces verts parfaitement entretenus et gardés.\n" +
                "Le lieu dispose également d'un aire de jeux pour enfants, et il offre, même de loin, une vue sur la majestueuse baie d'Alger \n");
        structure.put(ElementType.IMAGE , this.getDrawable(R.drawable.place_2));
        commentaires.clear();
        commentaires.add(this.commentaires.get(2));
        commentaires.add(this.commentaires.get(3));
        Contenu contenu2 = new Contenu(structure, commentaires);
        articles.add(new Article("Parc de Beyrout (Mont riant)" , this.getDrawable(R.drawable.place_2) , "27 Mai 2022" , "19:08" , 2 ,contenu2 , "Alger" ));

        ///
        structure.clear();
        structure.put(ElementType.TEXT , "«Ce musée qui ambitionne d'avoir une vocation historique, ethnologique et d'interprétation scientifique, se situe au pied de la Casbah d'Alger dans les imposantes \"Voûtes Khireddine\", construites en 1814 par Hadj Ali Pacha et qui ont servi d'atelier de réparation de la flotte sous la régence Ottoman avant que les forces coloniales françaises n'y installent de grands fours pour fournir du pain à leurs soldats.\n" +
                "Remontant jusqu'aux périodes, préhistorique, antique, médiévale et ottomane, le \"Musée de la marine\", œuvre à \"restituer la vie de l'Homme depuis ses premiers contacts avec la mer\", en focalisant sur la période ottomane de \"La Régence d'Alger\" qui a précédé la colonisation française de l'Algérie» Explique Mme Amel Mokrani Boukari, directrice du musée");
        structure.put(ElementType.IMAGE , this.getDrawable(R.drawable.place_3));
        commentaires.clear();
        commentaires.add(this.commentaires.get(0));
        Contenu contenu3 = new Contenu(structure, commentaires);
        articles.add(new Article("Musée nationale publique maritime " , this.getDrawable(R.drawable.place_2) , "27 Mai 2022" , "19:20" , 1 ,contenu3 , "Alger" ));

        structure.clear();
        structure.put(ElementType.TEXT , "Ce port est un endroit de grand repère dans l'histoire de l'Algérie, marquant le débarquement de l'armée française, un 5 juillet 1830\n" +
                "Il compte quatre hôtels classés, ainsi que plusieurs restaurants implémentés pour se restaurer si besoin.\n" +
                "Le parking est disponible pour 200da.\n" +
                "On y propose également des petits tours de 45 mins en poney ou en bateau, pour s'offrir un moment agréable et paisible et profiter de la vue magnifique de ce port ");
        structure.put(ElementType.IMAGE , this.getDrawable(R.drawable.place_4));
        Contenu contenu4 = new Contenu(structure, null);
        articles.add(new Article("Port de Sidi Fredj" , this.getDrawable(R.drawable.place_2) , "27 Mai 2022" , "21:50" , 0 ,contenu4 , "Alger" ));

        structure.clear();
        structure.put(ElementType.TEXT , "L'ancien parc de Galland a été inauguré en 1915 par Charles de Galland, maire d'Alger de 1910 à 1919 et proviseur du lycée de Ben Aknoun, qui fit don à la ville de ce magnifique terrain.\n" +
                "Le parc vient tout juste d'être superbement restauré et il est donc encore plus beau depuis 2018. \n" +
                "Ses jardins en terrasses entrecoupés d'escaliers, ses volières et son plan d'eau en faisant alors l'un des lieux de promenades les plus appréciés des Algérois et l'un des plus élégants parc de la ville.\n" +
                "Un parc très propre et recommendé pour tout amoureux des lieux de paix et de prospérité ");
        structure.put(ElementType.IMAGE , this.getDrawable(R.drawable.place_5));
        commentaires.clear();
        commentaires.add(this.commentaires.get(0));
        commentaires.add(this.commentaires.get(1));
        commentaires.add(this.commentaires.get(2));
        commentaires.add(this.commentaires.get(3));
        Contenu contenu5 = new Contenu(structure, commentaires);
        articles.add(new Article("Parc de Beyrout (Mont riant)" , this.getDrawable(R.drawable.place_2) , "27 Mai 2022" , "22:00" , 4 ,contenu5 , "Alger" ));
        return articles;
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