package com.usc.myActivities.wrappers;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.usc.myActivities.others.DbSchema_My_Activities;
import com.usc.myActivities.lab.Model_Settings;

import java.util.UUID;


public class Settings_Cursor_Wrapper extends CursorWrapper {

    public Settings_Cursor_Wrapper(Cursor cursor) {
        super(cursor);
    }

    public Model_Settings getSetting(){

        String uuidString  = getString(getColumnIndex(DbSchema_My_Activities.SettingsTable.Cols.UUID));
        String name = getString(getColumnIndex(DbSchema_My_Activities.SettingsTable.Cols.NAME));
        String id = getString(getColumnIndex(DbSchema_My_Activities.SettingsTable.Cols.ID));
        String email = getString(getColumnIndex(DbSchema_My_Activities.SettingsTable.Cols.EMAIL));
        String gender = getString(getColumnIndex(DbSchema_My_Activities.SettingsTable.Cols.GENDER));
        String comment = getString(getColumnIndex(DbSchema_My_Activities.SettingsTable.Cols.COMMENT));

        Model_Settings setting = new Model_Settings(UUID.fromString(uuidString));
        setting.setName(name);
        setting.setId(id);
        setting.setEmail(email);
        setting.setGender(gender);
        setting.setComment(comment);
        return setting;

    }

}
