package com.lea.sneaker_addict.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lea.sneaker_addict.R;

public class PaymentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_payment);
    }

    public void back(View view) {
        startActivity(new Intent(PaymentActivity.this, ConfirmActivity.class));
    }
}
