package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CoreExercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.core_exercises);
        medicineBallSlamButton();
        plankButton();
        bottomsUpButton();
        landmineButton();
    }

    private void medicineBallSlamButton() {
        Button medicineBallSlam = (Button) findViewById(R.id.medicineBallSlam);
        medicineBallSlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoreExercises.this, ab1MedicineBallSlam.class));
            }
        });
    }

    private void plankButton() {
        Button plank = (Button) findViewById(R.id.plank);
        plank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoreExercises.this, ab2Plank.class));
            }
        });
    }

    private void bottomsUpButton() {
        Button bottomsUp = (Button) findViewById(R.id.bottomsUp);
        bottomsUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoreExercises.this, ab3BottomsUp.class));
            }
        });
    }

    private void landmineButton() {
        Button landmine = (Button) findViewById(R.id.landmine);
        landmine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoreExercises.this, ab4Landmine.class));
            }
        });
    }
}
