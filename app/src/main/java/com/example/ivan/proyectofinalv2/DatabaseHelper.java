package com.example.ivan.proyectofinalv2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import com.example.ivan.proyectofinalv2.entity.Actividad;
import com.example.ivan.proyectofinalv2.entity.Categoria;

/**
 * Created by Ernesto on 16/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "ProjectDB";
    private static final String CREAR_TB_ACTIVIDADES = "CREATE  TABLE categorias(nombre text, categoria text)";
    private static final String CREAR_TB_LISTA_ACTIVIDADES = "CREATE  TABLE actividades(nombre text, tiempo FLOAT, distancia FLOAT, descripcion TEXT, fecha TEXT, peso FLOAT)";
    //private static final String CREAR_TB_AEROBICAS = "CREATE  TABLE aerobicas (tiempo FLOAT, distancia FLOAT, descripcion TEXT, fecha TEXT, id_actividad integer, FOREIGN KEY(id_actividad) REFERENCES  actividades(id))";
    //private static final String CREAR_TB_ANAEROBICAS = "CREATE TABLE anaerobicas(tiempo FLOAT, repeticiones INTEGER,peso FLOAT, descripcion TEXT, fecha TEXT, id_actividad integer, FOREIGN KEY(id_actividad) REFERENCES  actividades(id))";

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
        db.execSQL(CREAR_TB_LISTA_ACTIVIDADES);
        db.execSQL("INSERT INTO categorias values(\"Running\", \"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Ciclismo\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Natacion\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Caminata\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Fuerza\", \"ANAERO\")");
        db.execSQL("INSERT INTO categorias values(\"Pesas\", \"ANAERO\")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop if exists actividades");
        db.execSQL("drop if exists categorias");


        db.execSQL(CREAR_TB_ACTIVIDADES);
        db.execSQL(CREAR_TB_LISTA_ACTIVIDADES);
        db.execSQL("INSERT INTO categorias values(\"Running\", \"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Ciclismo\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Fuerza\", \"ANAERO\")");
    }

    public Categoria getCategoria(String name) {

        Categoria actividad = new Categoria();
        String selectQuery = "select Nombre, Categoria from categorias where Nombre = ?";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[] { name });
        if(cursor.moveToFirst()){
            actividad.setNombre(cursor.getString(0));
            actividad.setCategoria(cursor.getString(1));
        }
        cursor.close();
        return actividad;
    }

    public ArrayList<Categoria> lstCategorias() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT nombre, categoria from categorias",null);

        while (cursor.moveToNext()) {
            Categoria categoria = new Categoria();
            categoria.setNombre(cursor.getString(0));
            categoria.setCategoria(cursor.getString(1));
            categorias.add(categoria);
        }

        return categorias;
    }

    public ArrayList<Actividad> lstActividades() {
        ArrayList<Actividad> actividades = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT tiempo, distancia, descripcion, fecha, nombre, peso from actividades",null);
//CREATE  TABLE actividades(nombre text, tiempo FLOAT, distancia FLOAT, descripcion TEXT, fecha TEXT, peso FLOAT)
        while (cursor.moveToNext()) {
            Actividad actividad = new Actividad();
            actividad.setTiempo(cursor.getFloat(0));
            actividad.setDistancia(cursor.getFloat(1));
            actividad.setDescripcion(cursor.getString(2));
            actividad.setFecha(cursor.getString(3));
            actividad.setNombre(cursor.getString(4));
            actividad.setPeso(cursor.getString(5));

            actividades.add(actividad);
        }

        return actividades;
    }

}
