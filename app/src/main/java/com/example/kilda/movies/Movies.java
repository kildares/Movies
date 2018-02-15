package com.example.kilda.movies;

/**
 * Created by kilda on 2/12/2018.
 */

public class Movies {
    String image;
    String name;
    String year;
    String synopsis;
    String movieId;
    String average;

    public Movies(String movieId, String name, String year, String image, String synopsis,String average)
    {
        this.movieId = movieId;
        this.name=name;
        this.year=year;
        this.image=image;
        this.synopsis=synopsis;
        this.average=average;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
