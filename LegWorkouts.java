package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LegWorkouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leg_workouts);
        workout1Button();
    }

    private void workout1Button() {

        Button workout1 = (Button) findViewById(R.id.leg_workout_1_button);
        workout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LegWorkouts.this, Leg_Workout_1.class));
            }
        });
    }
}
