package com.alvinhkh.buseta.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RouteOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "route.db";
    private static final int DATABASE_VERSION = 4;

    public RouteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        RouteBoundTable.onCreate(database);
        RouteStopTable.onCreate(database);
        FollowTable.onCreate(database);
        EtaTable.onCreate(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        RouteBoundTable.onUpgrade(database, oldVersion, newVersion);
        if (oldVersion < 3) {
            RouteStopTable.onUpgrade(database, oldVersion, newVersion);
            FollowTable.onUpgrade(database, oldVersion, newVersion);
            EtaTable.onUpgrade(database, oldVersion, newVersion);
        }
    }

}