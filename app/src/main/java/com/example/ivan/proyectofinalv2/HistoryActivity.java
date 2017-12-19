package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ivan.proyectofinalv2.entity.Actividad;
import com.example.ivan.proyectofinalv2.entity.Aerobica;
import com.example.ivan.proyectofinalv2.entity.Anaerobica;

import java.util.ArrayList;

/**
 * Created by IVAN on 16/12/2017.
 */

public class HistoryActivity extends Activity{

    ArrayList<Actividad> actividades; //No se que sea lo correcto, pero esto lo puse por mientras, me base en el del profe de
    //los contactos
    ArrayList<Aerobica> aeroActivities;
    ArrayList<Anaerobica> anaeroActivities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        DatabaseHelper db = new DatabaseHelper(this, null, null, 1);

        //Solo por poner algo puse el nombre y la descripcion, no se si eso vaya a quedar finalmente
        actividades = db.lstActividades(); //De aqui obtenemos el listado de la base de datos.
        aeroActivities = db.lstActividadesAERO();
        anaeroActivities = db.lstActividadesANAERO();
        ArrayList<String> nombresActividades = new ArrayList<>();
        ArrayList<String> descripcionActividades = new ArrayList<>();
        //Obtenemos la lista de actividades, tanto aerobicas como anaerobicas
        // Pero el nombre de donde va a estar saliendo? pq ese esta en el objeto Actividad
        Actividad actividad;
        for (Anaerobica anaero : anaeroActivities){
            actividad = actividades.get((anaero.getIdActividad()-1));
            nombresActividades.add(actividad.getNombre());
            descripcionActividades.add(anaero.getDescripcion());
        }

        for(Aerobica aero : aeroActivities) {

            actividad = actividades.get((aero.getIdActividad()-1));
            nombresActividades.add(actividad.getNombre());
            descripcionActividades.add(aero.getDescripcion());
        }

        ListView lstactividades = (ListView) findViewById(R.id.lstActividades);
        lstactividades.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresActividades));

        lstactividades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SummaryActvity.class);
                intent.putExtra("nombre", actividades.get(i).getNombre());
                intent.putExtra("descripcion", actividades.get(i).getDescripcion());
                intent.putExtra("categoria", actividades.get(i).getCategoria());
                startActivity(intent);
            }
        });

    }
}
