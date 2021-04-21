package com.lea.sneaker_addict.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lea.sneaker_addict.adapters.AllProductsAdapter;
import com.lea.sneaker_addict.R;

public class AllProductsActivity extends AppCompatActivity {

    RecyclerView recyclerItem;
    String nomProd[], dscProd[];
    int images[] = {R.drawable.air_force_1, R.drawable.naruto_akatsuki_converse, R.drawable.monopoly_stansmith,
            R.drawable.pizza_vans, R.drawable.ananas, R.drawable.red_dragon_1, R.drawable.hokusai_force1, R.drawable.page_produit_sneakers0};
    private AllProductsAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allproducts);

        //*****BOTTOM NAVIGATION BAR*****//
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.menu_produit);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.menu_homepage:
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

        //assign the layout recycler_produit to this recycler view
        recyclerItem = findViewById(R.id.recycler_produit);

        //Get info from String arrays created in String.xml
        nomProd = getResources().getStringArray(R.array.creation_name);
        dscProd = getResources().getStringArray(R.array.description);
        //Call the method to go to the product page
        setOnClickListener();

        AllProductsAdapter adapterProduit = new AllProductsAdapter(this, nomProd, dscProd, images, listener);
        GridLayoutManager gridLayoutManagerProduit = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerItem.setLayoutManager(gridLayoutManagerProduit);
        recyclerItem.setAdapter(adapterProduit);

    }

    //Method on click listener to go to the product page
    private void setOnClickListener() {
        listener = new AllProductsAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ProductPageActivity.class);
                startActivity(intent);
            }
        };
    }
}
