package com.example.chrissebesta.experiments;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.chrissebesta.experiments.database.PlantContract;
import com.example.chrissebesta.experiments.database.PlantDbHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = this.getClass().getSimpleName();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<PlantData> plantDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<String> myDataList = new ArrayList<>();
        //String[] myData = {"Hello", "This", "is a random", "string", "with lots of", "different data with different", "lengths", "to test the way", "recycle view works" };

        for (int i = 0; i < 30; i ++){
            myDataList.add(i, "Im adding an item at index "+ i);
        }

        FetchJSON fetch = new FetchJSON();
        fetch.execute();

    }

//    private void firstRun() {
//        FetchJSON fetch = new FetchJSON();
//        fetch.execute();
//    }


    private class FetchJSON extends AsyncTask<Void, Void, Void> {



        @Override
        protected Void doInBackground(Void... params) {
            String json = null;
            //get JSON from URL
            try {
                /*URL url = new URL("http://harvesthelper.herokuapp.com/api/v1/plants?api_key=e6a6ddffb0a92973921287c8108c256b");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    return null;
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }
                if (buffer.length() == 0) {
                    return null;
                }
                json = buffer.toString();
                Log.d(LOG_TAG, "The returned json is: "+json);*/
                //Process returned JSON
                String fixedJson = getString(R.string.fixedJson);
                Log.d(LOG_TAG, "The fixed json is: "+fixedJson);
                getDataFromJson(fixedJson);
            } catch (JSONException e) {
                Log.e(LOG_TAG, "Could not get data from JSON");
            }
            return null;
        }



        private void getDataFromJson(String returnedJson) throws JSONException {
            //pull data from JSON request response and put in to JSON array
            if (returnedJson.length()==0) {
                Log.d(LOG_TAG, "THE RETURNED JSON ARRAY IS EMPTY!");
            } else {
                PlantDbHelper helper = new PlantDbHelper(getApplicationContext());
                SQLiteDatabase db = helper.getWritableDatabase();
                JSONArray jsonArray = new JSONArray(returnedJson);
                Log.d(LOG_TAG, "The json array has been received!");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Log.d(LOG_TAG, "The json object has been received!");
                    //Pull keys from JSON Object to avoid errors from missing key value pairs
                    Iterator<String> iter = jsonObject.keys();

                    ContentValues cv = new ContentValues();
                    PlantData plantData = new PlantData();
                    while (iter.hasNext()) {
                        String key = iter.next();
                        cv.put(key, jsonObject.get(key).toString());
                        switch(key){
                            case(PlantContract.PlantEntry.id): //"id";
                                plantData.setId(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.name): //"name";
                                plantData.setName(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.description): //"description";
                                plantData.setDescription(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.optimal_sun): //"optimal_sun";
                                plantData.setOptimal_sun(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.optimal_soil): //"optimal_soil";
                                plantData.setOptimal_soil(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.planting_considerations): //"planting_considerations";
                                plantData.setPlanting_considerations(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.when_to_plant): //"when_to_plant";
                                plantData.setWhen_to_plant(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.growing_from_seed): //"growing_from_seed";
                                plantData.setGrowing_from_seed(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.transplanting): //"transplanting";
                                plantData.setTransplanting(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.spacing): //"spacing";
                                plantData.setSpacing(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.watering): //"watering";
                                plantData.setWatering(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.feeding): //"feeding";
                                plantData.setFeeding(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.other_care): //"other_care";
                                plantData.setOther_care(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.diseases): //"diseases";
                                plantData.setDiseases(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.pests): //"pests";
                                plantData.setPests(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.harvesting): //"harvesting";
                                plantData.setHarvesting(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.storage_use): //"storage_use";
                                plantData.setStorage_use(jsonObject.get(key).toString());
                                break;
                            case(PlantContract.PlantEntry.image): //"image";
                                plantData.setImage(jsonObject.get(key).toString());
                                break;
                            default:
                                Log.e(LOG_TAG, "KEY VALUE DOES NOT ALIGN WITH THE EXPECTED VALUES FROM JSON!");

                        }
                    }
                    Log.d(LOG_TAG, "Trying to insert: "+cv.toString());
                    db.insert(PlantContract.PlantEntry.TABLE_NAME, null, cv);
                    cv.clear();
                    plantDataList.add(plantData);
                }
            }

            return;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(getApplicationContext().getString(R.string.pref_previously_started), Boolean.TRUE);
            edit.apply();
            //alphabetize list of gardening
            Collections.sort(plantDataList);
            mAdapter = new MyAdapter(plantDataList, getApplicationContext(), new MyAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(PlantData plantData) {
                    Log.d(LOG_TAG, "You clicked " + plantData.getName());
                    //TODO should actually use a bundle here instead pf parcel, parcel is intended for services?
                    Intent intent = new Intent(MainActivity.this, SimpleDetailsActivity.class);
                    intent.putExtra(getString(R.string.plant_extra_key), plantData);
                    startActivity(intent);
                }
            });
            mRecyclerView.setAdapter(mAdapter);
            for(int i = 0; i< plantDataList.size(); i ++){
                Log.d(LOG_TAG, "The plant at index "+ i + "is: "+plantDataList.get(i).getName());
            }
        }
    }
}
