package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One","lutti",R.drawable.number_one));
        words.add(new Word("Two","otiiko",R.drawable.number_two));
        words.add(new Word("Three","tolookosu",R.drawable.number_three));
        words.add(new Word("Four","oyyisa",R.drawable.number_four));
        words.add(new Word("Five","massokka",R.drawable.number_five));
        words.add(new Word("Six","temmokka",R.drawable.number_six));
        words.add(new Word("Seven","kenekaku",R.drawable.number_seven));
        words.add(new Word("Eight","kawinta",R.drawable.number_eight));
        words.add(new Word("Nine","wo'e",R.drawable.number_nine));
        words.add(new Word("Ten","na'aacha",R.drawable.number_ten));

        //find the root view for the whole layout

        WordAdapter itemAdapter = new WordAdapter(this,words);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemAdapter);
    }


}
