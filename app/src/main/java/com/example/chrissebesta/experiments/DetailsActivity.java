package com.example.chrissebesta.experiments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class DetailsActivity extends AppCompatActivity {

    private final String LOG_TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        //String plantDataId = intent.getParcelableExtra(getString(R.string.plant_extra_key));
        //PlantData plantData = intent.getParcelableExtra(getString(R.string.plant_extra_key));
        //DetailsActivityFragment df = new DetailsActivityFragment();

//        How to properly load the details activity fragment with the parcelable data - taken from the sunshine example
        Bundle arguments = new Bundle();
        arguments.putParcelable(getString(R.string.plant_extra_key), getIntent().getParcelableExtra(getString(R.string.plant_extra_key)));
        Log.d(LOG_TAG, "Adding arguments to the details fragment");
        DetailsActivityFragment df = new DetailsActivityFragment();
        df.setArguments(arguments);

//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.plant_details_container, df)
//                .commit();
        getFragmentManager().beginTransaction()
                .replace(R.id.plant_details_container, df, MainActivity.DETAILFRAGMENT_TAG)
                .commit();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
