package com.lea.sneaker_addict.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lea.sneaker_addict.R;

public class ProduitArtistePageAdapter extends RecyclerView.Adapter<ProduitArtistePageAdapter.MyViewHolder> {

    String nomProduit[], prixProduit[];
    int imgProduit[];
    Context context;
    private RecyclerViewClickListenerProduitArtiste listener;

    public ProduitArtistePageAdapter(Context mcontext, String mnomProduit[], String mprixProduit[], int mimgProduit[], RecyclerViewClickListenerProduitArtiste mlistener){
        this.context = mcontext;
        nomProduit = mnomProduit;
        prixProduit = mprixProduit;
        imgProduit = mimgProduit;
        this.listener = mlistener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView nomProduitViewholder, prixProduitViewholder;
        ImageView imgProduitViewholder;
        FrameLayout mainPageArtisteProduitViewholder;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            nomProduitViewholder = itemView.findViewById(R.id.pageArtiste_nomProduit);
            prixProduitViewholder = itemView.findViewById(R.id.pageArtiste_prixProduit);
            imgProduitViewholder = itemView.findViewById(R.id.pageArtiste_imgProduit);
            mainPageArtisteProduitViewholder = itemView.findViewById(R.id.framelayout_produit_pageartiste);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View myViewInflater = inflater.inflate(R.layout.item_pageartiste_produits, parent, false);
        return new ProduitArtistePageAdapter.MyViewHolder(myViewInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nomProduitViewholder.setText(nomProduit[position]);
        holder.prixProduitViewholder.setText(prixProduit[position]);
        holder.imgProduitViewholder.setImageResource(imgProduit[position]);
    }

    @Override
    public int getItemCount() {
        return imgProduit.length;
    }

    public interface RecyclerViewClickListenerProduitArtiste{
        void onClick(View v, int position);
    }
}
