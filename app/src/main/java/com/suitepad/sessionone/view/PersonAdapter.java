package com.suitepad.sessionone.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.suitepad.sessionone.Person;
import com.suitepad.sessionone.R;

import java.util.List;

/**
 * Created by Eslam Hussein on 3/23/18.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private List<Person> people;
    private Context context;
    private OnClick onClick;

    public PersonAdapter(OnClick onClick, List<Person> people) {
        this.people = people;
        this.onClick = onClick;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.person_cell_item, parent, false);
        context = parent.getContext();
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Person person = people.get(position);
        holder.nameTextView.setText(person.getName());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClick.onClick(person);
//                Toast.makeText(context, person.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return people.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView nameTextView;
        RelativeLayout parent;

        public ViewHolder(View itemView) {

            super(itemView);
            nameTextView = itemView.findViewById(R.id.text_view_name);
            parent = itemView.findViewById(R.id.parent);

        }
    }

    public interface OnClick {
        void onClick(Person person);
    }
}
