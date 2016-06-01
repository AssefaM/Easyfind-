package com.example.asse.sweapp;

import android.provider.BaseColumns;

/**
 * Created by user on 5/22/2016.
 */
public class Table_Data {

    public Table_Data() {

    }

    public static abstract class Tableinfo implements BaseColumns {

        public static final String USER_NAME = "user_name";
        public static final String USER_PASS = "user_pass";
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME = "reg_info";

    }
/*
    public static abstract class orders implements BaseColumns {
        public static final String PIZZA_NAME = "pizza_name";
        public static final String DATABASE_NAME = "user_info";

    }
*/
}
