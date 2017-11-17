package com.example.ivan.proyectofinalv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ernesto on 16/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "ProjectDB";
    private static final String CREATE_TB_USER = "create table user(id integer primary key, name text, email text)";
    private static final String CREATE_TB_RUNNING = "create table running(carrera text, fecha text, hora text, min text, seg text)";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Here we create the database
        db.execSQL(CREATE_TB_USER);
        db.execSQL(CREATE_TB_RUNNING);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop if exists user");
        db.execSQL("drop if exists running");

        db.execSQL(CREATE_TB_USER);
        db.execSQL(CREATE_TB_RUNNING);
    }
}
