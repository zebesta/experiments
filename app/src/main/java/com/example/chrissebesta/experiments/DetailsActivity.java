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



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
