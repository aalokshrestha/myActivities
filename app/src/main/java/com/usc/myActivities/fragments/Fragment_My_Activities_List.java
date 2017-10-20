package com.usc.myActivities.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.usc.myActivities.activities.Activity_My_Activities;
import com.usc.myActivities.others.Adapter_My_Activities;
import com.usc.myActivities.lab.Lab_My_Activities;
import com.usc.myActivities.R;
import com.usc.myActivities.activities.Activity_Settings;
import com.usc.myActivities.lab.Model_MyActivity;

import java.util.List;

public class Fragment_My_Activities_List extends Fragment {

    private RecyclerView mTripRecyclerView;
    private Adapter_My_Activities mAdapter;

    private Button mLogButton;
    private Button mSettingsButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list_fragment,container,false);

        mTripRecyclerView = (RecyclerView) view.findViewById(R.id.tripList);
        mTripRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mLogButton = (Button) view.findViewById(R.id.btn_log);
        mSettingsButton = (Button) view.findViewById(R.id.btn_settings);

        mLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Model_MyActivity a = new Model_MyActivity();
                Lab_My_Activities.get(getActivity()).addActivity(a);
                Intent intent = Activity_My_Activities.newIntent(getActivity(), a.getId());
                startActivity(intent);

            }
        });

        mSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = Activity_Settings.newIntent(getActivity());
                startActivity(intent);

            }
        });

        updateUI();

        return view;

    }

    private void updateUI() {
        Lab_My_Activities triplab = Lab_My_Activities.get(getActivity());
        List<Model_MyActivity> trips = triplab.getActivities();

        if(mAdapter == null){
            mAdapter = new Adapter_My_Activities(getActivity(),trips);
            mTripRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setTrips(trips);
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

}
