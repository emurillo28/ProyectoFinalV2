package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

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
        db.execSQL("INSERT INTO actividades values(1,\"Running\", \"Actividad donde se corre, en suelo xd\", \"AERO\")");
        db.execSQL("INSERT INTO actividades values(2,\"Cyclism\", \"Actividad donde se bicicletea\", \"AERO\")");
        db.execSQL("INSERT INTO actividades values(3,\"Strength\", \"Actividad donde se levantan pesas\", \"ANAERO\")");

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

    public Actividad getActivity(String name) {

        Actividad actividad = new Actividad();
        String selectQuery = "select id, Nombre, Descripcion, Categoria from actividades where Nombre = ?";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[] { name });
        if(cursor.moveToFirst()){
            actividad.setId(cursor.getInt(0));
            actividad.setNombre(cursor.getString(1));
            actividad.setDescripcion(cursor.getString(2));
            actividad.setCategoria(cursor.getString(3));
        }
        cursor.close();
        Log.d(TAG,actividad.toString());
        return actividad;
        /*
        Actividad actividad = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from actividades where Nombre=" + "\""+name+"\"", null);
        c.moveToFirst();

        actividad = new Actividad(c.getInt(0),c.getString(1),c.getString(2),c.getString(3));
        return actividad;
        */
    }
}
