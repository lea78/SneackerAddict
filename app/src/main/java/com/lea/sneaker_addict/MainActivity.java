package com.lea.sneaker_addict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView artistesRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);


        artistesRecycler = findViewById(R.id.recycler_slider_artiste);
        mArtistesRecycler();

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
}