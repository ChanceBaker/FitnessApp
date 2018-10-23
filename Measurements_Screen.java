package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Measurements_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements_screen);
        addButton();
        myMeasureButton();
    }

    private void myMeasureButton() {
        Button myMeasure = (Button) findViewById(R.id.my_measurements_button);
        myMeasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Measurements_Screen.this, My_Measurements.class));
            }
        });
    }

    private void addButton() {

        Button add = (Button) findViewById(R.id.add_measurements);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Measurements_Screen.this, Measurements.class));
            }
        });
    }
}
