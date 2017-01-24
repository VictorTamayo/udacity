package com.example.android.quakereport;

/**
 * Created by victo on 1/24/2017.
 */

public class Earthquake {

    private float mMagnituted;

    private String mLocation;

    private long mDate;


    public Earthquake(float magnituted, String location, long date){
        mMagnituted = magnituted;
        mLocation = location;
        mDate = date;
    }

    public float getMagnituted() {
        return mMagnituted;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getDate() {
        return mDate;
    }

    @Override
    public String toString() {
        return "Earthquake{"+
                "mMagnituted='" + mMagnituted+ '\'' +
                ", mLocation='" +mLocation + '\'' +
                ", mDate=" + mDate +'}';
    }
}
