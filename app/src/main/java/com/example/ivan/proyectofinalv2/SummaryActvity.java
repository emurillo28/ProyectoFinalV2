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

    TextView tvNombre, tvDescripcion, tvFecha, tvDurDis, tvDurDis2, tvTiempo, tvTiempo2;
    private Actividad actividad;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String descripcion = parametros.getString("descripcion");
        String categoria = parametros.getString("categoria");
        String fecha = parametros.getString("fecha");
        Integer horas = parametros.getInt("horas");
        Integer minutos = parametros.getInt("minutos");
        Integer segundos = parametros.getInt("segundos");
        String peso = parametros.getString("peso");
        Float distancia = parametros.getFloat("distancia");

        tvNombre = (TextView) findViewById(R.id.tvActividad);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion2);
        tvDurDis2 = (TextView) findViewById(R.id.tvDurDis2);
        tvDurDis = (TextView) findViewById(R.id.tvDurDis);
        tvTiempo = (TextView) findViewById(R.id.tvTiempo);
        tvTiempo2 = (TextView) findViewById(R.id.tvTiempo2);

        String sdistancia = distancia + " Km";
        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvDescripcion.setText(descripcion);

        if(categoria.equalsIgnoreCase("AERO")) { //Dependiendo de la actividad, se cambia la opcion que muestra
            tvDurDis.setText("Distancia");
            tvDurDis2.setText(sdistancia);
            tvTiempo.setText("Tiempo");
            String stiempo = horas + ":" + minutos + ":" + segundos;
            tvTiempo2.setText(stiempo);
        } else {
            tvDurDis.setText("Peso");
            tvDurDis2.setText(peso);
            tvTiempo.setText("Repeticiones");
            String stiempo = horas + " Kg";
            tvTiempo2.setText(stiempo);
        }
    }

}
