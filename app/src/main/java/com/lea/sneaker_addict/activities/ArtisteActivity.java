package com.lea.sneaker_addict.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.lea.sneaker_addict.R;
import com.lea.sneaker_addict.adapters.ArtistePageAdapter;

public class ArtisteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_artistepage);

        TableLayout tableLayout = findViewById(R.id.activity_main_tabs);
        TabItem tabApropos = findViewById(R.id.tab_apropos);
        TabItem tabProduits = findViewById(R.id.tab_produits);
        TabItem tabCommandes = findViewById(R.id.tab_commandes);
        TabItem tabAvis = findViewById(R.id.tab_avis);
        ViewPager viewPager = findViewById(R.id.viewpager_artiste_contenu);

    }

}
