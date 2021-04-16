package com.lea.sneaker_addict.bdd;

import android.content.Context;
import android.util.Log;

import junit.framework.TestCase;

public class ModelTest extends TestCase {
    String tag = "Test-BD";
    public void testCreation(){
        Model model = new Model(null, "BD-Tests",null,1);
        Log.i(tag, "liste des tables: "+ model.allTableNames());
    }
}