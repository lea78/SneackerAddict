package com.lea.sneaker_addict.helpers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.lea.sneaker_addict.R;
import com.lea.sneaker_addict.adapters.ProduitArtistePageAdapter;

public class ProduitFragment extends Fragment {

    RecyclerView recyclerView;
    String nomProduit[], prixProduit[];
    int imageProduit[]={R.drawable.sneakers_ghibli1, R.drawable.sneakers_ghibli_2, R.drawable.sneakers_ghibli_3};
    private ProduitArtistePageAdapter.RecyclerViewClickListenerProduitArtiste listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_produit, container, false);
        recyclerView = view.findViewById(R.id.recycler_pageArtiste_produits);
        nomProduit = getResources().getStringArray(R.array.product_name_artisteprofil);
        prixProduit = getResources().getStringArray(R.array.product_price_artisteprofil);

        ProduitArtistePageAdapter adapterProduit = new ProduitArtistePageAdapter(getContext(), nomProduit, prixProduit, imageProduit, listener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterProduit);
        return view;
    }
}
