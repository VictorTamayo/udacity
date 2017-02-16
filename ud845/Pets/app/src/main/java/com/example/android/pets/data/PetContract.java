package com.example.android.pets.data;

import android.provider.BaseColumns;

/**
 * Defines table and column names for the weather database.
 */

public final class PetContract {

    /* Inner class that defines the table contents of the pets table */
    public static final class PetEntry implements BaseColumns{
        //Table name
        public static final String TABLE_NAME = "pets";

        // pet id as incremented by the db
        public static final String _ID =BaseColumns._ID;
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_BREED = "breed";
        public static final String COLUMN_PET_GENDER = "gender";
        public static final String COLUMN_PET_WEIGHT = "weight";

        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
    }
}
