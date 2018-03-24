package com.suitepad.sessionone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView personRecyclerView;
    private List<Person> people;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personRecyclerView = findViewById(R.id.recycler_view_person);

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

    }


}
