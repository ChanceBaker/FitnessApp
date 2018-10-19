package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyProgress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_progress);

        bmiCalcButton();
        measureButton();
    }

    private void measureButton() {

        Button measure = (Button) findViewById(R.id.measurements);
        measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProgress.this, Measurements.class));
            }
        });
    }

    private void bmiCalcButton() {

        Button bmi = (Button) findViewById(R.id.bmi);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProgress.this, BMICalculator.class));
            }
        });
    }
}
