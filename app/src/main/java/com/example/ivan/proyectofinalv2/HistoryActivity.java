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

    ArrayList<Actividad> actividades; //No se que sea lo correcto, pero esto lo puse por mientras, me base en el del profe de
    //los contactos
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
                categoria = db.getCategoria(actividades.get(i).getNombre());
                intent.putExtra("categoria", categoria.getCategoria());
                startActivity(intent);
            }
        });

    }
}
