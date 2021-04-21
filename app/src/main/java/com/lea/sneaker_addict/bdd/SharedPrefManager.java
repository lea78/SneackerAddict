package com.lea.sneaker_addict.bdd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.lea.sneaker_addict.activities.LoginUserActivity;


public class SharedPrefManager {
    private static SharedPrefManager instanceShaPM;
    private static Context ctx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_PSEUDO = "pseudoUser";
    private static final String KEY_MAIL = "mailUser";
    private static final String KEY_USER_ID = "idUser";
    private static final String KEY_USER_NAME = "nomUser";
    private static final String KEY_USER_SURNAME = "prenomUser";
    private static final String KEY_USER_PASSWORD = "passwordUser";
    private static final String KEY_USER_AVATAR = "avatarUser";
    private static final String KEY_USER_ADRESSE = "adresseUser";



    private SharedPrefManager(Context context) {
        ctx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (instanceShaPM == null) {
            instanceShaPM = new SharedPrefManager(context);
        }
        return instanceShaPM;
    }

    public boolean userLogin(int id, String pseudo, String mail, String nom, String prenom, String password, String adresse){
    SharedPreferences sharedPreferences = (SharedPreferences) ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();

    editor.putInt(KEY_USER_ID, id);
    editor.putString(KEY_PSEUDO,pseudo);
    editor.putString(KEY_MAIL, mail);
    editor.putString(KEY_USER_NAME, nom);
    editor.putString(KEY_USER_SURNAME, prenom);
    editor.putString(KEY_USER_PASSWORD, password);
    editor.putString(KEY_USER_ADRESSE, adresse);

    editor.apply();

    return true;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_PSEUDO,null) !=null){
            return true;
        }
        return false;
    }

    public void logout(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        ctx.startActivity(new Intent(ctx, LoginUserActivity.class));
    }

    public String getPseudo(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PSEUDO, null);
    }

    public String getMail(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_MAIL, null);
    }

    public String getPassword(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_PASSWORD, null);
    }

    public String getNameUser(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_NAME, null);
    }

    public String getSurnameUser(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_SURNAME, null);
    }

    public String getAvatar(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_AVATAR, null);
    }

    public String getAdresse(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_ADRESSE, null);
    }

    public boolean isAdress(String adresse){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_ADRESS, adresse);
        editor.apply();
        return true;
    }
}