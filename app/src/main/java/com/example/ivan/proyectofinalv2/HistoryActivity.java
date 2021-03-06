package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ivan.proyectofinalv2.entity.Actividad;
import com.example.ivan.proyectofinalv2.entity.Categoria;

import java.util.ArrayList;

/**
 * Created by IVAN on 16/12/2017.
 */

public class HistoryActivity extends Activity{

    ArrayList<Actividad> actividades;
    Categoria categoria;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        db = new DatabaseHelper(this, null, null, 1);

        //Solo por poner algo puse el nombre y la descripcion, no se si eso vaya a quedar finalmente
        actividades = db.lstActividades(); //De aqui obtenemos el listado de la base de datos.
        ArrayList<String> nombresActividades = new ArrayList<>();
        for (Actividad actividad : actividades){
            nombresActividades.add(actividad.getNombre());
        }

        ListView lstactividades = (ListView) findViewById(R.id.lstActividades);
        lstactividades.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresActividades));
        lstactividades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SummaryActvity.class);
                intent.putExtra("nombre", actividades.get(i).getNombre());
                intent.putExtra("descripcion", actividades.get(i).getDescripcion());
                intent.putExtra("fecha", actividades.get(i).getFecha());
                intent.putExtra("horas", actividades.get(i).getHoras());
                intent.putExtra("minutos", actividades.get(i).getMinutos());
                intent.putExtra("segundos", actividades.get(i).getSegundos());
                intent.putExtra("peso", actividades.get(i).getPeso());
                intent.putExtra("distancia", actividades.get(i).getDistancia());
                categoria = db.getCategoria(actividades.get(i).getNombre());
                intent.putExtra("categoria", categoria.getCategoria());
                startActivity(intent);
            }
        });

    }
}
