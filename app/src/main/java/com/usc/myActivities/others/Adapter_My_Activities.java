package com.usc.myActivities.others;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.usc.myActivities.R;
import com.usc.myActivities.activities.Activity_My_Activities;
import com.usc.myActivities.fragments.Fragment_My_Activities_View;
import com.usc.myActivities.lab.Model_MyActivity;

import java.util.List;

public class Adapter_My_Activities extends RecyclerView.Adapter<Adapter_My_Activities.TripHolder> {

    private Context mContext;
    private List<Model_MyActivity> mTrips;

    public Adapter_My_Activities(Context context, List<Model_MyActivity> trips){
        this.mContext = context;
        this.mTrips = trips;
    }

    @Override
    public TripHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_activity,parent,false);
        return new TripHolder(view);

    }

    @Override
    public void onBindViewHolder(TripHolder holder, int position) {
        final Model_MyActivity myactivity = mTrips.get(position);
        holder.bindTrip(myactivity);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                Fragment_My_Activities_View myFragment = new Fragment_My_Activities_View();

                Bundle bundle = new Bundle();
                bundle.putString(Activity_My_Activities.EXTRA_ACTIVITY_ID, myactivity.getId().toString());
                myFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();
            }
        });



    }

    @Override
    public int getItemCount() {
        return mTrips.size();
    }

    public class TripHolder extends RecyclerView.ViewHolder  {

        private Model_MyActivity mTrip;

        private TextView txtTitle;
        private TextView txtDate;
        private TextView txtDesc;

        public TripHolder(final View itemView){
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.title);
            txtDate = (TextView) itemView.findViewById(R.id.date);
            txtDesc = (TextView) itemView.findViewById(R.id.desc);
        }

        public void bindTrip(Model_MyActivity trip){
            mTrip = trip;
            txtTitle.setText(mTrip.getTitle());
            txtDate.setText(mTrip.getDate());
            txtDesc.setText(mTrip.getDestination());
        }

    }

    public void setTrips(List<Model_MyActivity> trips){
        mTrips = trips;
    }

}
