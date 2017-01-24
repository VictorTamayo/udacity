package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by victo on 1/24/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /***
     * This is our own custom constructor
     * @param context The current context. Used to inflate the layout file.
     * @param earthquakes A List of Earthquake objects to diaplay in a list
     */
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes){
        super(context,0, earthquakes);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Earthquake} object located at this position in the list.
        Earthquake currentQuake = getItem(position);

        TextView magnitudeTextView = (TextView)listItemView.findViewById(R.id.magnitute_text_view);
        magnitudeTextView.setText(String.valueOf(currentQuake.getMagnituted()));

        TextView locationTextView = (TextView)listItemView.findViewById(R.id.location_text_view);
        locationTextView.setText(currentQuake.getLocation());

        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(String.valueOf(currentQuake.getDate()));



        return listItemView;
    }
}
