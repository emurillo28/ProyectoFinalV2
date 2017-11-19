package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
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
    // poner los atributos aqui
    // private edt1, edt2, edt3;

    protected void onCreate(Bundle  savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ocupamos obtener el tipo de actividad que es
        String categ = "AERO";

        if(categ == "AERO") {
            setContentView(R.layout.activity_aero_entry);
            // De donde estariamos sacando el nombre de la actividad?
            aeroFunctionality();
        } else {
            // setContentView(R.layout.activity_anaero_entry);
            anaeroFunctionality();
        }
    }

    private void aeroFunctionality() {
        edt_tiempo = (EditText) findViewById(R.id.edt_tiempo);
        edt_descripcion = (EditText) findViewById(R.id.edt_descripcion);

        tv_fecha = (TextView) findViewById(R.id.tv_fecha);

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

        // Obtenemos los datos para la actividad aerobica
        /*
        * fecha
        * tiempo
        * distancia
        * descripcion
        * idForaneaActividad // de donde sacamos este? xd
        * */

    }

    private void anaeroFunctionality() {
        // obtenemos datos para las actividades anaerobicas.
    }
}
