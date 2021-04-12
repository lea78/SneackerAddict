package com.lea.sneaker_addict;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterSliderArtiste extends RecyclerView.Adapter<AdapterSliderArtiste.AdapterViewHolder>{

    ArrayList<HelperSliderArtiste> helperSliderArtistesLocation;

    public AdapterSliderArtiste(ArrayList<HelperSliderArtiste> helperSliderArtistes) {
        this.helperSliderArtistesLocation = helperSliderArtistes;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.artisterecyclercard, parent, false);
        AdapterViewHolder adapterViewHolder = new AdapterViewHolder(view);
        return adapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        HelperSliderArtiste helperSliderArtiste = helperSliderArtistesLocation.get(position);
        holder.image.setImageResource(helperSliderArtiste.getImage());
        holder.name.setText(helperSliderArtiste.getArtisteName());
    }

    @Override
    public int getItemCount() {
        return helperSliderArtistesLocation.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.artiste_image);
            name = itemView.findViewById(R.id.nom_artiste);
        }
    }
}

