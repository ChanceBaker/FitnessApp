package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        resetWeight();
        resetMeasurements();
        resetWorkouts();
        resetApp();
    }

    private void resetApp() {
        Button app = (Button) findViewById(R.id.reset_app);
        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, Reset_App.class));
            }
        });
    }

    private void resetWorkouts() {

        Button workouts = (Button) findViewById(R.id.reset_workouts);
        workouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, Reset_Completed_Workouts.class));
            }
        });
    }

    private void resetMeasurements() {

        Button measure = (Button) findViewById(R.id.reset_measurements);
        measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, Reset_Measurements_Progress.class));
            }
        });
    }

    private void resetWeight() {

        Button weight = (Button) findViewById(R.id.reset_weight);
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, Reset_Weight_Progress.class));
            }
        });
    }
}
