package com.lea.sneaker_addict.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lea.sneaker_addict.R;
import com.lea.sneaker_addict.bdd.Constants;
import com.lea.sneaker_addict.bdd.RequestHandler;
import com.lea.sneaker_addict.bdd.SharedPrefManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginUserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextPseudo, editTextPassword;
    private Button buttonLogin;
    private ProgressDialog progressDialog;
    private TextView goToRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, ProfilActivity.class));
            return;
        }

        editTextPseudo = (EditText) findViewById(R.id.login_edit);
        editTextPassword = (EditText) findViewById(R.id.password_edit);
        buttonLogin = (Button) findViewById(R.id.button_connexion);
        goToRegister = (TextView)findViewById(R.id.text_to_register);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        buttonLogin.setOnClickListener(this);
        goToRegister.setOnClickListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.menu_profil);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.menu_homepage :
                        startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.menu_produit:
                        startActivity(new Intent(getApplicationContext(),AllProductsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.menu_profil:
                        return true;

                }
                return false;
            }
        });
    }

    private void userLogin(){
        final String pseudoUser = editTextPseudo.getText().toString().trim();
        final String passwordUser = editTextPassword.getText().toString().trim();

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        Log.i("Test", response);
                        try {
                            JSONObject jsonLoginObj = new JSONObject(response);
                            if(!jsonLoginObj.getBoolean("error")){

                                SharedPrefManager.getInstance(getApplicationContext())
                                    .userLogin(
                                        jsonLoginObj.getInt("idUser"),
                                        jsonLoginObj.getString("pseudoUser"),
                                        jsonLoginObj.getString("mailUser")
                                );
                                startActivity(new Intent(getApplicationContext(), ProfilActivity.class));
                                //Toast.makeText(getApplicationContext(), "user succesfully registered", Toast.LENGTH_LONG).show();

                            }else{
                                Toast.makeText(getApplicationContext(), jsonLoginObj.getString("message"), Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                 },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("pseudoUser", pseudoUser);
                params.put("passwordUser", passwordUser);
                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonLogin){
            userLogin();
        }
        if(view == goToRegister){
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }
}
