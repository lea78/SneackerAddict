package com.lea.sneaker_addict.helpers;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lea.sneaker_addict.R;

public class ArtistePageFragment extends Fragment {
    private static final String KEY_POSITION="position";
    private static final String KEY_COLOR="color";
    
    public ArtistePageFragment(){}

    public static ArtistePageFragment newInstance(int position, int color) {
        
        Bundle args = new Bundle();
        
        ArtistePageFragment fragmentArtiste = new ArtistePageFragment();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        fragmentArtiste.setArguments(args);
        return fragmentArtiste;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragement_artiste, container, false);

        LinearLayout rootView= (LinearLayout) result.findViewById(R.id.fragment_page_rootview);
        TextView textView= (TextView) result.findViewById(R.id.fragment_page_title);

        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);

        rootView.setBackgroundColor(color);
        textView.setText("Page numéro "+position);

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);

        return result;
    }
}
