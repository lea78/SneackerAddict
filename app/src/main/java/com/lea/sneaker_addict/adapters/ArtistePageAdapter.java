package com.lea.sneaker_addict.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.lea.sneaker_addict.activities.AllProductsActivity;
import com.lea.sneaker_addict.helpers.AproposOngletFragment;
import com.lea.sneaker_addict.helpers.ArtistePageFragment;

public class ArtistePageAdapter extends FragmentPagerAdapter {


    // 1 - Array of colors that will be passed to PageFragment
    private int[] colors;

    // 2 - Default Constructor
    public ArtistePageAdapter(FragmentManager mgr, int[] colors) {
        super(mgr);
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return (5); // 3 - Number of page to show
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: //Page number 1
                return ArtistePageFragment.newInstance(position, 1);
            case 1: //Page number 2
                return AproposOngletFragment.newInstance();
            //case 2: //Page number 3
                //return AllProductsActivity.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }



}
