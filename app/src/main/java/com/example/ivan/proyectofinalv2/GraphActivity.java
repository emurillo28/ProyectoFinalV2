package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.ivan.proyectofinalv2.entity.Actividad;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IVAN on 18/12/2017.
 */

public class GraphActivity extends Activity{
    ArrayList<Actividad> actividades;
    String fecha2;
    Date date;
    float fecha;
    long reference_timestamp = 1451660400;
    long xnew;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        DatabaseHelper db = new DatabaseHelper(this, null, null, 1);
        actividades = db.lstActividades(); //De aqui obtenemos el listado de la base de datos.
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        BarChart chart = (BarChart) findViewById(R.id.chart);

        //YourData[] dataObjects = ...;

        List<BarEntry> entries = new ArrayList<BarEntry>();

        for (Actividad actividad : actividades) {
            // turn your data into Entry objects
            try {
                date = simpleDateFormat.parse(actividad.getFecha());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            xnew = date.getTime() - reference_timestamp;
            fecha2 = actividad.getFecha().replace("-", "");
            fecha = Float.valueOf(fecha2);
            if (actividad.getNombre().equalsIgnoreCase("Running") || actividad.getNombre().equalsIgnoreCase("Ciclismo") || actividad.getNombre().equalsIgnoreCase("Caminata")
                    || actividad.getNombre().equalsIgnoreCase("Natacion")) {
                entries.add(new BarEntry(xnew, actividad.getDistancia()));
            }else {
                Integer peso = Integer.valueOf(actividad.getPeso());
                entries.add(new BarEntry(xnew, peso));
            }
        }
        BarDataSet dataSet = new BarDataSet(entries, "Label"); // add entries to dataset
        IAxisValueFormatter xAxisFormatter = new DateAxisValueFormatter(reference_timestamp);
        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(xAxisFormatter);
        //dataSet.setColor(R.color.colorPrimaryDark);
       // dataSet.setValueTextColor(); // styling, ...
        BarData lineData = new BarData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
}/*
package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.ivan.proyectofinalv2.entity.Actividad;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

*/
/**
 * Created by IVAN on 18/12/2017.
 *//*


public class GraphActivity extends Activity{
    ArrayList<Actividad> actividades;
    String fecha2;
    float fecha;
    Date date;
    Calendar cal;
    long reference_timestamp = 1451660400;
    long xnew;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        DatabaseHelper db = new DatabaseHelper(this, null, null, 1);
        actividades = db.lstActividades(); //De aqui obtenemos el listado de la base de datos.

        LineChart chart = (LineChart) findViewById(R.id.chart);
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        //YourData[] dataObjects = ...;
        List<Entry> entries = new ArrayList<Entry>();

        for (Actividad actividad : actividades) {
            // turn your data into Entry objects
            try {
                date = simpleDateFormat.parse(actividad.getFecha());
            } catch (ParseException e) {
                e.printStackTrace();
            }
           // fecha2 = actividad.getFecha().replace("/", "");
            //fecha = cal.getTimeInMillis(date);
            xnew = date.getTime() - reference_timestamp;
            Toast.makeText(getApplicationContext(), String.valueOf(fecha), Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), String.valueOf(actividad.getTiempo()), Toast.LENGTH_SHORT).show();
            entries.add(new Entry(xnew, actividad.getTiempo()));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(0x000000);
        dataSet.setValueTextColor(0xFFFFFF); // styling, ...
        //IAxisValueFormatter xAxisFormatter = new DateAxisValueFormatter(referenceTimestamp);
        //XAxis xAxis = mChart.getXAxis();
        //xAxis.setValueFormatter(xAxisFormatter);
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
}
*/
