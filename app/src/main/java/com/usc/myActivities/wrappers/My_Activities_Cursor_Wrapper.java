package com.usc.myActivities.wrappers;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.usc.myActivities.others.DbSchema_My_Activities;
import com.usc.myActivities.lab.Model_MyActivity;

import java.util.Date;
import java.util.UUID;


public class My_Activities_Cursor_Wrapper extends CursorWrapper {

    public My_Activities_Cursor_Wrapper(Cursor cursor) {
        super(cursor);
    }

    public Model_MyActivity getActivity(){

        String uuidString  = getString(getColumnIndex(DbSchema_My_Activities.ActivityTable.Cols.UUID));
        String title = getString(getColumnIndex(DbSchema_My_Activities.ActivityTable.Cols.TITLE));
        long date = getLong(getColumnIndex(DbSchema_My_Activities.ActivityTable.Cols.DATE));
        String destination = getString(getColumnIndex(DbSchema_My_Activities.ActivityTable.Cols.DESTINATION));
        String comment = getString(getColumnIndex(DbSchema_My_Activities.ActivityTable.Cols.COMMENT));
        String duration = getString(getColumnIndex(DbSchema_My_Activities.ActivityTable.Cols.DURATION));
        String location = getString(getColumnIndex(DbSchema_My_Activities.ActivityTable.Cols.LOCATION));
        String type = getString(getColumnIndex(DbSchema_My_Activities.ActivityTable.Cols.TYPE));

        Model_MyActivity activity = new Model_MyActivity(UUID.fromString(uuidString));
        activity.setTitle(title);
        activity.setDestination(destination);
        activity.setDuration(duration);
        activity.setComment(comment);
        activity.setLocation(location);
        activity.setType(type);
        activity.setDate(new Date(date).toString());
        return activity;

    }

}
