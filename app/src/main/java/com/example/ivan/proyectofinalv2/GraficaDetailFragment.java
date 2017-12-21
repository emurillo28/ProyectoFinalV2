package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.ivan.proyectofinalv2.entity.Actividad;
import com.example.ivan.proyectofinalv2.entity.Categoria;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * A fragment representing a single Grafica detail screen.
 * This fragment is either contained in a {@link GraficaListActivity}
 * in two-pane mode (on tablets) or a {@link GraficaDetailActivity}
 * on handsets.
 */
public class GraficaDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "nombre";

    /**
     * The dummy content this fragment is presenting.
     */
    private Categoria mItem;
    private ArrayList<Actividad> registros;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GraficaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper db = new DatabaseHelper(this.getContext(),null,null,1);
        //ArrayList<Categoria> categorias = db.lstCategorias();

            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            //mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            mItem = db.getCategoria(getArguments().getString(ARG_ITEM_ID));
            registros = db.lstActividades(mItem.getNombre());
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getNombre());
            }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grafica_detail, container, false);

        // Show the dummy content as text in a TextView.
            //((TextView) rootView.findViewById(R.id.grafica_detail)).setText(mItem.details);
        //TODO aun falta sacar los datos de la base de datos para graficarlos
        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        GridLabelRenderer labelRenderer = graph.getGridLabelRenderer();
        labelRenderer.setHorizontalAxisTitle("Fecha (dia)");
        ArrayList<DataPoint> dataPoints = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        int fecha2=1;
        if(mItem.getCategoria().equalsIgnoreCase("Aero")){
            labelRenderer.setVerticalAxisTitle("Tiempo (min)");
            for (Actividad actividad:
                    registros) {
                try {
                    Date fecha = formatter.parse(actividad.getFecha());
                    String formated = new SimpleDateFormat("dd").format(fecha);
                    fecha2 = Integer.parseInt(formated);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dataPoints.add(new DataPoint(fecha2,actividad.getTiempo()));
            }
        }else {
            int peso;
            for (Actividad actividad:
                registros) {
                try {
                    Date fecha = formatter.parse(actividad.getFecha());
                    String formated = new SimpleDateFormat("dd").format(fecha);
                    fecha2 = Integer.parseInt(formated);
                } catch (ParseException e) {
                }
                peso = new Integer(actividad.getPeso());
            dataPoints.add(new DataPoint(fecha2,peso));
        }
            labelRenderer.setVerticalAxisTitle("Peso (kg)");
        }
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(1.0);
        graph.getViewport().setMaxX(33.0);

        DataPoint[] data = new DataPoint[dataPoints.size()];
        int i = 0;
        for (DataPoint point: dataPoints) {
            data[i] = point;
            i++;
        }
        if(i>0){
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(data);
            graph.addSeries(series);
        }

        return rootView;
    }
}
