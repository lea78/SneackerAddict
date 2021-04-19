package com.lea.sneaker_addict.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lea.sneaker_addict.R;

public class AllProductsAdapter extends RecyclerView.Adapter<AllProductsAdapter.MyViewHolder> {

    String data1[], data2[];
    int img[];
    Context cont;
    private RecyclerViewClickListener listener;

    public AllProductsAdapter(Context myCont, String nomItem[], String descItem[], int images[], RecyclerViewClickListener listener){
        cont = myCont;
        data1 = nomItem;
        data2 = descItem;
        img = images;
        this.listener = listener;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView textName, textDesc;
        ImageView imgShoes;
        RelativeLayout mainAllProducts;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textName =itemView.findViewById(R.id.nom_sneakers);
            textDesc =itemView.findViewById(R.id.desc_sneakers);
            imgShoes = itemView.findViewById(R.id.img_sneakers);
            mainAllProducts = itemView.findViewById(R.id.layout_main_tousLesProduits);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAbsoluteAdapterPosition());
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cont);
        View myViewInflater = inflater.inflate(R.layout.item_allproducts_cardview, parent, false);
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

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

}
