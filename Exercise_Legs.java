package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exercise_Legs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leg_exercises);
        quadsButton();
        hamstringButton();
        calvesButton();
    }

    private void calvesButton() {

        Button calves = (Button) findViewById(R.id.calves);
        calves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Legs.this, Calves.class));
            }
        });
    }

    private void hamstringButton() {

        Button ham = (Button) findViewById(R.id.hamstring);
        ham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Legs.this, Hamstrings.class));
            }
        });
    }

    private void quadsButton() {

        Button quads = (Button) findViewById(R.id.quads);
        quads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Legs.this, Quads.class));
            }
        });
    }
}
