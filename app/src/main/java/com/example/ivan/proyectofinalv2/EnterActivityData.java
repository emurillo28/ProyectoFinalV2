package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import static android.content.ContentValues.TAG;

/**
 * Created by Ernesto on 18/11/2017.
 */

public class EnterActivityData extends Activity {
    private TextView tv_fecha;
    private EditText edt_tiempo, edt_distancia, edt_descripcion, edt_peso;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String idActividad;
    private Spinner sp_peso, sp_distancia;
    private SQLiteDatabase db;

    protected void onCreate(Bundle  savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper databaseHelper = new DatabaseHelper(this, null, null, 1);
        db = databaseHelper.getWritableDatabase();
        // TODO Ocupamos obtener el registro de la base de datos.

        int id = getIntent().getIntExtra("id",0);
        //EditText temp = (EditText) findViewById(id);
        //idActividad = temp.getText().toString();
        Log.d(TAG,idActividad);

        if(true) {
            setContentView(R.layout.activity_aero_entry);
            // De donde estariamos sacando el nombre de la actividad?
            aeroFunctionality();
        } else {
            setContentView(R.layout.layout_anaero_entry);
            anaeroFunctionality();
        }
    }

    private void aeroFunctionality() {
        edt_tiempo = (EditText) findViewById(R.id.edt_tiempo);
        edt_distancia = (EditText) findViewById(R.id.edt_distancia);
        edt_descripcion = (EditText) findViewById(R.id.edt_descripcion);
        sp_distancia = (Spinner) findViewById(R.id.spinner);
        tv_fecha = (TextView) findViewById(R.id.tv_fecha);

        String distancias[] = {"m", "km", "mi"};
        sp_distancia.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, distancias));

        tv_fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EnterActivityData.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                tv_fecha.setText(date);
            }
        };
    }

    private void anaeroFunctionality() {
        edt_tiempo = (EditText) findViewById(R.id.edt_distancia);
        edt_descripcion = (EditText) findViewById(R.id.edt_descripcion);
        sp_peso = (Spinner) findViewById(R.id.spinner);
        tv_fecha = (TextView) findViewById(R.id.tv_fecha);
        edt_peso = (EditText) findViewById(R.id.edt_peso);

        String pesos[] = {"kg","lb"};
        sp_distancia.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pesos));

        tv_fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EnterActivityData.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                tv_fecha.setText(date);
            }
        };
        // obtenemos datos para las actividades anaerobicas.
    }

    public void submit(View V) {
        ContentValues values = new ContentValues();

        String fecha = tv_fecha.getText().toString();
        String tiempo = edt_tiempo.getText().toString();
        String descripcion = edt_descripcion.getText().toString();

        values.put("fecha",fecha);
        values.put("tiempo",tiempo);
        values.put("descripcion",descripcion);
        //String idActividad = ?
        //values.put("id_actividad",idActividad);
        if(true) {
            String distancia = edt_distancia.getText().toString();

            values.put("distancia",distancia);

            db.insert("aerobicas", null, values);
        } else {

            db.insert("anaerobicas", null, values);
        }
      //  Snackbar.make(V, "Replace with your own action", Snackbar.LENGTH_LONG)
        //        .setAction("Action", null).show();
        super.onBackPressed();
    }

}
