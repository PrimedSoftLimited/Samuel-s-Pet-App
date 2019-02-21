package com.example.pets;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pets.data.PetContract.PetEntry;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "petDatabase.db";    // Database Name
    private static final int DATABASE_Version = 1;    // Database Version
    private static final String CREATE_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME + " (" + PetEntry.UID + " INTEGER PRIMARY KEY AUTOINCREMENT," + PetEntry.COLUMN_NAME + " TEXT," + PetEntry.COLUMN_DESCRIPTION + " TEXT)";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;
    private Context context;

    public DatabaseHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_Version);
        this.context = context;
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);

    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);

    }
}
