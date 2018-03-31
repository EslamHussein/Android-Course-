package com.suitepad.sessionone.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eslam Hussein on 3/30/18.
 */

public class MyPersonDBHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "hamada.db";
    public static final int DATABASE_VERSION = 1;


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PersonContract.PersonEntity.TABLE_NAME + " (" +
                    PersonContract.PersonEntity._ID + " INTEGER PRIMARY KEY," +
                    PersonContract.PersonEntity.NAME + " TEXT," +
                    PersonContract.PersonEntity.HEIGHT + " TEXT," +
                    PersonContract.PersonEntity.AGE + " INTEGER)";


    public MyPersonDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
