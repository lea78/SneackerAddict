package com.lea.sneaker_addict.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lea.sneaker_addict.R;

public class AllProductsAdapter extends RecyclerView.Adapter<AllProductsAdapter.MyViewHolder> {

    String data1[], data2[];
    int img[];
    Context cont;

    public AllProductsAdapter(Context myCont, String nomItem[], String descItem[], int images[]){
        cont = myCont;
        data1 = nomItem;
        data2 = descItem;
        img = images;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cont);
        View myViewInflater = inflater.inflate(R.layout.component_allproducts, parent, false);
        return new MyViewHolder(myViewInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textName.setText(data1[position]);
        holder.textDesc.setText(data2[position]);
        holder.imgShoes.setImageResource(img[position]);


    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textName, textDesc;
        ImageView imgShoes;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textName =itemView.findViewById(R.id.nom_sneakers);
            textDesc =itemView.findViewById(R.id.desc_sneakers);
            imgShoes = itemView.findViewById(R.id.img_sneakers);

        }
    }
}
