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
    private static final String CREAR_TB_LISTA_ACTIVIDADES = "CREATE  TABLE actividades(nombre text, horas INTEGER, minutos INTEGER, segundos INTEGER, distancia FLOAT, descripcion TEXT, fecha TEXT, peso FLOAT)";
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
        db.execSQL("INSERT INTO categorias values(\"Running\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Ciclismo\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Natacion\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Caminata\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Fuerza\", \"ANAERO\")");
        db.execSQL("INSERT INTO categorias values(\"Pesas\", \"ANAERO\")");/*
        db.execSQL("INSERT INTO actividades values(\"Running\",1:30:15,15000,\"Corriendo en la calle\",\"2017/12/17\",0)");
        db.execSQL("INSERT INTO actividades values(\"Running\",1:10:15,12000,\"Corriendo en la calle\",\"2017/12/18\",0)");
        db.execSQL("INSERT INTO actividades values(\"Running\",2:30:37,25000,\"Corriendo en la calle\",\"2017/12/29\",0)");
        db.execSQL("INSERT INTO actividades values(\"Running\",0:30:10,5000,\"Corriendo en la calle\",\"2017/12/20\",0)");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop if exists actividades");
        db.execSQL("drop if exists categorias");

        db.execSQL(CREAR_TB_ACTIVIDADES);
        db.execSQL(CREAR_TB_LISTA_ACTIVIDADES);
        db.execSQL("INSERT INTO categorias values(\"Running\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Ciclismo\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Natacion\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Caminata\",\"AERO\")");
        db.execSQL("INSERT INTO categorias values(\"Fuerza\", \"ANAERO\")");
        db.execSQL("INSERT INTO categorias values(\"Pesas\", \"ANAERO\")");
        /*db.execSQL("INSERT INTO actividades values(\"Running\",1:30:15,15000,\"Corriendo en la calle\",\"2017/12/17\")");
        db.execSQL("INSERT INTO actividades values(\"Running\",1:10:15,12000,\"Corriendo en la calle\",\"2017/12/18\")");
        db.execSQL("INSERT INTO actividades values(\"Running\",2:30:37,25000,\"Corriendo en la calle\",\"2017/12/29\")");
        db.execSQL("INSERT INTO actividades values(\"Running\",0:30:10,5000,\"Corriendo en la calle\",\"2017/12/20\")");*/
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
        Cursor cursor = db.rawQuery("SELECT horas, minutos, segundos, distancia, descripcion, fecha, nombre, peso from actividades",null);
//CREATE  TABLE actividades(nombre text, tiempo FLOAT, distancia FLOAT, descripcion TEXT, fecha TEXT, peso FLOAT)
        while (cursor.moveToNext()) {
            Actividad actividad = new Actividad();
            //actividad.setTiempo(cursor.getFloat(0));
            actividad.setHoras(cursor.getInt(0));
            actividad.setMinutos(cursor.getInt(1));
            actividad.setSegundos(cursor.getInt(2));
            actividad.setDistancia(cursor.getFloat(3));
            actividad.setDescripcion(cursor.getString(4));
            actividad.setFecha(cursor.getString(5));
            actividad.setNombre(cursor.getString(6));
            actividad.setPeso(cursor.getString(7));

            actividades.add(actividad);
        }

        return actividades;
    }

}
