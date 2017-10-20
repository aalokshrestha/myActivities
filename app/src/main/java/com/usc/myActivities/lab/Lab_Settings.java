package com.usc.myActivities.lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.usc.myActivities.others.DbSchema_My_Activities;
import com.usc.myActivities.wrappers.Settings_Cursor_Wrapper;
import com.usc.myActivities.others.Helper_My_Activities;

import java.util.ArrayList;
import java.util.List;

public class Lab_Settings {

    private static Lab_Settings sSettingsLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    private List<Model_Settings> mSettings;

    public static Lab_Settings get(Context context){
        if(sSettingsLab == null){
            sSettingsLab = new Lab_Settings(context);
        }
        return sSettingsLab;
    }

    private Lab_Settings(Context context){

        mContext = context.getApplicationContext();
        mDatabase = new Helper_My_Activities(mContext).getWritableDatabase();

    }

    public Model_Settings getSettings(){
        List<Model_Settings> settings = new ArrayList<>();
        Settings_Cursor_Wrapper cursor = querySettings(null,null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                settings.add(cursor.getSetting());
                cursor.moveToNext();
            }
        } finally {

        }

        return settings.get(0);

    }

    public void updateSettings(Model_Settings s){

        String uuidString = s.getmId().toString();
        ContentValues values = getContentValues(s);

        mDatabase.update(DbSchema_My_Activities.SettingsTable.NAME, values, DbSchema_My_Activities.SettingsTable.Cols.UUID + " =?", new String[] { uuidString });

    }

    private static ContentValues getContentValues(Model_Settings settings){

        ContentValues values = new ContentValues();
        values.put(DbSchema_My_Activities.SettingsTable.Cols.UUID,settings.getmId().toString());
        values.put(DbSchema_My_Activities.SettingsTable.Cols.NAME,settings.getName());
        values.put(DbSchema_My_Activities.SettingsTable.Cols.ID,settings.getId());
        values.put(DbSchema_My_Activities.SettingsTable.Cols.EMAIL,settings.getEmail());
        values.put(DbSchema_My_Activities.SettingsTable.Cols.GENDER,settings.getGender());
        values.put(DbSchema_My_Activities.SettingsTable.Cols.COMMENT,settings.getComment());

        return values;
    }

    private Settings_Cursor_Wrapper querySettings(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                DbSchema_My_Activities.SettingsTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new Settings_Cursor_Wrapper(cursor);
    }

}
