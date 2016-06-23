package com.example.chrissebesta.experiments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

public class SimpleDetailsActivity extends AppCompatActivity {

    private final String LOG_TAG = SimpleDetailsActivity.this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        PlantData plantData = intent.getParcelableExtra(getString(R.string.plant_extra_key));

        TextView description = (TextView) findViewById(R.id.simple_details_text_view_for_description);
        description.setText(plantData.getDescription());
        Log.d(LOG_TAG, plantData.getDescription());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
