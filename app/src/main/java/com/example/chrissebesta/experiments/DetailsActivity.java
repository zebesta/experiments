package com.example.chrissebesta.experiments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        //String plantDataId = intent.getParcelableExtra(getString(R.string.plant_extra_key));
        PlantData plantData = intent.getParcelableExtra(getString(R.string.plant_extra_key));
        DetailsActivityFragment df = new DetailsActivityFragment();

        
//        How to properly load the details activity fragment with the parcelable data - taken from the sunshine example
//        Bundle arguments = new Bundle();
//        arguments.putParcelable(DetailFragment.DETAIL_URI, getIntent().getData());
//        DetailFragment df = new DetailFragment();
//        df.setArguments(arguments);
//
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.weather_detail_container, df)
//                .commit();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
