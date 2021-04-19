package com.lea.sneaker_addict.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lea.sneaker_addict.R;

public class PaymentActivity extends AppCompatActivity {

    public EditText mEditPayment;
    public RadioButton rButtonPaypal, rButtonCreditCard;
    public Button buttonPayment;
    public String confirmPayment = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        buttonPayment = (Button) findViewById(R.id.button_moyen_paiement);
        rButtonPaypal = (RadioButton) findViewById(R.id.paypal);
        rButtonCreditCard = (RadioButton) findViewById(R.id.info_carte);

        buttonPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rButtonPaypal.isChecked()) {
                    Intent intent = new Intent(PaymentActivity.this, ConfirmActivity.class);
                    intent.putExtra("payment_change", "Paypal");
                    startActivity(intent);
                }
                if (rButtonCreditCard.isChecked()) {
                    Intent intent = new Intent(PaymentActivity.this, ConfirmActivity.class);
                    mEditPayment = (EditText) findViewById(R.id.edit_num_carte);
                    String strPayment = mEditPayment.getText().toString();
                    String maskPayment = maskCardNumber(strPayment, "xxxx-xxxx-xxxx-####");
                    String kindOfPayment = "Carte de crédit";
                    confirmPayment = kindOfPayment + "\n" + maskPayment;
                    intent.putExtra("payment_change", confirmPayment);
                    startActivity(intent);
                }
            }
        });

        //*****BOTTOM NAVIGATION BAR*****//
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_paiement);
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

    }

    //Method for button back
    public void back(View view) {
        startActivity(new Intent(PaymentActivity.this, ConfirmActivity.class));
    }

    //Method to mask the number of the credit card
    public String maskCardNumber(String cardNumber, String mask) {
        int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '#') {
                maskedNumber.append(cardNumber.charAt(index));
                index++;
            } else if (c == 'x') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append(c);
            }
        }

        return maskedNumber.toString();
    }
}


