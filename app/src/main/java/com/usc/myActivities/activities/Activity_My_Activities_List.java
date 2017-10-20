package com.usc.myActivities.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.usc.myActivities.R;
import com.usc.myActivities.fragments.Fragment_My_Activities_List;

public class Activity_My_Activities_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = new Fragment_My_Activities_List();
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();
        }

    }

    public static Intent newIntent(Context packageContent){

        Intent intent = new Intent(packageContent, Activity_My_Activities_List.class);
        return intent;

    }

}
