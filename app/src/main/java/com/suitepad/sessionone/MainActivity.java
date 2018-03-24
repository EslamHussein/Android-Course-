package com.suitepad.sessionone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();


    private RecyclerView personRecyclerView;
    private List<Person> people;

    private RecyclerView.LayoutManager layoutManager;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personRecyclerView = findViewById(R.id.recycler_view_person);
        progressDialog = new ProgressDialog(this);

        personRecyclerView.setHasFixedSize(true);
        people = new ArrayList<>();
        people.add(new Person("Ali", 20, 180));
        people.add(new Person("Mohamed", 22, 160));
        people.add(new Person("Hussein", 28, 170));


        layoutManager = new LinearLayoutManager(this);
        personRecyclerView.setLayoutManager(layoutManager);


        PersonAdapter personAdapter =
                new PersonAdapter(people);
        personRecyclerView.setAdapter(personAdapter);

        try {
            URL url = new URL("http://demo7261611.mockable.io/users");
            DownloadManger downloadManger = new DownloadManger();
            downloadManger.execute(url);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    private class DownloadManger extends AsyncTask<URL, Void, List<User>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected List<User> doInBackground(URL... urls) {

            List<User> result = null;
            try {
                UserConnection userConnection = new UserConnection();

                result = userConnection.loadData(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(List<User> result) {
            super.onPostExecute(result);

            if (result == null) {
                Log.d(TAG, "onPostExecute() returned:  Marg3sh 7aga");
            } else {
                Log.d(TAG, "onPostExecute() returned:  Rag3 7aga : " + result);

            }

            progressDialog.dismiss();


        }
    }


}
