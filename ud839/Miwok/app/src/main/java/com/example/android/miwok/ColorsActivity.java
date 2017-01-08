package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Word> colors = new ArrayList<Word>();
        colors.add(new Word("red","wetetti"));
        colors.add(new Word("green","chokokki"));
        colors.add(new Word("brown","takaakki"));
        colors.add(new Word("gray","topoppi"));
        colors.add(new Word("black","kululli"));
        colors.add(new Word("white","kelelli"));
        colors.add(new Word("dusty yellow","topiisә"));
        colors.add(new Word("mustard yellow","chiwiitә"));

        WordAdapter itemAdapter = new WordAdapter(this,colors);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemAdapter);
    }
}
