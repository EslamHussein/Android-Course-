package com.suitepad.sessionone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private List<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        people = new ArrayList<>();
        people.add(new Person("Ali", 20, 180));
        people.add(new Person("Mohamed", 22, 160));
        people.add(new Person("Hussein", 28, 170));

        PersonAdapter personAdapter =
                new PersonAdapter(this, R.layout.person_cell_item, people);
        listView.setAdapter(personAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                startPersonActivity(people.get(position));
            }
        });
    }

    private void startPersonActivity(Person person) {

        if (person == null) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, PersonDetailsActivity.class);
        intent.putExtra(PersonDetailsActivity.ARG_PERSON_KEY, person);
        startActivity(intent);


    }

}
