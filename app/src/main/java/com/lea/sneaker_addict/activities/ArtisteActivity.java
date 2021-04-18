package com.lea.sneaker_addict.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lea.sneaker_addict.R;
import com.lea.sneaker_addict.adapters.ArtistePageAdapter;
import com.lea.sneaker_addict.helpers.AProposFragment;
import com.lea.sneaker_addict.helpers.ProduitFragment;

public class ArtisteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_artistepage);

        ViewPager2 viewPager2 = findViewById(R.id.component_artiste_viewpager);
        viewPager2.setAdapter(new ArtistePageAdapter(this));

        TabLayout tabLayout = findViewById(R.id.component_artiste_tabs);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:{
                        tab.setText("A propos");
                        break;
                    }
                    case 1:{
                        tab.setText("Produits");
                        break;
                    }
                    case 2:
                        tab.setText("Avis");
                }
            }
        }
        );
        tabLayoutMediator.attach();




    }

}
