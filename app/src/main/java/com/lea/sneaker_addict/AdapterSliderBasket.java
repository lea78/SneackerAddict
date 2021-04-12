package com.lea.sneaker_addict;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSliderBasket extends RecyclerView.Adapter<AdapterSliderBasket.AdapterViewHolder> {
    ArrayList<HelperSliderBasket> helperSliderBasketsLocation;

    public AdapterSliderBasket(ArrayList<HelperSliderBasket> helperSliderBaskets){
        this.helperSliderBasketsLocation = helperSliderBaskets;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.basketrecyclecard, parent, false);
        AdapterViewHolder adapterViewHolder = new AdapterViewHolder(view);
        return adapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        HelperSliderBasket helperSliderBasket = helperSliderBasketsLocation.get(position);
        holder.image.setImageResource(helperSliderBasket.getImage());
        holder.titre.setText(helperSliderBasket.getTitre());
        holder.prix.setText(helperSliderBasket.getPrix());

    }

    @Override
    public int getItemCount() {
        return helperSliderBasketsLocation.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView titre;
        TextView prix;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.accueil_image_produit);
            titre = itemView.findViewById(R.id.accueil_nom_basket);
            prix = itemView.findViewById(R.id.accueil_prix_basket);
        }
    }


}
