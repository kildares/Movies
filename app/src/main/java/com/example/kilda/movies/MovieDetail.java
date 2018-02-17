package com.example.kilda.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MovieDetail extends AppCompatActivity{

    private ImageView MovieImg;
    private TextView tvName;
    private TextView tvYear;
    private TextView tvSynopsis;
    private TextView tvAverage;

    private Movies detailedMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_movie_detail);

        this.MovieImg = findViewById(R.id.iv_detail_poster);
        this.tvName = findViewById(R.id.tv_detail_name);
        this.tvYear = findViewById(R.id.tv_detail_year);
        this.tvSynopsis = findViewById(R.id.tv_detail_synopsis);
        this.tvAverage = findViewById(R.id.tv_vote_avg);

        Intent intent = getIntent();
        Bundle bdl = intent.getExtras();
        try{
            String name = bdl.getString("name");
            String synopsis = bdl.getString("synopsis");
            String year = bdl.getString("year");
            String img = bdl.getString("img");
            String id = bdl.getString("id");
            String avg = bdl.getString("avg");
            this.tvName.setText(name);
            this.tvYear.setText(formatTvYear(year));
            this.tvSynopsis.setText(synopsis);
            this.tvAverage.setText(avg);

            detailedMovie = new Movies(id,year,year,img,synopsis,avg);

            Picasso.with(MovieDetail.this).load(TmdbApi.getImageUrl(img)).into(this.MovieImg);
        }catch(NullPointerException e){
            e.printStackTrace();
            Intent intent1 = new Intent(MovieDetail.this,MainActivity.class);
            startActivity(intent);
        }

    }

    private String formatTvYear(String dateStr)
    {
        String year = dateStr.substring(0,4);
        String month = dateStr.substring(5,7);
        String day = dateStr.substring(8,10);
        return month+"/"+day+"/"+year;
    }
}
