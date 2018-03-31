package com.suitepad.sessionone.network;

import android.util.JsonReader;

import com.suitepad.sessionone.Person;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eslam Hussein on 3/24/18.
 */

public class UserConnection {

    public List<Person> loadData(URL url) throws IOException {

        List<Person> result = null;

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        if (httpURLConnection.getResponseCode() == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader =
                    new InputStreamReader(inputStream, "UTF-8");
            JsonReader jsonReader = new JsonReader(inputStreamReader);

            result = readUsersArray(jsonReader);

        }
        return result;
    }


    public List<Person> readUsersArray(JsonReader reader) throws IOException {
        List<Person> people = new ArrayList<Person>();

        reader.beginArray();
        while (reader.hasNext()) {
            people.add(readUser(reader));
        }
        reader.endArray();
        return people;
    }

    public Person readUser(JsonReader reader) throws IOException {
        Person person = new Person();

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                person.setName(reader.nextString());
            } else if (name.equals("age")) {
                person.setAge(reader.nextInt());
            } else if (name.equals("height")) {
                person.setHeight(reader.nextInt());
            }
        }
        reader.endObject();
        return person;
    }




}
