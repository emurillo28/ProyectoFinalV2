package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ivan.proyectofinalv2.entity.Actividad;

/**
 * Created by IVAN on 16/12/2017.
 */

public class SummaryActvity extends Activity {

    TextView tvNombre, tvDescripcion, tvFecha, tvDistancia, tvDuracion, tvDurDis, tvDurDis2;
    private Actividad actividad;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String descripcion = parametros.getString("descripcion");
        String categoria = parametros.getString("categoria");

        tvNombre = (TextView) findViewById(R.id.tvActividad);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion2);
        tvDurDis2 = (TextView) findViewById(R.id.tvDurDis);
        tvDurDis = (TextView) findViewById(R.id.tvDurDis2);


        tvNombre.setText(nombre);
        //tvFecha.setText();
        tvDescripcion.setText(descripcion);
        //tvDurDis2.setText();
        if(categoria.equalsIgnoreCase("AERO")) { //Dependiendo de la actividad, se cambia la opcion que muestra
            tvDurDis.setText("Distancia");
        } else {
            tvDurDis.setText("Duracion");
        }
    }

}
