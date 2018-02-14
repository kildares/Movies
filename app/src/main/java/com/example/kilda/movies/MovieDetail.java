package com.example.kilda.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MovieDetail extends AppCompatActivity {

    private ImageView MovieImg;
    private ImageButton btLike;
    private ImageButton btDisLike;
    private TextView tvName;
    private TextView tvYear;
    private TextView tvSynopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_movie_detail);

        this.MovieImg = (ImageView)findViewById(R.id.iv_detail_poster);
        this.btLike = (ImageButton)findViewById(R.id.ib_like);
        this.btDisLike = (ImageButton)findViewById(R.id.ib_dislike);
        this.tvName = (TextView) findViewById(R.id.tv_detail_name);
        this.tvYear = (TextView) findViewById(R.id.tv_detail_year);
        this.tvSynopsis = (TextView) findViewById(R.id.tv_detail_synopsis);

        Intent intent = getIntent();
        Bundle bdl = intent.getExtras();
        String name = bdl.getString("name");
        String synopsis = bdl.getString("synopsis");
        String year = bdl.getString("year");
        String img = bdl.getString("img");
        this.tvName.setText(name);
        this.tvYear.setText(year);
        this.tvSynopsis.setText(synopsis);

        Picasso.with(MovieDetail.this).load(TmdbApi.getImageUrl(img)).into(this.MovieImg);

    }
}
