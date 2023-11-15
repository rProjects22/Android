package ca.georgebrown.lab5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NameDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "names.db";

    //creating a constructor
    public NameDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //super class makes a decision.
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(NameContract.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //THIS METHODS SUCKS (only good for development)
        //in release version the upgrade code should be.
        sqLiteDatabase.execSQL(NameContract.SQL_DROP);
        onCreate(sqLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

}
