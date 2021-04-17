package com.lea.sneaker_addict.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.lea.sneaker_addict.helpers.AProposFragment;
import com.lea.sneaker_addict.helpers.ProduitFragment;

import java.util.ArrayList;

public class ArtistePageAdapter extends FragmentStateAdapter {


    public ArtistePageAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new AProposFragment();
            case 1:
                return new ProduitFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }


}
