package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
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
        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        //add textviews with each element of the words array
        for(String word : mWords) {
            TextView r = new TextView(this);
            r.setText(word);
            rootView.addView(r);
        }

    }


}
