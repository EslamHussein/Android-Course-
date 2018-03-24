package com.suitepad.sessionone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class PersonDetailsActivity extends AppCompatActivity {

    private static final String ARG_PERSON_KEY = "PERSON";


    public static void lunchActivity(Context from, Person person) {

        Intent intent = new Intent(from, PersonDetailsActivity.class);
        intent.putExtra(PersonDetailsActivity.ARG_PERSON_KEY, person);
        from.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

        Person person = (Person) getIntent().getSerializableExtra(ARG_PERSON_KEY);

        Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();


    }
}
