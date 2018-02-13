package com.example.kilda.movies;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kilda on 2/8/2018.
 */

public class TmdbApi {

    private static final String API_KEY = BuildConfig.TMDB_API_KEY;
    private static final String LANGUAGE = "en-US";
    private static final String PAGE = "1";
    private static final String REGION = "Brazil";
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private static final String IMG_SIZE_STANDARD = "w185";
    private static final String API_KEY_URL = "api_key";
    private static final String LANGUAGE_URL = "language";
    private static final String PAGE_URL = "page";
    private static final String REGION_URL = "region";
    private static final String POPULAR_URL = "popular";
    private static final String TOP_RATED_URL = "top_rated";

    private static Boolean IS_TOP_RATED = false;

    public static void SetTopRated(Boolean b){
        TmdbApi.IS_TOP_RATED = b;
    }

    public static Boolean IsTopRated()
    {
        return IS_TOP_RATED;
    }

    public static URL buildTopRatedRequestURL()
    {
        Uri builtUri = Uri.parse(BASE_URL + TOP_RATED_URL).buildUpon().appendQueryParameter(API_KEY_URL, API_KEY).
                appendQueryParameter(LANGUAGE_URL,LANGUAGE).
                appendQueryParameter(PAGE,PAGE_URL).
                appendQueryParameter(REGION_URL,REGION)
                .build();
        URL url = null;
        try{
            url = new URL(builtUri.toString());
        } catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        return url;
    }

    public static URL buildPopularRequestURL()
    {
        Uri builtUri = Uri.parse(BASE_URL + POPULAR_URL).buildUpon().appendQueryParameter(API_KEY_URL, API_KEY).
                appendQueryParameter(LANGUAGE_URL,LANGUAGE).
                appendQueryParameter(PAGE,PAGE_URL).
                appendQueryParameter(REGION_URL,REGION)
                .build();
        URL url = null;
        try{
            url = new URL(builtUri.toString());
        } catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        return url;
    }

    public static URL buildAuthRequest()
    {
        Uri builtUri = Uri.parse(BASE_URL).buildUpon().appendQueryParameter(API_KEY_URL,API_KEY).build();
        URL url = null;
        try{
            url = new URL(builtUri.toString());
        } catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        return url;
    }

}
