package com.example.android.quakereport;

import java.net.URL;

/**
 * Created by victo on 1/24/2017.
 */

public class Earthquake {

    // Magnitude of the Earthquake
    private double mMagnituted;
    // Location of the Earthquake
    private String mLocation;
    // Date of the Earthquake
    private long mTimeInMilliseconds;
    // url of the usgs website
    private String mUrl;


    /***
     * Constructs a new {@link Earthquake} object
     *
     * @param magnituted is the magnitude of the earthquake
     * @param location  is the city location of the earthquake
     * @param timeInMilliseconds  is the date the earthquake happened
     *  @param url is the website URL to find more details about the earthquake
     * */
    public Earthquake(double magnituted, String location, long timeInMilliseconds, String url){
        mMagnituted = magnituted;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    // Returns the magnitude of the earthquake
    public double getMagnituted() {
        return mMagnituted;
    }

    // Returns the city location of the earthquake
    public String getLocation() {
        return mLocation;
    }

    // Returns the date of the earthquake
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    @Override
    public String toString() {
        return "Earthquake{"+
                "mMagnituted='" + mMagnituted+ '\'' +
                ", mLocation='" +mLocation + '\'' +
                ", mTimeInMilliseconds=" + mTimeInMilliseconds +'}';
    }

    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }
}
