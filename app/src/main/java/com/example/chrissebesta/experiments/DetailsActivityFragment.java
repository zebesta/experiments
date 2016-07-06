package com.example.chrissebesta.experiments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsActivityFragment extends android.app.Fragment {

    private final String LOG_TAG = this.getClass().getSimpleName();
    PlantData plantData = new PlantData("12", "Click a plant for additional information!", "description", "sunlght!", null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    public DetailsActivityFragment() {
        Log.d(LOG_TAG, "Details Activity Fragment constructor is called for "+plantData.getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
//        Button wikipediaButton = (Button) rootView.findViewById(R.id.wikipedia_button);
//        wikipediaButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //TODO plants with problems for this cheesy hack: Beans, Mint, Sage
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
//                browserIntent.setData(Uri.parse("https://en.m.wikipedia.org/wiki/"+plantData.getName().toLowerCase()));
//                startActivity(browserIntent);
//            }
//        });
        ImageButton wikipediaImageButton = (ImageButton) rootView.findViewById(R.id.wikipedia_image_button);
        wikipediaImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO plants with problems for this cheesy hack: Beans, Mint, Sage
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://en.m.wikipedia.org/wiki/"+plantData.getName().toLowerCase()));
                startActivity(browserIntent);
            }
        });
        TextView tv = (TextView) rootView.findViewById(R.id.details_text_view_for_name);

        Bundle arguments = getArguments();
        if (arguments != null) {
            Log.d(LOG_TAG, "Populating the plant data based on the passed in plant data.");
            plantData = arguments.getParcelable(getString(R.string.plant_extra_key));
//            wikipediaButton.setVisibility(View.VISIBLE);
            wikipediaImageButton.setVisibility(View.VISIBLE);
        }

        tv.setText("Dynamically adjusting text!");
        tv.setText(plantData.getName());

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
        TextView additionalInformationTextView = (TextView) rootView.findViewById(R.id.details_fragment_additional_information);
        additionalInformationTextView.setText(additionalInformation);

//        TextView detailsName = (TextView) container.findViewById(R.id.details_text_view_for_name);
//        detailsName.setText("LOADING THE FRAGMENT RIGHT!");
        //View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//        setContentView(R.layout.fragment_details);

        //TODO find a way to pass the parceled up plant data to this, or just construct it?
//        Intent intent = getIntent();
//        plantData = intent.getParcelableExtra(getString(R.string.plant_extra_key));

//        ImageView imageView = (ImageView) container.findViewById(R.id.simple_details_image);
//        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
//        Display display = wm.getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        int mScreenWidth = size.x;
//        int mScreenHeight = size.y;
////        Picasso.with(getContext())
////                .load(plantData.getImage())
////                .resize(Math.min(mScreenWidth, mScreenHeight), Math.min(mScreenWidth, mScreenHeight))
////                .centerCrop()
////                .into(imageView);
//        TextView nameTextView = (TextView) container.findViewById(R.id.simple_details_text_view_for_name);
//        //nameTextView.setText(plantData.getName());
//        nameTextView.setText("Test plant");
//        TextView descriptionTextView = (TextView) container.findViewById(R.id.simple_details_text_view_for_description);
//        //descriptionTextView.setText("Description: " + plantData.getDescription());
//        descriptionTextView.setText("Description: ");
//        TextView optimalSunTextView = (TextView) container.findViewById(R.id.simple_details_text_view_for_optimal_sun);
////        optimalSunTextView.setText("Optimal sun: " + plantData.getOptimal_sun());
//        optimalSunTextView.setText("Optimal sun: " );
//
//
//        String additionalInformation = "";
//        if(plantData.getOptimal_soil()!=null){
//            additionalInformation += "\nOptimal soil: "+plantData.getOptimal_soil()+"\n";
//        }
//        if(plantData.getPlanting_considerations()!=null){
//            additionalInformation +="\nPlanting considerations: "+plantData.getPlanting_considerations()+"\n";
//        }
//        if(plantData.getWhen_to_plant()!=null){
//            additionalInformation +="\nWhen to plant: "+plantData.getWhen_to_plant()+"\n";
//
//        }
//        if(plantData.getGrowing_from_seed()!=null){
//            additionalInformation +="\nGrowing from seed: "+plantData.getGrowing_from_seed()+"\n";
//
//        }
//        if(plantData.getTransplanting()!=null){
//            additionalInformation +="\nTransplanting: "+plantData.getTransplanting()+"\n";
//
//        }
//        if(plantData.getSpacing()!=null){
//            additionalInformation +="\nSpacing: "+plantData.getSpacing()+"\n";
//
//        }
//        if(plantData.getWatering()!=null){
//            additionalInformation +="\nWatering: "+plantData.getWatering()+"\n";
//
//        }
//        if(plantData.getFeeding()!=null){
//            additionalInformation +="\nFeeding: "+plantData.getFeeding()+"\n";
//
//        }
//        if(plantData.getOther_care()!=null){
//            additionalInformation +="\nOther care: "+plantData.getOther_care()+"\n";
//
//        }
//        if(plantData.getDiseases()!=null){
//            additionalInformation +="\nDiseases: "+plantData.getDiseases()+"\n";
//
//        }
//        if(plantData.getPests()!=null){
//            additionalInformation +="\nPests: "+plantData.getPests()+"\n";
//
//        }
//        if(plantData.getHarvesting()!=null){
//            additionalInformation +="\nHarvesting: "+plantData.getHarvesting()+"\n";
//
//        }
//        if(plantData.getStorage_use()!=null){
//            additionalInformation +="\nStorage use: "+plantData.getStorage_use()+"\n";
//
//        }
//        TextView additionalInformationTextView = (TextView) container.findViewById(R.id.simple_details_additional_information);
//        additionalInformationTextView.setText(additionalInformation);
//        Log.d(LOG_TAG, "Additional information is: " + additionalInformation);
//
//        Log.d(LOG_TAG, plantData.getDescription());

        return rootView;
    }
}
