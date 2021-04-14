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


public class MainActivity extends AppCompatActivity {

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
        helperSliderArtistesLocation.add(new HomePageArtisteHelper(R.drawable.artiste2, "GirlWithShoes"));
        helperSliderArtistesLocation.add(new HomePageArtisteHelper(R.drawable.artiste3, "Tulip"));

        adapter = new HomePageArtisteAdapter(helperSliderArtistesLocation);
        artistesRecycler.setAdapter(adapter);
    }

    private void mBasketRecycler() {
        basketRecycler.setHasFixedSize(true);
        basketRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<HomePageShoesHelper> helperSliderBaskets = new ArrayList<>();
        helperSliderBaskets.add(new HomePageShoesHelper(R.drawable.accueil_basket1, "Shoes in color", "120€"));
        helperSliderBaskets.add(new HomePageShoesHelper(R.drawable.accueil_basket2, "Shoes in color", "120€"));
        helperSliderBaskets.add(new HomePageShoesHelper(R.drawable.accueil_basket3, "Shoes in color", "120€"));
        helperSliderBaskets.add(new HomePageShoesHelper(R.drawable.accueil_basket4, "Shoes in color", "120€"));

        adapterBasket = new HomePageShoesAdapter(helperSliderBaskets);
        basketRecycler.setAdapter(adapterBasket);
    }
}