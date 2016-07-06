package com.example.chrissebesta.experiments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class DetailsActivity extends AppCompatActivity {

    private final String LOG_TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //Intent intent = getIntent();
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.home:
                Log.d(LOG_TAG, "Overided home button called");
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                return true;
            case 16908332:
                Log.d(LOG_TAG, "Overided home hacked button called");
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            default:
                Log.d(LOG_TAG, ""+item.getItemId()+ " was clicked");
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(LOG_TAG, "Overided back button called");
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
