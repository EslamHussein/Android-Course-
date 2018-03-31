package com.suitepad.sessionone.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.suitepad.sessionone.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eslam Hussein on 3/30/18.
 */

public class CRUDManger {

    private MyPersonDBHelper myPersonDBHelper;

    public CRUDManger(MyPersonDBHelper myPersonDBHelper) {
        this.myPersonDBHelper = myPersonDBHelper;
    }


    public void insert(Person person) {

        SQLiteDatabase sqLiteDatabase = myPersonDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonContract.PersonEntity.NAME, person.getName());
        contentValues.put(PersonContract.PersonEntity.AGE, person.getAge());
        contentValues.put(PersonContract.PersonEntity.HEIGHT, person.getHeight());
        sqLiteDatabase.insert(PersonContract.PersonEntity.TABLE_NAME, null, contentValues);

    }

    public List<Person> getPeople() {

        List<Person> people = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = myPersonDBHelper.getReadableDatabase();

        String[] projection = {PersonContract.PersonEntity._ID,
                PersonContract.PersonEntity.NAME, PersonContract.PersonEntity.AGE,
                PersonContract.PersonEntity.HEIGHT};

        String sortOrder =
                PersonContract.PersonEntity.AGE + " DESC";

        Cursor cursor = sqLiteDatabase.query(
                PersonContract.PersonEntity.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );


        while (cursor.moveToNext()) {


            int idColumnIndex = cursor.getColumnIndexOrThrow(PersonContract.PersonEntity._ID);
            int id = cursor.getInt(idColumnIndex);


            int nameColumnIndex = cursor.getColumnIndexOrThrow(PersonContract.PersonEntity.NAME);
            String name = cursor.getString(nameColumnIndex);


            int ageColumnIndex = cursor.getColumnIndexOrThrow(PersonContract.PersonEntity.AGE);
            int age = cursor.getInt(ageColumnIndex);

            int heightColumnIndex = cursor.getColumnIndexOrThrow(PersonContract.PersonEntity.HEIGHT);
            int height = cursor.getInt(heightColumnIndex);


            Person person = new Person();
            person.setId(id);
            person.setName(name);
            person.setAge(age);
            person.setHeight(height);

            people.add(person);
        }


        return people;
    }


    public Person findPersonById(int personId) {

        List<Person> people = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = myPersonDBHelper.getReadableDatabase();

        String[] projection = {PersonContract.PersonEntity._ID,
                PersonContract.PersonEntity.NAME, PersonContract.PersonEntity.AGE,
                PersonContract.PersonEntity.HEIGHT};

        String selection = PersonContract.PersonEntity._ID + " = ?";
        String[] selectionArgs = {String.valueOf(personId)};


        String sortOrder =
                PersonContract.PersonEntity.AGE + " DESC";

        Cursor cursor = sqLiteDatabase.query(
                PersonContract.PersonEntity.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );


        while (cursor.moveToNext()) {


            int idColumnIndex = cursor.getColumnIndexOrThrow(PersonContract.PersonEntity._ID);
            int id = cursor.getInt(idColumnIndex);


            int nameColumnIndex = cursor.getColumnIndexOrThrow(PersonContract.PersonEntity.NAME);
            String name = cursor.getString(nameColumnIndex);


            int ageColumnIndex = cursor.getColumnIndexOrThrow(PersonContract.PersonEntity.AGE);
            int age = cursor.getInt(ageColumnIndex);

            int heightColumnIndex = cursor.getColumnIndexOrThrow(PersonContract.PersonEntity.HEIGHT);
            int height = cursor.getInt(heightColumnIndex);


            Person person = new Person();
            person.setId(id);
            person.setName(name);
            person.setAge(age);
            person.setHeight(height);

            people.add(person);
        }


        return people.get(0);
    }

}
