package com.lea.sneaker_addict.helpers;

public class HomePageArtisteHelper {

    int image;
    String artisteName;

    public HomePageArtisteHelper(int image, String artisteName){
        this.image = image;
        this.artisteName = artisteName;
    }

    public int getImage(){
        return image;
    }

    public String getArtisteName(){
        return artisteName;
    }
}
