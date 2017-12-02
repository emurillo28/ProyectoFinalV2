package com.example.ivan.proyectofinalv2;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by IVAN on 01/12/2017.
 */

public class SelectActivity extends AppCompatActivity{

    TextView tvRunning;
    ImageView imgRunning;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        tvRunning = (TextView) findViewById(R.id.tvRunning);
        imgRunning = (ImageView) findViewById(R.id.imgRunning);
    }

    public void launchEnterActivity(View v) {
        Intent EnterActivity = new Intent(getApplicationContext(), EnterActivityData.class);
        startActivity(EnterActivity);
    }
}
