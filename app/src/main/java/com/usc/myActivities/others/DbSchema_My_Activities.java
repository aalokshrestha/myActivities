package com.usc.myActivities.others;


public class DbSchema_My_Activities {

    public static final class ActivityTable {
        public static final String NAME = "tbl_activites";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String LOCATION = "location";
            public static final String DURATION = "duration";
            public static final String COMMENT = "comment";
            public static final String TYPE = "type";
            public static final String DESTINATION = "destination";
        }
    }

    public static final class SettingsTable {
        public static final String NAME = "tbl_settings";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String ID = "id";
            public static final String EMAIL = "email";
            public static final String GENDER = "gender";
            public static final String COMMENT = "comment";
        }
    }

}
