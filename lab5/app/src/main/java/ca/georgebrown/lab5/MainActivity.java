package ca.georgebrown.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    //if we want to actually start working with the database we need to
    // initialize in the activity we are going to use.
    NameDbHelper dbHelper;
    SQLiteDatabase db;


    //adding some values to the database, we will get the database as a parameter.
    void initDatabase(SQLiteDatabase db){
        ContentValues values = new ContentValues();
        //first row.
        values.put(NameContract.NameEntry.COLUMN_NAME_NAME, "Jhon");
        long rowId = db.insert(NameContract.NameEntry.TABLE_NAME, null, values);
        Log.d("DATABASE", "Row added with _ID="+rowId);

        values = new ContentValues();
        //second row.
        values.put(NameContract.NameEntry.COLUMN_NAME_NAME, "James");
        rowId = db.insert(NameContract.NameEntry.TABLE_NAME, null, values);
        Log.d("DATABASE", "Row added with _ID="+rowId);
    }

    //checkout how new rows can handle the database.
    int getNameCount(SQLiteDatabase bd){
        String query = "SELECT COUNT(*) as CNT FROM "+NameContract.NameEntry.TABLE_NAME;
        //row query allows to run swl query, returns a cursor.
        Cursor c = db.rawQuery(query,null);
        while(c.moveToNext()){
            int idx = c.getColumnIndex("CNT");
            if(idx == -1){
                Log.e("DATABASE ERROR", "CNT does not exist in the database");
                return 0;
            }
            int cnt =  c.getInt(idx);
            return cnt;
        }
        return 0;
    }
    List<NameEntity> getNames(SQLiteDatabase db){
        List<NameEntity> list = new ArrayList<>();

        String[] projection ={
                NameContract.NameEntry._ID,
                NameContract.NameEntry.COLUMN_NAME_NAME
        };

        Cursor c = db.query(NameContract.NameEntry.TABLE_NAME,
                projection, null, null, null,
                null, null);
        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndexOrThrow(NameContract.NameEntry._ID));
            String name = c.getString(c.getColumnIndexOrThrow(NameContract.NameEntry.COLUMN_NAME_NAME));
            NameEntity item = new NameEntity(name, id);
            list.add(item);
        }

        return list;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up the helper in order to get the database.
        dbHelper = new NameDbHelper( this);
        db = dbHelper.getWritableDatabase();
        //database base should be created at this point.

        if(getNameCount(db)==0) {
            initDatabase(db);
        }

        pref = getSharedPreferences(getString(R.string.shared_preferences_key),
                Context.MODE_PRIVATE); //set identifier

        //if you need only one preference file use this
        //pref = getPreferences(Context.MODE_PRIVATE);

        TextView txt =  findViewById(R.id.txt_preferences);
        // you run your app for the first time, so you have to check it.
        if(pref.contains(getString(R.string.preference_key))){ //value_id in shared_preferences_key file
            //key(preference_key) and value(whatever you set it to, can be user input or you app can generate one).
            //get the value if the key exits in the storage,
            String user = pref.getString(getString(R.string.preference_key), ""); //(default s1: "");
            // if we don't find anything in identifier(sharedPreferenceKey) and then we have the value set to default.
            txt.setText(user);
        } else{
            //you save it only one time, then it will be set for the rest of app.
            txt.setText("No user found!");
            //In order to add something into preferences we need to create an editor which we can put
            //values into shared preferences. (Only simple values can be stored).
            //set the user.
            SharedPreferences.Editor editor = pref.edit();
            editor.putString(getString(R.string.preference_key), "Mehlika");
            editor.apply();

            //default setting:: sometimes user doesn't say anything you go without it, if it is
            // there you go with it. restart the app(destroy). otherwise its persistent.


            //files have more freedom, DB has more structure but more constrained.
            //defining a class(a contract), allow to create some constants.

        }
        //data read using function.
        List<NameEntity> l = getNames(db);
        String s = "";
        for (NameEntity li:l){
            s+=li.getName()+"\n";
            Log.d("DATABASE-RESULT", li.getId()+" "+li.getName());
        }
        txt.setText(s);
    }
}