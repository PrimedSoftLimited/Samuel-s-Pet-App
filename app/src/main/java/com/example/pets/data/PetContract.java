package com.example.pets.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class PetContract {

    private PetContract(){}

    public static final String PATH_PETS = "pets";

    public static final class PetEntry implements BaseColumns {

        public static final String TABLE_NAME = "petTable";   // Table Name

        public static final String UID = BaseColumns._ID;     // Column I (Primary Key)
        public static final String COLUMN_NAME = "Name";    //Column II
        public static final String COLUMN_DESCRIPTION = "Description"; // Column III
        public static final String COLUMN_IMAGE = "Image"; // Column IV

        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public static final String CONTENT_AUTHORITY = "com.example.pets";
        public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

        /**
         * Possible values for the gender of the animals
         */

        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
    }
}
