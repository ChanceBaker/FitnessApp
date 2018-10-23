package com.fitapp.sdp.fitnessapp;

import android.app.Activity;
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

        weightButton();
        measureButton();
        completeButton();
        bmiCalcButton();


    }

    private void completeButton() {
        Button complete = (Button) findViewById(R.id.completed_workouts);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProgress.this, Completed_Workouts.class));
            }
        });
    }

    private void weightButton() {

        Button weight = (Button) findViewById(R.id.my_weight);
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProgress.this, My_Weight.class));
            }
        });
    }


    private void measureButton() {

        Button measure = (Button) findViewById(R.id.measurements);
        measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProgress.this, Measurements_Screen.class));
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
