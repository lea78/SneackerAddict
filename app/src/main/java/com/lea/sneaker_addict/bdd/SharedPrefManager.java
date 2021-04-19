package com.lea.sneaker_addict.bdd;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefManager {
    private static SharedPrefManager instanceShaPM;
    private static Context ctx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_PSEUDO = "pseudoUser";
    private static final String KEY_MAIL = "mailUser";
    private static final String KEY_USER_ID = "idUser";

    private SharedPrefManager(Context context) {
        ctx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (instanceShaPM == null) {
            instanceShaPM = new SharedPrefManager(context);
        }
        return instanceShaPM;
    }

    public boolean userLogin(int id, String pseudo, String mail){
    SharedPreferences sharedPreferences = (SharedPreferences) ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();

    editor.putInt(KEY_USER_ID, id);
    editor.putString(KEY_PSEUDO,pseudo);
    editor.putString(KEY_MAIL, mail);

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

    public boolean logout(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}