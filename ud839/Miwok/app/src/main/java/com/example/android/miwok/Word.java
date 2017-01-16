package com.example.android.miwok;


import android.net.Uri;

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
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;


    // int containint sound resource id for word
    private int mSoundForWord;
    /***
     *  Constructs a new word with initial miwok and english translations.
     **/
    public Word(String miwok, String english, int soundOfWord){
        mMiwokTranslation = miwok;
        mDefaultTranslation = english;
        mSoundForWord = soundOfWord;
    }


    /***
     * Constructs a new word with initial miwok to english translation and an image
     * */
    public Word(String miwok, String english, int imageResourceId, int soundOfWord){
        mMiwokTranslation = miwok;
        mDefaultTranslation = english;
        mImageResourceId = imageResourceId;
        mSoundForWord = soundOfWord;
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

    /***
     * Returns whether or not there is an image for this word.
     */
        public boolean hasImage(){
            return mImageResourceId != NO_IMAGE_PROVIDED;
        }

    public int getSoundForWord() {
        return mSoundForWord;
    }

    
}
