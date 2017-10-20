package com.usc.myActivities.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.usc.myActivities.R;
import com.usc.myActivities.activities.Activity_My_Activities;
import com.usc.myActivities.lab.Lab_My_Activities;
import com.usc.myActivities.lab.Model_MyActivity;

import java.util.UUID;


public class Fragment_Map extends Fragment {

    private Model_MyActivity myActivities;
    GoogleMap googleMap;
    LatLng myPosition;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String activityID = "";

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            activityID = bundle.getString(Activity_My_Activities.EXTRA_ACTIVITY_ID, "");
        }
        myActivities = Lab_My_Activities.get(getActivity()).getActivities(UUID.fromString(activityID));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_fragment,container,false);



        return view;

    }


}
