package com.lea.sneaker_addict;

public class HelperSliderBasket {
    int image;
    String titre;
    String prix;

    public HelperSliderBasket(int image, String titre, String prix){
        this.image = image;
        this.titre = titre;
        this.prix = prix;
    }

    public int getImage(){
        return image;
    }

    public String getTitre(){
        return titre;
    }

    public String getPrix(){
        return prix;
    }
}
