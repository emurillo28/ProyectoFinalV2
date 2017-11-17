package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by IVAN on 13/11/2017.
 */

public class EnterRunningData extends Activity{
    private TextView tv1;
    private EditText edt1, edt2, edt3, edt4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_entry);

        tv1 = (TextView) findViewById(R.id.tv_carrera);
        edt1 = (EditText) findViewById(R.id.edt_fecha);
        edt2 = (EditText) findViewById(R.id.edt_hora);
        edt3 = (EditText) findViewById(R.id.edt_min);
        edt4 = (EditText) findViewById(R.id.edt_seg);
    }

    public void create(View view) {
        DatabaseHelper databaseHelper = new DatabaseHelper(this, null, null, 1);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        String carrera = tv1.getText().toString();
        String fecha = edt1.getText().toString();
        String hora = edt2.getText().toString();
        String min = edt3.getText().toString();
        String seg = edt4.getText().toString();

        ContentValues values = new ContentValues();

        values.put("carrera", carrera);
        values.put("fecha", fecha);
        values.put("hora", hora);
        values.put("min", min);
        values.put("seg", seg);

        db.insert("running", null, values);
        db.close();
    }
}
