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
    TextView newPayment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        //Set the choosen option inside card view
        newAdress = (TextView)findViewById(R.id.adresse_livraison_1);
        String address = getIntent().getStringExtra("address_change");
        newAdress.setText(address);

        newPayment = (TextView)findViewById(R.id.text_moyen_paiement);
        String paiment = getIntent().getStringExtra("payment_change");
        newPayment.setText(paiment);


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

    public void onClickPayment(View view){
        Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
        startActivity(intent);
    }
}
