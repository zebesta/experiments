package com.example.chrissebesta.experiments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.chrissebesta.experiments.database.PlantContract;
import com.example.chrissebesta.experiments.database.PlantDbHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = this.getClass().getSimpleName();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<String> myDataList = new ArrayList<>();
        //String[] myData = {"Hello", "This", "is a random", "string", "with lots of", "different data with different", "lengths", "to test the way", "recycle view works" };

        for (int i = 0; i < 30; i ++){
            myDataList.add(i, "Im adding an item at index "+ i);
        }

        mAdapter = new MyAdapter(myDataList);
        mRecyclerView.setAdapter(mAdapter);
        FetchJSON fetch = new FetchJSON();
        fetch.execute();
    }


    private class FetchJSON extends AsyncTask<Void, Void, Void> {



        @Override
        protected Void doInBackground(Void... params) {
            String json = null;
            //get JSON from URL
            try {
                URL url = new URL("http://http://harvesthelper.herokuapp.com/api/v1/plants?api_key=e6a6ddffb0a92973921287c8108c256b");
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
                Log.d(LOG_TAG, "The returned json is: "+json);
                //Process returned JSON
                String fixedJson = getString(R.string.fixedJson);
                Log.d(LOG_TAG, "The fixed json is: "+fixedJson);
                getDataFromJson(fixedJson);
            } catch (IOException e) {
                e.printStackTrace();
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
                    while (iter.hasNext()) {
                        String key = iter.next();
                        cv.put(key, jsonObject.get(key).toString());
                    }
                    Log.d(LOG_TAG, "Trying to insert: "+cv.toString());
                    db.insert(PlantContract.PlantEntry.TABLE_NAME, null, cv);
                    cv.clear();
                }
            }

            return;
        }
    }
}
