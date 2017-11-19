package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Ernesto on 18/11/2017.
 */

public class EnterActivityData extends Activity {

    // poner los atributos aqui
    // private edt1, edt2, edt3;

    protected void onCreate(Bundle  savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ocupamos obtener el tipo de actividad que es
        String categ = "AERO";

        if(categ == "AERO") {
            // setContentView(R.layout.activity_aero_entry);
            // De donde estariamos sacando el nombre de la actividad?
            aeroFunctionality();
        } else {
            // setContentView(R.layout.activity_anaero_entry);
            anaeroFunctionality();
        }
    }

    private void aeroFunctionality() {
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
