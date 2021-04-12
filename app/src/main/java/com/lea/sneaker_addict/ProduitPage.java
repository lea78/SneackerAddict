package com.lea.sneaker_addict;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProduitPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RecyclerView recyclerProduit;
    int images[]={R.drawable.page_produit_sneakers0, R.drawable.page_produit_sneakers1, R.drawable.page_produit_sneakers2};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produit_page);

        //*****SPINNER*****//
        final Spinner spinner = (Spinner) findViewById(R.id.spinner_size);

        //Spinner click listener
        spinner.setOnItemSelectedListener(this);

        //Elements in the spinner
        List<String> sizes = new ArrayList<String>();
        sizes.add("36");
        sizes.add("37");
        sizes.add("38");
        sizes.add("39");
        sizes.add("40");
        sizes.add("41");

        //Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sizes);

        //Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        //*****RECYCLER VIEW*****//
        //assign the layout recycler_produit to this recycler view
        recyclerProduit = findViewById(R.id.recycler_slider_item_artiste);

        AdapterProduitPage adapterProduit = new AdapterProduitPage(this,images);
        LinearLayoutManager gridLayoutManagerProduit = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerProduit.setLayoutManager(gridLayoutManagerProduit);
        recyclerProduit.setAdapter(adapterProduit);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
