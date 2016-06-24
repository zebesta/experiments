package com.example.chrissebesta.experiments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

        ImageView imageView = (ImageView) findViewById(R.id.simple_details_image);
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int mScreenWidth = size.x;
        int mScreenHeight = size.y;
        Picasso.with(getApplicationContext())
                .load(plantData.getImage())
                .resize(Math.min(mScreenWidth, mScreenHeight), Math.min(mScreenWidth, mScreenHeight))
                .centerCrop()
                .into(imageView);
        TextView nameTextView = (TextView) findViewById(R.id.simple_details_text_view_for_name);
        nameTextView.setText(plantData.getName());
        TextView descriptionTextView = (TextView) findViewById(R.id.simple_details_text_view_for_description);
        descriptionTextView.setText("Description: " + plantData.getDescription());
        TextView optimalSunTextView = (TextView) findViewById(R.id.simple_details_text_view_for_optimal_sun);
        optimalSunTextView.setText("Optimal sun: " + plantData.getOptimal_sun());

        String additionalInformation = "";
        if(plantData.getOptimal_soil()!=null){
            additionalInformation += "\nOptimal soil: "+plantData.getOptimal_soil()+"\n";
        }
        if(plantData.getPlanting_considerations()!=null){
            additionalInformation +="\nPlanting considerations: "+plantData.getPlanting_considerations()+"\n";
        }
        if(plantData.getWhen_to_plant()!=null){
            additionalInformation +="\nWhen to plant: "+plantData.getWhen_to_plant()+"\n";

        }
        if(plantData.getGrowing_from_seed()!=null){
            additionalInformation +="\nGrowing from seed: "+plantData.getGrowing_from_seed()+"\n";

        }
        if(plantData.getTransplanting()!=null){
            additionalInformation +="\nTransplanting: "+plantData.getTransplanting()+"\n";

        }
        if(plantData.getSpacing()!=null){
            additionalInformation +="\nSpacing: "+plantData.getSpacing()+"\n";

        }
        if(plantData.getWatering()!=null){
            additionalInformation +="\nWatering: "+plantData.getWatering()+"\n";

        }
        if(plantData.getFeeding()!=null){
            additionalInformation +="\nFeeding: "+plantData.getFeeding()+"\n";

        }
        if(plantData.getOther_care()!=null){
            additionalInformation +="\nOther care: "+plantData.getOther_care()+"\n";

        }
        if(plantData.getDiseases()!=null){
            additionalInformation +="\nDiseases: "+plantData.getDiseases()+"\n";

        }
        if(plantData.getPests()!=null){
            additionalInformation +="\nPests: "+plantData.getPests()+"\n";

        }
        if(plantData.getHarvesting()!=null){
            additionalInformation +="\nHarvesting: "+plantData.getHarvesting()+"\n";

        }
        if(plantData.getStorage_use()!=null){
            additionalInformation +="\nStorage use: "+plantData.getStorage_use()+"\n";

        }
        TextView additionalInformationTextView = (TextView) findViewById(R.id.simple_details_additional_information);
        additionalInformationTextView.setText(additionalInformation);
        Log.d(LOG_TAG, "Additional information is: " + additionalInformation);

        Log.d(LOG_TAG, plantData.getDescription());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(plantData.getName());
    }

}
