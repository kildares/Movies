package com.example.kilda.movies.utilities;

import com.example.kilda.movies.Movies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kilda on 2/13/2018.
 */

public class MoviesJsonUtils {

    private static final String results = "results";
    private static final String RELEASE_DATE = "release_date";
    private static final String NAME = "title";
    private static final String SYNOPSIS = "overview";
    private static final String IMAGE_PATH = "poster_path";
    private static final String ID = "id";
    private static final String AVG = "vote_average";

    public static Movies[] parseJSonToMovies(String jsonStr)
    {
        try {
            JSONObject json = new JSONObject(jsonStr);

            JSONArray jsonArray = json.getJSONArray(MoviesJsonUtils.results);

            Movies[] Movies = new Movies[jsonArray.length()];

            for(int i=0 ; i < jsonArray.length() ; i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String name = jsonObject.getString(MoviesJsonUtils.NAME);
                String year = jsonObject.getString(MoviesJsonUtils.RELEASE_DATE);
                String synopsis = jsonObject.getString(MoviesJsonUtils.SYNOPSIS);
                String image = jsonObject.getString(MoviesJsonUtils.IMAGE_PATH);
                String id = jsonObject.getString(MoviesJsonUtils.ID);
                String avg = jsonObject.getString(MoviesJsonUtils.AVG);

                Movies[i] = new Movies(id,name, year, image, synopsis,avg);
            }
            return Movies;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
