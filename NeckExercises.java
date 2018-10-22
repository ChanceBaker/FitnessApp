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
        plateNeckResistButton();
        isometricNeckButton();
        neckBridgeProneButton();
    }

    private void neckLiftButton() {
        Button neckLift = (Button) findViewById(R.id.neckLift);
        neckLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NeckExercises.this, n1HeadLift.class));
            }
        });
    }

    private void plateNeckResistButton() {
        Button plateNeckResist = (Button) findViewById(R.id.plateNeckResist);
        plateNeckResist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NeckExercises.this, n2PlateNeckResist.class));
            }
        });
    }

    private void isometricNeckButton() {
        Button isometricNeck = (Button) findViewById(R.id.isometricNeck);
        isometricNeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NeckExercises.this, n3IsometricNeck.class));
            }
        });
    }

    private void neckBridgeProneButton() {
        Button neckBridgeProne = (Button) findViewById(R.id.neckBridgeProne);
        neckBridgeProne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NeckExercises.this, n4NeckBridge.class));
            }
        });
    }
}
