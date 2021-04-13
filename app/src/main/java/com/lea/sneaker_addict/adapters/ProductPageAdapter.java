package com.lea.sneaker_addict.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lea.sneaker_addict.R;

public class ProductPageAdapter extends RecyclerView.Adapter<ProductPageAdapter.MyViewHolder> {

    Context mycontext;
    int img[];

    public ProductPageAdapter(Context context, int images[]) {
        mycontext = context;
        img = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mycontext);
        View myViewInflater = inflater.inflate(R.layout.item_productpage_imageshoes, parent, false);
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
