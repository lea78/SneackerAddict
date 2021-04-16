package com.lea.sneaker_addict.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lea.sneaker_addict.R;

public class ConfirmActivity extends AppCompatActivity {

    TextView newAdress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        newAdress = (TextView)findViewById(R.id.adresse_livraison_1);
        String address = getIntent().getStringExtra("address_change");
        //newAdress.setText("2 Petre Melikishvili St. 0162, Tsibili");
        newAdress.setText(address);

        //*****BOTTOM NAVIGATION BAR*****//
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.menu_produit);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.menu_homepage :
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.menu_produit:
                        return true;

                    case R.id.menu_profil:
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        return true;
                }
                return false;
            }
        });
    }

    public void onClickAdress(View view) {
        Intent intent = new Intent(getApplicationContext(), AdressActivity.class);
        startActivity(intent);
    }
}