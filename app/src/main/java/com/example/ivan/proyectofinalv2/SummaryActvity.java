package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ivan.proyectofinalv2.entity.Actividad;

import static android.content.ContentValues.TAG;

/**
 * Created by IVAN on 16/12/2017.
 */

public class SummaryActvity extends Activity {

    TextView tvNombre, tvDescripcion, tvFecha, tvDistancia, tvDuracion, tvDurDis, tvDurDis2, tvTiempo;
    private Actividad actividad;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String descripcion = parametros.getString("descripcion");
        String categoria = parametros.getString("categoria");
        String fecha = parametros.getString("fecha");
        String peso = parametros.getString("peso");
        String distancia = parametros.getString("distancia");
        String tiempo = parametros.getString("tiempo");

        String todas = "nombre:" + nombre +"descripcion" + descripcion +"categoria"
                + categoria +"fecha" + fecha +"peso" + peso +"distancia" + distancia +"tiempo" + tiempo;


        Log.d(TAG,todas);

        tvNombre = (TextView) findViewById(R.id.tvActividad);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion2);
        tvDurDis2 = (TextView) findViewById(R.id.tvDurDis2);
        tvDurDis = (TextView) findViewById(R.id.tvDurDis);
        tvTiempo = (TextView) findViewById(R.id.tvTiempo2);


        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvDescripcion.setText(descripcion);
        tvTiempo.setText(tiempo);
        //tvDurDis2.setText("");
        if(categoria.equalsIgnoreCase("AERO")) { //Dependiendo de la actividad, se cambia la opcion que muestra
            tvDurDis2.setText(distancia);
            tvDurDis.setText("Distancia");
        } else {
            tvDurDis2.setText(peso);
            tvDurDis.setText("Peso");
        }
    }

}
