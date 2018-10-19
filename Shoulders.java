package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Shoulders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoulder_exercises);
        frontRaiseButton();
        lateralButton();
        reverseFlysButton();
    }

    private void reverseFlysButton() {

        Button reverse = (Button) findViewById(R.id.reverse_flys);
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Shoulders.this, Shoulders_Dumbell_Lateral_Raise.class));
            }
        });
    }

    private void frontRaiseButton() {

        Button front = (Button) findViewById(R.id.front_dumbbell_raise);
        front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Shoulders.this, Shoulders_Front_Dumbbell_Raise.class));
            }
        });
    }

    private void lateralButton() {

        Button lateral = (Button) findViewById(R.id.lateral_raise);
        lateral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Shoulders.this, Shoulders_Dumbell_Lateral_Raise.class));
            }
        });
    }
}
