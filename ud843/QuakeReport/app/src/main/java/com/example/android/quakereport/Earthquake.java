package com.example.android.quakereport;

/**
 * Created by victo on 1/24/2017.
 */

public class Earthquake {

    // Magnitude of the Earthquake
    private double mMagnituted;
    // Location of the Earthquake
    private String mLocation;
    // Date of the Earthquake
    private long mTimeInMilliseconds
            ;


    /***
     * Constructs a new {@link Earthquake} object
     *
     * @param magnituted is the magnitude of the earthquake
     * @param location  is the city location of the earthquake
     * @param timeInMilliseconds  is the date the earthquake happened
     * */
    public Earthquake(double magnituted, String location, long timeInMilliseconds){
        mMagnituted = magnituted;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
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
}
