package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    ArrayList<String> mWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        mWords = new ArrayList<String>();
        mWords.add("One");
        mWords.add("Two");
        mWords.add("Three");
        mWords.add("Four");
        mWords.add("Five");
        mWords.add("Six");
        mWords.add("Seven");
        mWords.add("Eight");
        mWords.add("Nine");
        mWords.add("Ten");

        //find the root view for the whole layout

        ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mWords);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemAdapter);
    }


}
