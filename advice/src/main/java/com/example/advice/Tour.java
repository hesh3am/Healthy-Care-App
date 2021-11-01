package com.example.advice;

public class Tour {

    private int placeName;
    private int description;
    private int image;

    public Tour(int placeName, int description,int image) {
        this.placeName = placeName;
        this.description = description;
        this.image=image;
    }

    public int getdescription() {
        return description;
    }

    public int getname() {
        return placeName;
    }

    public int getImage() {
        return image;
    }

}