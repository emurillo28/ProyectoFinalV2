package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.ivan.proyectofinalv2.entity.Actividad;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IVAN on 18/12/2017.
 */

public class GraphActivity extends Activity{
    ArrayList<Actividad> actividades;
    String fecha2;
    float fecha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        DatabaseHelper db = new DatabaseHelper(this, null, null, 1);
        actividades = db.lstActividades(); //De aqui obtenemos el listado de la base de datos.

        BarChart chart = (BarChart) findViewById(R.id.chart);

        //YourData[] dataObjects = ...;

        List<BarEntry> entries = new ArrayList<BarEntry>();

        for (Actividad actividad : actividades) {
            // turn your data into Entry objects
            fecha2 = actividad.getFecha().replace("/", "");
            fecha = Float.valueOf(fecha2);
            Toast.makeText(getApplicationContext(), String.valueOf(fecha), Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), String.valueOf(actividad.getTiempo()), Toast.LENGTH_SHORT).show();
            entries.add(new BarEntry(fecha, actividad.getTiempo()));
        }
        BarDataSet dataSet = new BarDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(0x000000);
        dataSet.setValueTextColor(0xFFFFFF); // styling, ...
        BarData lineData = new BarData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
}
