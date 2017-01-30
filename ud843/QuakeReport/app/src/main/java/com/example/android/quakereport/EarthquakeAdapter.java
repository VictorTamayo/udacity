package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        Date dateObj = new Date(currentQuake.getTimeInMilliseconds());
        String dateToDisplay = formatDate(dateObj);
        dateTextView.setText(dateToDisplay);

        TextView timeTextView = (TextView)listItemView.findViewById(R.id.time_text_view);
        String timeToDisplay = formatTime(dateObj);
        timeTextView.setText(timeToDisplay);



        return listItemView;
    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
