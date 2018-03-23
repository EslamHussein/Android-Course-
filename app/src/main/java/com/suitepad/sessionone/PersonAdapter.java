package com.suitepad.sessionone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Eslam Hussein on 3/23/18.
 */

public class PersonAdapter extends ArrayAdapter<Person> {

    private Context context;
    private List<Person> people;
    private int layout;


    public PersonAdapter(@NonNull Context context, int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);

        this.context = context;
        this.people = objects;
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

        Person person = people.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(layout, parent, false);
        TextView nameTextView = view.findViewById(R.id.text_view_name);
        nameTextView.setText(person.getName());
        return view;

    }
}
