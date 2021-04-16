package com.lea.sneaker_addict.bdd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;

import java.util.ArrayList;
import java.util.List;

public class Model extends SQLiteOpenHelper {

    String tag = "ModelTest";
    public static final String DATABASE_NAME = "SneakersAddict.db";
    //public static final String TABLE_NAME = ;

    public Model(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.i(tag, "constructeur");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(tag, "Création");
        //code
        Log.i(tag, "Fin création");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(tag, "Upgrade");
        //code
        Log.i(tag, "Fin upgarde");
    }

    public List<String> allTableNames(){
        List<String> result = new ArrayList<String>();
        String selectQuery = "select name from  SneakersAddict where type ='table' ";
        Cursor cursor = this.getReadableDatabase().rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do{
                String nameTable = cursor.getString(cursor.getColumnIndex("name"));
                result.add(nameTable);
            }while (cursor.moveToNext());
        }
        return result;
    }
}
