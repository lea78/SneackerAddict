package com.lea.sneaker_addict.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lea.sneaker_addict.R;
import com.lea.sneaker_addict.bdd.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextPseudo, editTextMail, editTextPassword;
    private Button buttonRegister;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextPseudo = (EditText) findViewById(R.id.register_username);
        editTextMail = (EditText) findViewById(R.id.register_mail);
        editTextPassword = (EditText) findViewById(R.id.register_password);

        buttonRegister = (Button) findViewById(R.id.button_Inscription);

        progressDialog = new ProgressDialog(this);
        buttonRegister.setOnClickListener(this);

    }

    private void registerUser() {
        final String pseudo = editTextPseudo.getText().toString().trim();
        final String email = editTextMail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        progressDialog.setMessage("En cours d'enregistrement...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("VOLLEY", response);
                progressDialog.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            progressDialog.hide();
            Log.e("VOLLEY", error.toString());
            Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("pseudoUser", pseudo);
                params.put("mailUser", email);
                params.put("passwordUser", password);
                Log.i("MAP", String.valueOf(params));
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    @Override
    public void onClick(View view) {
        if (view == buttonRegister)
            registerUser();
    }
}
