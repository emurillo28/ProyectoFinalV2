package com.example.ivan.proyectofinalv2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.ivan.proyectofinalv2.entity.Categoria;


import java.util.ArrayList;

import javax.crypto.KeyAgreement;

import static android.content.ContentValues.TAG;

/**
 * Created by IVAN on 01/12/2017.
 */

public class SelectActivity extends AppCompatActivity{

    DatabaseHelper db;
    ArrayList<Categoria> categorias;
    ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        db = new DatabaseHelper(this, null, null, 1);
        categorias = db.lstCategorias();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        final ArrayList<String> lasCategorias = new ArrayList<>();
        for (Categoria categoria : categorias){
            lasCategorias.add(categoria.getNombre());
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AgregarCategoria.class);
                startActivity(intent);
                //crearCategoria();
            }
        });
        list=(ListView)findViewById(R.id.lst_Actividades);
        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lasCategorias));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String Slecteditem = lasCategorias.get(position);
                Log.d(TAG,Slecteditem);
                Intent EnterActivity = new Intent(getApplicationContext(), EnterActivityData.class);
                EnterActivity.putExtra("activity", Slecteditem);
                startActivity(EnterActivity);
            }
        });
    }

    private void crearCategoria() {
        DatabaseHelper db = new DatabaseHelper(this,null,null,1);
        Categoria categoria = new Categoria();


        setContentView(R.layout.activity_agregar_categoria);
        db.agregarCategoria(categoria);
    }
}
