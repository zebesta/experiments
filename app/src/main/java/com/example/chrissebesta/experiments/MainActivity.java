package com.example.chrissebesta.experiments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
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
    }
}
