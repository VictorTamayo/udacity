package com.example.android.quakereport;

/**
 * Created by victo on 1/24/2017.
 */

public class Earthquakes {

    private float mMagnituted;

    private String mLocation;

    private long mTime;


    public Earthquakes(float magnituted, String location, long time){
        mMagnituted = magnituted;
        mLocation = location;
        mTime = time;
    }

    public float getMagnituted() {
        return mMagnituted;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTime() {
        return mTime;
    }
}
