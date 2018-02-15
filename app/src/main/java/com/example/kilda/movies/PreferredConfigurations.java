package com.example.kilda.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PreferredConfigurations extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spMovieOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferred_configurations);

        spMovieOrder = (Spinner) findViewById(R.id.sp_movie_order);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.movies_order,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spMovieOrder.setAdapter(adapter);

        spMovieOrder.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(i==0)
            TmdbApi.SetTopRated(true);
        else
            TmdbApi.SetTopRated(false);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
