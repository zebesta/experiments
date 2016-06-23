package com.example.chrissebesta.experiments.database;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by chrissebesta on 6/23/16.
 */
public class PlantContract {
    public static final String CONTENT_AUTHORITY = "com.example.android.travology.app";

    // Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
    // the content provider.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Possible paths (appended to base content URI for possible URI's)
    // For instance, content://com.example.android.sunshine.app/weather/ is a valid path for
    // looking at weather data. content://com.example.android.sunshine.app/givemeroot/ will fail,
    // as the ContentProvider hasn't been given any information on what to do with "givemeroot".
    // At least, let's hope not.  Don't be that dev, reader.  Don't be that dev.
    public static final String PATH_PLANT = "plant";


    public PlantContract() {
    }

    public static final class PlantEntry implements BaseColumns {

        //public static final Strings provided by API for JSON parsing

        public static final String TABLE_NAME = "plant";
        public static final String id = "id";
        public static final String name = "name";
        public static final String description = "description";
        public static final String optimal_sun = "optimal_sun";
        public static final String optimal_soil = "optimal_soil";
        public static final String planting_considerations = "planting_considerations";
        public static final String when_to_plant = "when_to_plant";
        public static final String growing_from_seed = "growing_from_seed";
        public static final String transplanting = "transplanting";
        public static final String spacing = "spacing";
        public static final String watering = "watering";
        public static final String feeding = "feeding";
        public static final String other_care = "other_care";
        public static final String diseases = "diseases";
        public static final String pests = "pests";
        public static final String harvesting = "harvesting";
        public static final String storage_use = "storage_use";
        public static final String image = "image";

    }
}
