package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 *  It contains a default translation and a Miwok translation for that word.
 */


public class Word {

    // String Miwok word
    private String mMiwokTranslation;

    //  String English Word
    private String mDefaultTranslation;

    // int containing img resource id
    private int mImageResourceId;

    /***
     *  Constructs a new word with initial miwok and english translations.
     **/
    public Word(String miwok, String english){
        mMiwokTranslation = miwok;
        mDefaultTranslation = english;
    }


    /***
     * Constructs a new word with initial miwok to english translation and an image
     * */
    public Word(String miwok, String english, int imageResourceId){
        mMiwokTranslation = miwok;
        mDefaultTranslation = english;
        mImageResourceId = imageResourceId;
    }

    // Get the Miwok translation of the word.
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    //Get the default translation of the word.
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
