package com.usc.myActivities.others;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.UUID;


public class Helper_My_Activities extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "myActivites.db";

    public Helper_My_Activities(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + DbSchema_My_Activities.ActivityTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                DbSchema_My_Activities.ActivityTable.Cols.UUID + ", "+
                DbSchema_My_Activities.ActivityTable.Cols.TITLE + ", "+
                DbSchema_My_Activities.ActivityTable.Cols.DATE + ", "+
                DbSchema_My_Activities.ActivityTable.Cols.DURATION + ", "+
                DbSchema_My_Activities.ActivityTable.Cols.COMMENT + ", "+
                DbSchema_My_Activities.ActivityTable.Cols.LOCATION + ", "+
                DbSchema_My_Activities.ActivityTable.Cols.TYPE + ", "+
                DbSchema_My_Activities.ActivityTable.Cols.DESTINATION +
            ")"
        );

        db.execSQL("create table " + DbSchema_My_Activities.SettingsTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                DbSchema_My_Activities.SettingsTable.Cols.UUID + ", "+
                DbSchema_My_Activities.SettingsTable.Cols.NAME + ", "+
                DbSchema_My_Activities.SettingsTable.Cols.ID + ", "+
                DbSchema_My_Activities.SettingsTable.Cols.EMAIL + ", "+
                DbSchema_My_Activities.SettingsTable.Cols.GENDER + ", "+
                DbSchema_My_Activities.SettingsTable.Cols.COMMENT +
                ")"
        );

        db.execSQL("insert into " + DbSchema_My_Activities.SettingsTable.NAME + "(" +
                DbSchema_My_Activities.SettingsTable.Cols.UUID + ", "+
                DbSchema_My_Activities.SettingsTable.Cols.NAME + ", "+
                DbSchema_My_Activities.SettingsTable.Cols.ID + ", "+
                DbSchema_My_Activities.SettingsTable.Cols.EMAIL + ", "+
                DbSchema_My_Activities.SettingsTable.Cols.GENDER + ", "+
                DbSchema_My_Activities.SettingsTable.Cols.COMMENT +
                ") values ('"+ UUID.randomUUID()+"','Aalok Shrestha','1100340','A_S272@student.usc.edu.au','Male','No Comments')"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
