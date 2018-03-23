package com.suitepad.sessionone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class PersonDetailsActivity extends AppCompatActivity {

    public static final String ARG_PERSON_KEY = "PERSON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

        Person person = (Person) getIntent().getSerializableExtra(ARG_PERSON_KEY);

        Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();


    }
}
