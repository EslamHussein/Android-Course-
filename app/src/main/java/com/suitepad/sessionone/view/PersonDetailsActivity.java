package com.suitepad.sessionone.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.suitepad.sessionone.Person;
import com.suitepad.sessionone.R;
import com.suitepad.sessionone.db.CRUDManger;
import com.suitepad.sessionone.db.MyPersonDBHelper;
import com.suitepad.sessionone.db.PersonContract;

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

        getSupportFragmentManager().beginTransaction().add(R.id.hamada
                , DetailsPersonFragment.newInstance(person)).commit();

    }
}
