package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ivan.proyectofinalv2.entity.Actividad;
import com.example.ivan.proyectofinalv2.entity.Categoria;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.id.list;
import static android.content.ContentValues.TAG;

/**
 * Created by IVAN on 01/12/2017.
 */

public class SelectActivity extends AppCompatActivity{

    TextView tvRunning, tvCycling, tvSwimming, tvWalking, tvPesas, tvFuerza;
    String[] itemname= {
            "Running", "Ciclismo", "Natacion", "Caminata", "Fuerza", "Pesas"
    };
    Integer[] imgid={
            R.drawable.icons8_running_50,
            R.drawable.icons8_cycling_50,
            R.drawable.icons8_swimming_50,
            R.drawable.icons8_walking_filled_50,
            R.drawable.icons8_pushups_50,
            R.drawable.icons8_weightlifting_50,
    };
    ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.lst_Actividades);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String Slecteditem = itemname[+position];
                Log.d(TAG,Slecteditem);
                Intent EnterActivity = new Intent(getApplicationContext(), EnterActivityData.class);
                EnterActivity.putExtra("activity", Slecteditem);
                startActivity(EnterActivity);
            }
        });
    }
}
