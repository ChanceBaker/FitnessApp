package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NeckExercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neck_exercises);
        neckLiftButton();


    }

    private void neckLiftButton() {
        Button neckLift = (Button) findViewById(R.id.neckLift);
        neckLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NeckExercises.this, NeckExercise1.class));
            }
        });
    }
}
