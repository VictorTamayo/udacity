package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by victo on 1/6/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mBackgroundColor;
    private  MediaPlayer mp;


    /***
     * This is our own custom constructor.
     *
     * @param context   The current context. Used to inflate the layout file.
     * @param words     A List of Word objects to display in a list.
     * */
    public WordAdapter(Context context, ArrayList<Word> words, int ActivityBackGroundColor) {
        super(context,0,words);
        mBackgroundColor = ActivityBackGroundColor;
    }

    /***
     * Provides a view for an AdapterView(ListView, GridView, etc.)
     *
     * @param position     The position in the list of data that should be displayed in the
     *                     list item view.
     * @param convertView  The recycled view to populate.
     * @param parent       The parent ViewGroup that is used for inflating.
     * @return             The View for the position in the AdapterView.
     * */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        parent.setBackgroundColor(mBackgroundColor);
        // Get the {@link Word} object located at this position in the list.
        Word currentWord = getItem(position);

        //find the textview in the list_item.xml
        TextView miwokTextView = (TextView)listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());



        ImageView iconImageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {

            iconImageView.setImageResource(currentWord.getImageResourceId());
            iconImageView.setVisibility(View.VISIBLE);
        }
        else {
            iconImageView.setVisibility(View.GONE);
        }



        // set the theme color for the list
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
