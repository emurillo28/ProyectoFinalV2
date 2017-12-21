package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ivan.proyectofinalv2.entity.Categoria;

import static android.content.ContentValues.TAG;

public class AgregarCategoria extends Activity {

    String cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_categoria);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] categoriass = {"Aero","Anaero"};
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoriass));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cat = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void guardar(View view){
        Categoria categoria = new Categoria();
        DatabaseHelper db = new DatabaseHelper(this,null,null,1);
        EditText edtNombre = (EditText) findViewById(R.id.Nombre);

        String nombre = edtNombre.getText().toString();

        categoria.setNombre(nombre);
        categoria.setCategoria(cat);

        Log.d(TAG,categoria.toString());

        db.agregarCategoria(categoria);
    }
}
