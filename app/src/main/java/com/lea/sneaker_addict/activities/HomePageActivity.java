package com.lea.sneaker_addict.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lea.sneaker_addict.adapters.HomePageArtisteAdapter;
import com.lea.sneaker_addict.adapters.HomePageShoesAdapter;
import com.lea.sneaker_addict.helpers.HomePageArtisteHelper;
import com.lea.sneaker_addict.helpers.HomePageShoesHelper;
import com.lea.sneaker_addict.R;

import java.util.ArrayList;


public class HomePageActivity extends AppCompatActivity implements HomePageArtisteAdapter.OnArtisteListener, HomePageShoesAdapter.OnShoesListener{

    RecyclerView artistesRecycler;
    RecyclerView.Adapter adapter;

    RecyclerView basketRecycler;
    RecyclerView.Adapter adapterBasket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.menu_homepage);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.menu_homepage:
                        return true;

                    case R.id.menu_produit:
                        startActivity(new Intent(getApplicationContext(), AllProductsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.menu_profil:
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        return true;
                }
                return false;
            }
        });

        artistesRecycler = findViewById(R.id.recycler_slider_artiste);
        mArtistesRecycler();

        basketRecycler = findViewById(R.id.recycler_produits_baskets);
        mBasketRecycler();
    }

    //method to hook features in the recycler
    private void mArtistesRecycler() {
        artistesRecycler.setHasFixedSize(true);
        artistesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<HomePageArtisteHelper> helperSliderArtistesLocation = new ArrayList<>();
        helperSliderArtistesLocation.add(new HomePageArtisteHelper(R.drawable.artiste1, "SneakersAddict"));
        helperSliderArtistesLocation.add(new HomePageArtisteHelper(R.drawable.artiste2, "SneakyGirl"));
        helperSliderArtistesLocation.add(new HomePageArtisteHelper(R.drawable.artiste3, "Tulip"));

        adapter = new HomePageArtisteAdapter(helperSliderArtistesLocation, this);
        artistesRecycler.setAdapter(adapter);
    }

    private void mBasketRecycler() {
        basketRecycler.setHasFixedSize(true);
        basketRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<HomePageShoesHelper> helperSliderBaskets = new ArrayList<>();
        helperSliderBaskets.add(new HomePageShoesHelper(R.drawable.accueil_basket1, "Noir et Blanc", "70€"));
        helperSliderBaskets.add(new HomePageShoesHelper(R.drawable.accueil_basket2, "Colorfull", "60€"));
        helperSliderBaskets.add(new HomePageShoesHelper(R.drawable.accueil_basket3, "Graphic Shoes", "95€"));
        helperSliderBaskets.add(new HomePageShoesHelper(R.drawable.page_produit_sneakers0, "VANS Carpe Koï", "120€"));

        adapterBasket = new HomePageShoesAdapter(helperSliderBaskets, this);
        basketRecycler.setAdapter(adapterBasket);
    }

    @Override
    public void onArtisteClick(int position) {
        Intent intent = new Intent(this, ArtisteActivity.class);
        startActivity(intent);
    }

    @Override
    public void onShoesClick(int position) {
        Intent intent = new Intent(this, ProductPageActivity.class);
        startActivity(intent);
    }
}