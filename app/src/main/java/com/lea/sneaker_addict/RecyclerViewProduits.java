package com.lea.sneaker_addict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerViewProduits extends AppCompatActivity {

    RecyclerView recyclerItem;
    String nomProd[], dscProd[];
    int images[]={R.drawable.air_force_1,R.drawable.naruto_akatsuki_converse,R.drawable.monopoly_stansmith,
            R.drawable.pizza_vans,R.drawable.ananas,R.drawable.red_dragon_1,R.drawable.hokusai_force1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tous_produits_page);

        //assign the layout recycler_produit to this recycler view
        recyclerItem = findViewById(R.id.recycler_produit);

        //Get info from String arrays created in String.xml
        nomProd = getResources().getStringArray(R.array.creation_name);
        dscProd = getResources().getStringArray(R.array.description);

        MyAdapter adapterProduit = new MyAdapter(this,nomProd,dscProd,images);
        GridLayoutManager gridLayoutManagerProduit = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        recyclerItem.setLayoutManager(gridLayoutManagerProduit);
        recyclerItem.setAdapter(adapterProduit);


    }
}
