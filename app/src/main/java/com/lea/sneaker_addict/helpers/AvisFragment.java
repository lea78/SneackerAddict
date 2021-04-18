package com.lea.sneaker_addict.helpers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lea.sneaker_addict.R;
import com.lea.sneaker_addict.adapters.AvisArtistePageAdapter;

public class AvisFragment extends Fragment {

    RecyclerView recyclerView;
    String[] nomClient;
    String[] commentaireClient;
    String[] dateAvis;
    int[] imageClient ={R.drawable.photoprofil_homme_2, R.drawable.photoprofil_femme_3, R.drawable.photoprofil_homme_1};

    public AvisFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avis, container, false);
        recyclerView = view.findViewById(R.id.recycler_pageArtiste_avis);
        nomClient = getResources().getStringArray(R.array.comments_clientname_artisteprofil);
        commentaireClient = getResources().getStringArray(R.array.comments_comments_artisteprofil);
        dateAvis = getResources().getStringArray(R.array.comments_avis_artisteprofil);
        AvisArtistePageAdapter avisArtistePageAdapter = new AvisArtistePageAdapter(getContext(), nomClient, commentaireClient, dateAvis, imageClient);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(avisArtistePageAdapter);

        return view;
    }
}
