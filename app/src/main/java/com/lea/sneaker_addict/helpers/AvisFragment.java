package com.lea.sneaker_addict.helpers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.lea.sneaker_addict.R;

public class AvisFragment extends Fragment {

    RecyclerView recyclerView;
    TextView nomClient[], commentaireClient[], dateAvis[];
    ImageView imageClient[]={};

    public AvisFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avis, container, false);
        recyclerView = view.findViewById(R.id.recycler_pageArtiste_avis);
        return view;
    }
}
