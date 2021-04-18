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

public class AvisArtistePageAdapter extends RecyclerView.Adapter<AvisArtistePageAdapter.MyViewHolder> {
    Context context;
    String nomClient[], commentaireClient[], dateAvis[];
    int imageClient[];

    public AvisArtistePageAdapter(Context mContext, String mNomClient[], String mCommentaireClient[], String mDateAvis[], int mImageClient[]){
        context = mContext;
        nomClient = mNomClient;
        commentaireClient = mCommentaireClient;
        dateAvis = mDateAvis;
        imageClient = mImageClient;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View myViewInflater = inflater.inflate(R.layout.item_pageartiste_avis, parent, false);
        return new AvisArtistePageAdapter.MyViewHolder(myViewInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nomClientViewHolder.setText(nomClient[position]);
        holder.commentaireViewHolder.setText(commentaireClient[position]);
        holder.dateViewHolder.setText(dateAvis[position]);
        holder.imageClientViewHolder.setImageResource(imageClient[position]);
    }

    @Override
    public int getItemCount() {
        return nomClient.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nomClientViewHolder, commentaireViewHolder, dateViewHolder;
        ImageView imageClientViewHolder;
        FrameLayout mainAvisViewHolder;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nomClientViewHolder = itemView.findViewById(R.id.pageArtiste_nomClient);
            commentaireViewHolder = itemView.findViewById(R.id.pageArtiste_avisClient);
            dateViewHolder = itemView.findViewById(R.id.pageArtiste_dateAvis);
            imageClientViewHolder = itemView.findViewById(R.id.pageArtiste_imgPhotoClient);
            mainAvisViewHolder = itemView.findViewById(R.id.framelayout_avis_pageartiste);
        }
    }
}
