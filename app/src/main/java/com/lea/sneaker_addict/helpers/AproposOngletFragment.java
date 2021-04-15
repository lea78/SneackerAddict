package com.lea.sneaker_addict.helpers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lea.sneaker_addict.R;

public class AproposOngletFragment extends Fragment {

    public static AproposOngletFragment newInstance(){
        return new AproposOngletFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_apropos, container, false);
    }
}
