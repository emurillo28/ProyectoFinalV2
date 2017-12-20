package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

import com.example.ivan.proyectofinalv2.entity.Actividad;
import com.example.ivan.proyectofinalv2.entity.Categoria;
import com.ikovac.timepickerwithseconds.MyTimePickerDialog;

import static android.content.ContentValues.TAG;

/**
 * Created by Ernesto on 18/11/2017.
 */

public class EnterActivityData extends Activity {
    private TextView tv_fecha, edt_horas, edt_minutos, edt_segundos, tvActividad;
    private EditText edt_distancia, edt_descripcion, edt_peso;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String idActividad;
    private SQLiteDatabase db;
    private Actividad actividad;
    private Categoria categoria;

    protected void onCreate(Bundle  savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelper databaseHelper = new DatabaseHelper(this, null, null, 1);
        db = databaseHelper.getWritableDatabase();

        String id = getIntent().getStringExtra("activity");
        ArrayList<Actividad> actividades = databaseHelper.lstActividades();
        ArrayList<Categoria> categorias = databaseHelper.lstCategorias();

        categoria = databaseHelper.getCategoria(id);
        if(categoria.getCategoria().equalsIgnoreCase("AERO")) {
            setContentView(R.layout.activity_aero_entry);
            // De donde estariamos sacando el nombre de la actividad?
            aeroFunctionality();
        } else {
            setContentView(R.layout.layout_anaero_entry);
            anaeroFunctionality();
        }
    }

    private void aeroFunctionality() {
        edt_horas = (TextView) findViewById(R.id.edt_horas);
        edt_minutos = (TextView) findViewById(R.id.edt_minutos);
        edt_segundos = (TextView) findViewById(R.id.edt_segundos);
        edt_distancia = (EditText) findViewById(R.id.edt_distancia);
        edt_descripcion = (EditText) findViewById(R.id.edt_descripcion);
        tv_fecha = (TextView) findViewById(R.id.tv_fecha);
        tvActividad = (TextView) findViewById(R.id.tvActividad);
        String id = getIntent().getStringExtra("activity");

        tvActividad.setText(id);
        tv_fecha.setText("20-12-2017");

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
                Log.d(TAG, "onDateSet: dd-mm-yyyy: " + day + "-" + month + "-" + year);

                String date = day + "-" + month + "-" + year;
                tv_fecha.setText(date);
            }
        };

        edt_horas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                int second = mcurrentTime.get(Calendar.SECOND);

                MyTimePickerDialog mTimePicker = new MyTimePickerDialog(EnterActivityData.this, new MyTimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(com.ikovac.timepickerwithseconds.TimePicker view, int hourOfDay, int minute, int seconds) {
                       // edt_tiempo.setText(String.format("%02d", hourOfDay)+
                         //       ":" + String.format("%02d", minute) +
                           //     ":" + String.format("%02d", seconds));
                        edt_horas.setText(String.format("%02d", hourOfDay));
                        edt_minutos.setText(String.format("%02d", minute));
                        edt_segundos.setText(String.format("%02d", seconds));
                        }
                    }, hour, minute, second, true);
                    mTimePicker.show();

            }
        });
        edt_minutos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                int second = mcurrentTime.get(Calendar.SECOND);

                MyTimePickerDialog mTimePicker = new MyTimePickerDialog(EnterActivityData.this, new MyTimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(com.ikovac.timepickerwithseconds.TimePicker view, int hourOfDay, int minute, int seconds) {
                        edt_horas.setText(String.format("%02d", hourOfDay));
                        edt_minutos.setText(String.format("%02d", minute));
                        edt_segundos.setText(String.format("%02d", seconds));
                        //edt_tiempo.setText(String.format("%02d", hourOfDay)+
                          //      ":" + String.format("%02d", minute) +
                            //    ":" + String.format("%02d", seconds));
                    }
                }, hour, minute, second, true);
                mTimePicker.show();

            }
        });
        edt_segundos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                int second = mcurrentTime.get(Calendar.SECOND);

                MyTimePickerDialog mTimePicker = new MyTimePickerDialog(EnterActivityData.this, new MyTimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(com.ikovac.timepickerwithseconds.TimePicker view, int hourOfDay, int minute, int seconds) {
                       // edt_tiempo.setText(String.format("%02d", hourOfDay)+
                         //       ":" + String.format("%02d", minute) +
                           //     ":" + String.format("%02d", seconds));
                        edt_horas.setText(String.format("%02d", hourOfDay));
                        edt_minutos.setText(String.format("%02d", minute));
                        edt_segundos.setText(String.format("%02d", seconds));
                    }
                }, hour, minute, second, true);
                mTimePicker.show();

            }
        });
    }

    private void anaeroFunctionality() {
        edt_horas = (EditText) findViewById(R.id.edt_tiempo); //Para as repeticiones
        edt_descripcion = (EditText) findViewById(R.id.edt_descripcion);
        tv_fecha = (TextView) findViewById(R.id.tv_fecha);
        edt_peso = (EditText) findViewById(R.id.edt_peso);
        tvActividad = (TextView) findViewById(R.id.tvActividad);
        String id = getIntent().getStringExtra("activity");

        tvActividad.setText(id);
        tv_fecha.setText("20-12-2017");

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
                Log.d(TAG, "onDateSet: dd-mm-yyyy: " + day + "-" + month + "-" + year);

                String date = day + "-" + month + "-" + year;
                tv_fecha.setText(date);
            }
        };
        // obtenemos datos para las actividades anaerobicas.
    }

    public void submit(View V) {
        ContentValues values = new ContentValues();

        String fecha = tv_fecha.getText().toString();
        String descripcion = edt_descripcion.getText().toString();
        String nombreActividad = categoria.getNombre();

        values.put("fecha",fecha);
        values.put("descripcion",descripcion);
        values.put("nombre",nombreActividad);
        if(categoria.getCategoria().equalsIgnoreCase("AERO")) {
            String distancia = edt_distancia.getText().toString();
            values.put("distancia",distancia);
            String horas = edt_horas.getText().toString();
            String minutos = edt_minutos.getText().toString();
            String segundos = edt_segundos.getText().toString();
            values.put("horas",horas);
            values.put("minutos",minutos);
            values.put("segundos",segundos);
        } else {
            String peso = edt_peso.getText().toString();
            values.put("peso", peso);
            String repeticiones = edt_horas.getText().toString();
            values.put("horas",repeticiones);
        }
        db.insert("actividades", null, values);
      //  Snackbar.make(V, "Replace with your own action", Snackbar.LENGTH_LONG)
        //        .setAction("Action", null).show();
        super.onBackPressed();
    }

}
