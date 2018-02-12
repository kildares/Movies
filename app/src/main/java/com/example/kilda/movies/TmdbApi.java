package com.example.kilda.movies;

/**
 * Created by kilda on 2/8/2018.
 */

public class TmdbApi {

    private static final String API_KEY = BuildConfig.TMDB_API_KEY;
    private static final String BASE_URL = "http://image.tmdb.org/t/p/";
    private static final String IMG_SIZE_STANDARD = "w185";

    public static String getAPIKey()
    {
        return API_KEY;
    }
    public static String getBaseUrl() { return BASE_URL; }
    public static String getStandardImgSize() {
        return IMG_SIZE_STANDARD;
    }
}
