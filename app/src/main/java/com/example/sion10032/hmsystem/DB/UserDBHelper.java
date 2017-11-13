package com.example.sion10032.hmsystem.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sion10032
 * On 11/13/17.
 */

public class UserDBHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1000;
    private static final String DB_NAME = "UserDB_";
    public static final String MED_TABLE = "MedTable";

    public UserDBHelper(Context context, String name) {
        // every user have their own DB
        // DB's name is "UserDB_UUID"
        super(context, DB_NAME + name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // add the table of medicine
        // will add other table in future
        String sql = "CREATE TABLE IF NOT EXISTS " +
                MED_TABLE +
                " (UUID TEXT PRIMARY KEY, " +
                "MEDNAME TEXT, " +
                "DESCRIPTION TEXT, " +
                "IMGPATH TEXT, " +
                "REMAINS INTEGER, " +
                "ISUSING INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // do something
    }
}
