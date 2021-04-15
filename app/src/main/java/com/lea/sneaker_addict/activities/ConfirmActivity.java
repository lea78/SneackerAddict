package com.lea.sneaker_addict.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lea.sneaker_addict.R;

public class ConfirmActivity extends AppCompatActivity {

    TextView newAdress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_confirm);
        String address = getIntent().getStringExtra("address_change");
        newAdress = (TextView)findViewById(R.id.adresse_livraison_1);
        newAdress.setText(address);
    }

    public void onClickAdress(View view) {
        Intent intent = new Intent(getApplicationContext(), AdressActivity.class);
        startActivity(intent);
    }
}
