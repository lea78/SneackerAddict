package com.lea.sneaker_addict.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lea.sneaker_addict.helpers.HomePageArtisteHelper;
import com.lea.sneaker_addict.R;

import java.util.ArrayList;


public class HomePageArtisteAdapter extends RecyclerView.Adapter<HomePageArtisteAdapter.AdapterViewHolder>{

    ArrayList<HomePageArtisteHelper> helperSliderArtistesLocation;
    private OnArtisteListener mOnArtisteListener;

    public HomePageArtisteAdapter(ArrayList<HomePageArtisteHelper> helperSliderArtistes, OnArtisteListener onArtisteListener) {
        this.helperSliderArtistesLocation = helperSliderArtistes;
        this.mOnArtisteListener = onArtisteListener;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homepage_artiste_cardview, parent, false);
        AdapterViewHolder adapterViewHolder = new AdapterViewHolder(view, mOnArtisteListener);
        return adapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        HomePageArtisteHelper helperSliderArtiste = helperSliderArtistesLocation.get(position);
        holder.image.setImageResource(helperSliderArtiste.getImage());
        holder.name.setText(helperSliderArtiste.getArtisteName());
    }

    @Override
    public int getItemCount() {
        return helperSliderArtistesLocation.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView name;
        OnArtisteListener onArtisteListener;

        public AdapterViewHolder(@NonNull View itemView, OnArtisteListener onArtisteListener) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.artiste_image);
            name = itemView.findViewById(R.id.nom_artiste);
            this.onArtisteListener = onArtisteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onArtisteListener.onArtisteClick(getAbsoluteAdapterPosition());
        }
    }

    public interface OnArtisteListener{
        void onArtisteClick(int position);
    }
}

