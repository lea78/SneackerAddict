package com.lea.sneaker_addict.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.lea.sneaker_addict.R;

public class PaymentActivity extends AppCompatActivity {

    public EditText mEditPayment;
    public RadioButton rButtonPaypal, rButtonCreditCard;
    public RadioGroup rPaymentGroup;
    public Button buttonPayment;
    public String strPayment ="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_payment);

        buttonPayment = (Button)findViewById(R.id.button_moyen_paiement);
        rButtonPaypal = (RadioButton)findViewById(R.id.paypal);
        rButtonCreditCard = (RadioButton)findViewById(R.id.info_carte);
        buttonPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rButtonPaypal.isChecked()){
                    Intent intent = new Intent(PaymentActivity.this, ConfirmActivity.class);
                    intent.putExtra("payment_change", R.drawable.paypal);
                    startActivity(intent);
                }
                if (rButtonCreditCard.isChecked()){
                    Intent intent = new Intent(PaymentActivity.this, ConfirmActivity.class);

                }
            }
        });
    }

    public void back(View view) {
        startActivity(new Intent(PaymentActivity.this, ConfirmActivity.class));
    }
}
