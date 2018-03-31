package com.suitepad.sessionone.view;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suitepad.sessionone.Person;
import com.suitepad.sessionone.R;
import com.suitepad.sessionone.db.CRUDManger;
import com.suitepad.sessionone.db.MyPersonDBHelper;
import com.suitepad.sessionone.network.UserConnection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PeopleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PeopleFragment extends Fragment implements PersonAdapter.OnClick {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String TAG = "PeopleFragment";

    private static final String PEOPLE_URL_ARG = "peopleUrl";

    private String peopleUrl;

    private RecyclerView personRecyclerView;

    private RecyclerView.LayoutManager layoutManager;

    private ActivityContract activityContract;


    public PeopleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activityContract = (ActivityContract) context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PeopleFragment.
     */
    public static PeopleFragment newInstance(String peopleUrl) {
        PeopleFragment fragment = new PeopleFragment();
        Bundle args = new Bundle();
        args.putString(PEOPLE_URL_ARG, peopleUrl);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            Bundle bundle = getArguments();
            peopleUrl = bundle.getString(PEOPLE_URL_ARG);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personRecyclerView = view.findViewById(R.id.recycler_view_person);

        personRecyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(getContext());
        personRecyclerView.setLayoutManager(layoutManager);


        try {
            URL url = new URL(peopleUrl);
            DownloadManger downloadManger = new DownloadManger();
            downloadManger.execute(url);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(Person person) {


        activityContract.onNavigate(person);
    }

    private class DownloadManger extends AsyncTask<URL, Void, List<Person>> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Person> doInBackground(URL... urls) {

            List<Person> result = null;
            try {
                UserConnection userConnection = new UserConnection();

                result = userConnection.loadData(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            MyPersonDBHelper myPersonDBHelper = new MyPersonDBHelper(getContext());

            CRUDManger crudManger = new CRUDManger(myPersonDBHelper);
            for (int i = 0; i < result.size(); i++) {
                crudManger.insert(result.get(i));

            }
            return result;
        }

        @Override
        protected void onPostExecute(List<Person> result) {
            super.onPostExecute(result);


            PersonAdapter personAdapter =
                    new PersonAdapter(PeopleFragment.this, result);
            personRecyclerView.setAdapter(personAdapter);

            if (result == null) {
                Log.d(TAG, "onPostExecute() returned:  Marg3sh 7aga");
            } else {
                Log.d(TAG, "onPostExecute() returned:  Rag3 7aga : " + result);

            }


        }
    }


    public interface ActivityContract {

        void onNavigate(Person person);
    }

}
