package com.lea.sneaker_addict.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProduitArtistePageAdapter extends RecyclerView.Adapter<ProduitArtistePageAdapter.MyViewHolder> {

    String nomProduit[], prixProduit[];
    int imgProduit;
    Context context;
    private RecyclerViewClickListenerProduitArtiste listener;

    public ProduitArtistePageAdapter(Context mcontext, String mnomProduit[], String mprixProduit[], int mimgProduit, RecyclerViewClickListenerProduitArtiste mlistener){
        context = mcontext;
        nomProduit = mnomProduit;
        prixProduit = mprixProduit;
        imgProduit = mimgProduit;
        this.listener = mlistener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitArtistePageAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface RecyclerViewClickListenerProduitArtiste{
        void onClick(View v, int position);
    }
}
