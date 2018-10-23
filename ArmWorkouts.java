package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArmWorkouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arm_workouts);
        workout1Button();
    }

    private void workout1Button() {

        Button workout1 = (Button) findViewById(R.id.arm_workout_1_button);
        workout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ArmWorkouts.this, Arm_Workout_1.class));
            }
        });

    }
}
