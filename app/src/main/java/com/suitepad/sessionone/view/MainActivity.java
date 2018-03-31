package com.suitepad.sessionone.view;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.stetho.Stetho;
import com.suitepad.sessionone.Person;
import com.suitepad.sessionone.R;

import java.net.URL;

public class MainActivity extends AppCompatActivity implements PeopleFragment.ActivityContract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);


        Fragment fragmentPeopleOne =
                PeopleFragment.newInstance("http://demo7261611.mockable.io/people2");


        Fragment fragmentPeopleTwo =
                PeopleFragment.newInstance("http://demo7261611.mockable.io/people");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.headlines_fragment, fragmentPeopleOne).commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.headlines_fragment1, fragmentPeopleTwo).commit();


    }


    @Override
    public void onNavigate(Person person) {

        if (findViewById(R.id.details_continer) == null) {

            PersonDetailsActivity.lunchActivity(this, person);
        } else {

            getSupportFragmentManager().beginTransaction().replace(R.id.details_continer, DetailsPersonFragment.newInstance(person)).commit();
        }


    }
}
