package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.ivan.proyectofinalv2.entity.Actividad;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IVAN on 18/12/2017.
 */

public class GraphActivity extends Activity{
    ArrayList<Actividad> aerobicas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        DatabaseHelper db = new DatabaseHelper(this, null, null, 1);
        aerobicas = db.lstActividades(); //De aqui obtenemos el listado de la base de datos.

        LineChart chart = (LineChart) findViewById(R.id.chart);

        //YourData[] dataObjects = ...;

        List<Entry> entries = new ArrayList<Entry>();

        for (Actividad aerobica : aerobicas) {
            // turn your data into Entry objects

            entries.add(new Entry(aerobica.getDistancia(), aerobica.getTiempo()));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        //dataSet.setColor(0x000000);
        //dataSet.setValueTextColor(0xFFFFFF); // styling, ...
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
}
