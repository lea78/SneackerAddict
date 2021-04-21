package com.lea.sneaker_addict.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lea.sneaker_addict.adapters.ProductPageAdapter;
import com.lea.sneaker_addict.R;

import java.util.ArrayList;
import java.util.List;

public class ProductPageActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RecyclerView recyclerProduit;
    int images[]={R.drawable.page_produit_sneakers0, R.drawable.page_produit_sneakers1, R.drawable.page_produit_sneakers2};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productpage);

        //*****BOTTOM NAVIGATION*****//
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.menu_produit);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.menu_homepage :
                        startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.menu_produit:
                        return true;

                    case R.id.menu_profil:
                        startActivity(new Intent(getApplicationContext(), LoginUserActivity.class));
                        return true;
                }
                return false;
            }
        });

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

        ProductPageAdapter adapterProduit = new ProductPageAdapter(this,images);
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

    public void back(View view){
        startActivity(new Intent(ProductPageActivity.this, AllProductsActivity.class));
    }

    public void onClickPaiement(View view){
        Intent intent = new Intent(getApplicationContext(), ConfirmActivity.class);
        startActivity(intent);
    }
}
