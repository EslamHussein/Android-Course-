package com.suitepad.sessionone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button aliButton, mohamedButton, husseinButton, hamadaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aliButton = findViewById(R.id.button_ali);
        mohamedButton = findViewById(R.id.button_mohamed);
        husseinButton = findViewById(R.id.button_hussein);
        hamadaButton = findViewById(R.id.button_hamda);

        aliButton.setOnClickListener(this);
        mohamedButton.setOnClickListener(this);
        husseinButton.setOnClickListener(this);
        hamadaButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Person person = null;
        switch (v.getId()) {
            case R.id.button_ali:
                person = new Person("Ali", 20, 180);
                break;
            case R.id.button_mohamed:
                person = new Person("Mohamed", 22, 160);
                break;
            case R.id.button_hussein:
                person = new Person("Hussein", 28, 170);
                break;

        }

        startPersonActivity(person);

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
