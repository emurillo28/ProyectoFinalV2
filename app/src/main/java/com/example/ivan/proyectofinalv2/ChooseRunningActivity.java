package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by IVAN on 13/11/2017.
 */

public class ChooseRunningActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runing);

        Button run400, run1, run3, run5, run10, run21;

        run400 = (Button) findViewById(R.id.btn_400m);
        //run1 = (Button) findViewById(R.id.btn_1k);
        run3 = (Button) findViewById(R.id.btn_3k);
        run5 = (Button) findViewById(R.id.btn_5k);
        run10 = (Button) findViewById(R.id.btn_10k);
        run21 = (Button) findViewById(R.id.btn_21k);

        run400.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ActivityRunning = new Intent(getApplicationContext(), EnterRunningData.class);
                startActivity(ActivityRunning);
            }
        });
        run3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ActivityRunning = new Intent(getApplicationContext(), EnterRunningData.class);
                startActivity(ActivityRunning);
            }
        });
        run5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ActivityRunning = new Intent(getApplicationContext(), EnterRunningData.class);
                startActivity(ActivityRunning);
            }
        });
        run10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ActivityRunning = new Intent(getApplicationContext(), EnterRunningData.class);
                startActivity(ActivityRunning);
            }
        });
        run21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ActivityRunning = new Intent(getApplicationContext(), EnterRunningData.class);
                startActivity(ActivityRunning);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
