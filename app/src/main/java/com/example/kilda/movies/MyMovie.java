package com.example.kilda.movies;

/**
 * Created by kilda on 2/12/2018.
 */

public class MyMovie {
    String image;
    String name;
    String year;
    String synopsis;

    public MyMovie(String name, String year, String image, String synopsis)
    {
        this.name=name;
        this.year=year;
        this.image=image;
        this.synopsis=synopsis;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}