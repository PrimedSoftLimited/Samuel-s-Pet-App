package com.example.pets;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.pets.data.PetContract.PetEntry;

public class Edit_Text extends AppCompatActivity {

    public EditText petName;
    public EditText petDescription;
    ImageView petImage;
    Button btn;

    //Integer.parseInt("1");
    private  SQLiteDatabase db;

    private DatabaseHelper myDbHelper;
    private int mGender = PetEntry.GENDER_UNKNOWN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        petName = (EditText) findViewById(R.id.pet_edit_name);
        petDescription = (EditText) findViewById(R.id.pet_edit_description);
        petImage = (ImageView) findViewById(R.id.pet_edit_img);

        myDbHelper = new DatabaseHelper(getApplicationContext());


        btn = (Button) findViewById(R.id.save);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertPet();
                finish();
            }
        });
    }



    private Uri insertPet(){

        String nameString = petName.getText().toString().trim();
        String descString = petDescription.getText().toString().trim();
        // added line of code below 54


//        db = myDbHelper.getWritableDatabase();
//
//
        ContentValues values = new ContentValues();

        values.put(PetEntry.COLUMN_NAME, nameString);
        values.put(PetEntry.COLUMN_DESCRIPTION, descString);

        return getContentResolver().insert(PetEntry.CONTENT_URI, values);
//
//        long newRowId = db.insert(PetEntry.TABLE_NAME, null, values);
//
//        if (newRowId == -1){
//            Toast.makeText(this, "Error with saving pet", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "New Pet Saved", Toast.LENGTH_SHORT).show();
//        }
    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     *
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}.
     *
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     *
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     *
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_editor, menu);
        setTitle("Add Pet");
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     *
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
