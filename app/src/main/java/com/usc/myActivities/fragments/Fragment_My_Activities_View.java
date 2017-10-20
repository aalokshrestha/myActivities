package com.usc.myActivities.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.usc.myActivities.R;
import com.usc.myActivities.activities.Activity_My_Activities;
import com.usc.myActivities.activities.Activity_My_Activities_List;
import com.usc.myActivities.lab.Lab_My_Activities;
import com.usc.myActivities.lab.Model_MyActivity;

import java.util.UUID;


public class Fragment_My_Activities_View extends Fragment {

    private Model_MyActivity myActivities;

    private TextView mTitleField,mDateField,mDestinationField,mDurationField,mCommentField,mLocationField,mTypeField;
    private ImageView mImageView;
    private Button mCancelBtn,mMapBtn;

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
        View view = inflater.inflate(R.layout.activity_view_fragment,container,false);


        mTitleField = (TextView) view.findViewById(R.id.title);
        mDateField = (TextView) view.findViewById(R.id.date);
        mDestinationField = (TextView) view.findViewById(R.id.destination);
        mDurationField = (TextView) view.findViewById(R.id.duration);
        mCommentField = (TextView) view.findViewById(R.id.comment);
        mLocationField = (TextView) view.findViewById(R.id.location);
        mTypeField = (TextView) view.findViewById(R.id.type);

        mTitleField.setText(myActivities.getTitle());
        mDateField.setText(myActivities.getDate());
        mDestinationField.setText(myActivities.getDestination());
        mDurationField.setText(myActivities.getDuration());
        mCommentField.setText(myActivities.getComment());
        mLocationField.setText(myActivities.getLocation());
        mTypeField.setText(myActivities.getType());

        mImageView = (ImageView) view.findViewById(R.id.imageView);
        mCancelBtn = (Button) view.findViewById(R.id.btn_cancel);
        mMapBtn = (Button) view.findViewById(R.id.btn_map);

        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lab_My_Activities.get(getActivity()).deleteTrip(myActivities);
                startActivity(Activity_My_Activities_List.newIntent(getActivity()));
            }
        });

        mMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                Fragment_My_Activities_View myFragment = new Fragment_My_Activities_View();

                Bundle bundle = new Bundle();
                bundle.putString(Activity_My_Activities.EXTRA_ACTIVITY_ID, myActivities.getId().toString());
                myFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();


            }
        });

        return view;

    }

}
