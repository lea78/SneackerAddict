package com.lea.sneaker_addict.helpers;

import android.widget.Button;

public class HomePageArtisteHelper {

    int image;
    String artisteName;
    //Button buttonArtisteSlider;

    public HomePageArtisteHelper(int image, String artisteName){
        this.image = image;
        this.artisteName = artisteName;
        //this.buttonArtisteSlider = buttonArtisteSlider;
    }

    public int getImage(){
        return image;
    }

    public String getArtisteName(){
        return artisteName;
    }

    /*public Button getButtonArtisteSlider(){
        return buttonArtisteSlider;
    }*/
}
