package com.example.kilda.movies.utilities;

import android.net.Uri;

import com.example.kilda.movies.TmdbApi;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kilda on 2/12/2018.
 */

public class NetworkUtils {

    public static URL buildURL(String location)
    {
        Uri builtUri = Uri.parse(TmdbApi.getBaseUrl() + TmdbApi.getStandardImgSize()).buildUpon().build();
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
