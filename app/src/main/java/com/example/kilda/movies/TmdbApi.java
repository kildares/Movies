package com.example.kilda.movies;

/**
 * Created by kilda on 2/8/2018.
 */

public class TmdbApi {

    public static final String API_KEY = BuildConfig.TMDB_API_KEY;


    public static String getAPIKey()
    {
        return API_KEY;
    }
}
