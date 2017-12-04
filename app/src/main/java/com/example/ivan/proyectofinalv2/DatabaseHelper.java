package com.example.ivan.proyectofinalv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ernesto on 16/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "ProjectDB";
    private static final String CREAR_TB_ACTIVIDADES = "CREATE  TABLE actividades(id integer primary key, Nombre text, Descripcion text, Categoria text)";
    private static final String CREAR_TB_AEROBICAS = "CREATE  TABLE aerobicas (tiempo FLOAT, distancia FLOAT, descripcion TEXT, fecha DATETIME, id_actividad integer, FOREIGN KEY(id_actividad) REFERENCES  actividades(id))";
    private static final String CREAR_TB_ANAEROBICAS = "CREATE TABLE anaerobicas(tiempo FLOAT, repeticiones INTEGER,peso FLOAT, descripcion TEXT, fecha DATETIME, id_actividad integer, FOREIGN KEY(id_actividad) REFERENCES  actividades(id))";
/*"INSERT INTO \"main\".\"actividades\" (\"id\",\"Nombre\",\"Descripcion\",\"Categoria\") VALUES (1,?1,?2,?3)\n"+
        "Parameters:\n"+
        "param 1 (text): Correr\n"+
        "param 2 (text): La corredera\n"+
        "param 3 (text): AERO\n"*/
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creamos Las tablas de la base de datos
        db.execSQL(CREAR_TB_ACTIVIDADES);
        db.execSQL(CREAR_TB_AEROBICAS);
        db.execSQL(CREAR_TB_ANAEROBICAS);
        db.execSQL("INSERT INTO actividades values(1,\"Correr\", \"Actividad donde se corre, en suelo xd\", \"AERO\")");
        db.execSQL("INSERT INTO actividades values(2,\"Nadar\", \"Actividad donde se nada, en agua xd\", \"AERO\")");
        db.execSQL("INSERT INTO actividades values(2,\"Pesas\", \"Actividad donde se levantan pesas\", \"AERO\")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop if exists actividades");
        db.execSQL("drop if exists aerobicas");
        db.execSQL("drop if exists anaerobicas");

        db.execSQL(CREAR_TB_ACTIVIDADES);
        db.execSQL(CREAR_TB_AEROBICAS);
        db.execSQL(CREAR_TB_ANAEROBICAS);
    }
}
