package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
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

        DecimalFormat formatter = new DecimalFormat("0.0");
        String magFormatted = formatter.format(currentQuake.getMagnituted());

        TextView magnitudeTextView = (TextView)listItemView.findViewById(R.id.magnitute_text_view);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnituted());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        magnitudeTextView.setText(String.valueOf(magFormatted));


        // Get the current location
        String location = currentQuake.getLocation();

        // Find the location offset
        int offsetIndex =location.indexOf("of");
        String offssetLocation = "";
        if (offsetIndex == -1){
          offssetLocation = this.getContext().getResources().getString(R.string.near_the);

    }else{

        // Get offset location string
        offssetLocation = location.substring(0, offsetIndex+2);
    }


        //Get primary location string
        String primaryLocation = location.substring(offsetIndex+3,location.length() )
                ;
        TextView locationOffsetTextView = (TextView)listItemView.findViewById(R.id.location_offset_text_view);
        locationOffsetTextView.setText(offssetLocation);

        TextView locationPrimaryTextView = (TextView)listItemView.findViewById(R.id.location_primary_text_view);
        locationPrimaryTextView.setText(primaryLocation);


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
     *
     * @param magnituded the value of the earthquake
     * @return color intensity of the magnitude
     */
    private int getMagnitudeColor(double magnituded) {
        int magnitudeColorResourceId = 0;
        int  mag = (int)Math.floor(magnituded);

        switch (mag){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
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
