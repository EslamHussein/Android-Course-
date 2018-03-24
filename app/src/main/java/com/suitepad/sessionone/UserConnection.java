package com.suitepad.sessionone;

import android.util.JsonReader;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eslam Hussein on 3/24/18.
 */

public class UserConnection {

    public List<User> loadData(URL url) throws IOException {

        List<User> result = null;

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


    public List<User> readUsersArray(JsonReader reader) throws IOException {
        List<User> users = new ArrayList<User>();

        reader.beginArray();
        while (reader.hasNext()) {
            users.add(readUser(reader));
        }
        reader.endArray();
        return users;
    }

    public User readUser(JsonReader reader) throws IOException {
        User user = new User();

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                user.setId(reader.nextInt());
            } else if (name.equals("first_name")) {
                user.setFirstName(reader.nextString());
            } else if (name.equals("last_name")) {
                user.setLastName(reader.nextString());
            }
        }
        reader.endObject();
        return user;
    }




}
