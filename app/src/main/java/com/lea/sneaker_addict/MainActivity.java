package com.lea.sneaker_addict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView artistesRecycler;
    RecyclerView.Adapter adapter;

    RecyclerView basketRecycler;
    RecyclerView.Adapter adapterBasket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil_main);


        artistesRecycler = findViewById(R.id.recycler_slider_artiste);
        mArtistesRecycler();

        basketRecycler = findViewById(R.id.recycler_produits_baskets);
        mBasketRecycler();

    }

    //method to hook features in the recycler
    private void mArtistesRecycler(){
        artistesRecycler.setHasFixedSize(true);
        artistesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<HelperSliderArtiste> helperSliderArtistesLocation = new ArrayList<>();
        helperSliderArtistesLocation.add(new HelperSliderArtiste(R.drawable.artiste1, "SneakersAddict"));
        helperSliderArtistesLocation.add(new HelperSliderArtiste(R.drawable.artiste2, "GirlWithShoes"));
        helperSliderArtistesLocation.add(new HelperSliderArtiste(R.drawable.artiste3, "Tulip"));

        adapter = new AdapterSliderArtiste(helperSliderArtistesLocation);
        artistesRecycler.setAdapter(adapter);
    }

    private void mBasketRecycler(){
        basketRecycler.setHasFixedSize(true);
        basketRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<HelperSliderBasket> helperSliderBaskets = new ArrayList<>();
        helperSliderBaskets.add(new HelperSliderBasket(R.drawable.accueil_basket1, "Shoes in color", "120€"));
        helperSliderBaskets.add(new HelperSliderBasket(R.drawable.accueil_basket2, "Shoes in color", "120€"));
        helperSliderBaskets.add(new HelperSliderBasket(R.drawable.accueil_basket3, "Shoes in color", "120€"));
        helperSliderBaskets.add(new HelperSliderBasket(R.drawable.accueil_basket4, "Shoes in color", "120€"));

        adapterBasket = new AdapterSliderBasket(helperSliderBaskets);
        basketRecycler.setAdapter(adapterBasket);
    }
}