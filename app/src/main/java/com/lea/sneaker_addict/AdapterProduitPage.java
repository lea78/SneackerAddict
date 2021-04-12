package com.lea.sneaker_addict;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterProduitPage extends RecyclerView.Adapter<AdapterProduitPage.MyViewHolder> {

    Context mycontext;
    int img[];

    public AdapterProduitPage(Context context, int images[]) {
        mycontext = context;
        img = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mycontext);
        View myViewInflater = inflater.inflate(R.layout.pageproduit_sneaker_image, parent, false);
        return new MyViewHolder(myViewInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imgShoes.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgShoes;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgShoes = itemView.findViewById(R.id.img_sneakers_produit);
        }
    }
}
