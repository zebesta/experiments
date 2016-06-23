package com.example.chrissebesta.experiments.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by chrissebesta on 6/23/16.
 */
public class PlantDbHelper extends SQLiteOpenHelper {
    public final String LOG_TAG = this.getClass().getSimpleName();
    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "plant.db";

    public PlantDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d(LOG_TAG, "Creating database");
        final String SQL_CREATE_PLANT_TABLE = "CREATE TABLE " + PlantContract.PlantEntry.TABLE_NAME + " (" +
                PlantContract.PlantEntry._ID + " INTEGER PRIMARY KEY," +
                PlantContract.PlantEntry.id + " TEXT NOT NULL, " +
                PlantContract.PlantEntry.name + " TEXT NOT NULL UNIQUE, " +
                PlantContract.PlantEntry.description + " TEXT NOT NULL, " +
                PlantContract.PlantEntry.optimal_sun + " TEXT NOT NULL, " +
                PlantContract.PlantEntry.optimal_soil + " TEXT NOT NULL, " +
                PlantContract.PlantEntry.planting_considerations + " TEXT, " +
                PlantContract.PlantEntry.when_to_plant + " TEXT, " +
                PlantContract.PlantEntry.growing_from_seed + " TEXT, " +
                PlantContract.PlantEntry.transplanting + " TEXT, " +
                PlantContract.PlantEntry.spacing + " TEXT, " +
                PlantContract.PlantEntry.watering + " TEXT, " +
                PlantContract.PlantEntry.feeding + " TEXT, " +
                PlantContract.PlantEntry.other_care + " TEXT, " +
                PlantContract.PlantEntry.diseases + " TEXT, " +
                PlantContract.PlantEntry.pests + " TEXT, " +
                PlantContract.PlantEntry.harvesting + " TEXT, " +
                PlantContract.PlantEntry.storage_use + " TEXT, " +
                PlantContract.PlantEntry.image + " TEXT NOT NULL UNIQUE" + ");";

        Log.d(LOG_TAG, "Executing "+ SQL_CREATE_PLANT_TABLE);

        db.execSQL(SQL_CREATE_PLANT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PlantContract.PlantEntry.TABLE_NAME);
        onCreate(db);
    }
}
