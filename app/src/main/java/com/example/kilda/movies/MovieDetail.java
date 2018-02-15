package com.example.kilda.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kilda.movies.utilities.NetworkUtils;
import com.squareup.picasso.Picasso;


public class MovieDetail extends AppCompatActivity{

    private ImageView MovieImg;
    private TextView tvName;
    private TextView tvYear;
    private TextView tvSynopsis;
    private TextView tvAverage;

    Movies detailedMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_movie_detail);

        this.MovieImg = (ImageView)findViewById(R.id.iv_detail_poster);
        this.tvName = (TextView) findViewById(R.id.tv_detail_name);
        this.tvYear = (TextView) findViewById(R.id.tv_detail_year);
        this.tvSynopsis = (TextView) findViewById(R.id.tv_detail_synopsis);
        this.tvAverage = (TextView) findViewById(R.id.tv_vote_avg);

        Intent intent = getIntent();
        Bundle bdl = intent.getExtras();
        String name = bdl.getString("name");
        String synopsis = bdl.getString("synopsis");
        String year = bdl.getString("year");
        String img = bdl.getString("img");
        String id = bdl.getString("id");
        String avg = bdl.getString("avg");
        this.tvName.setText(name);
        this.tvYear.setText(year);
        this.tvSynopsis.setText(synopsis);
        this.tvAverage.setText(avg);

        detailedMovie = new Movies(id,year,year,img,synopsis,avg);

        Picasso.with(MovieDetail.this).load(TmdbApi.getImageUrl(img)).into(this.MovieImg);

    }

}
