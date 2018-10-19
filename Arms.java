package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Arms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arm_exercises);

        bicepsButtons();
        tricepsButton();
        forearmsButton();
    }

    private void forearmsButton() {

        Button forearms = (Button) findViewById(R.id.forearmExercises);
        forearms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Arms.this, Forearms.class));
            }
        });
    }

    private void tricepsButton() {

        Button triceps = (Button) findViewById(R.id.tricepExercises);
        triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Arms.this, Triceps.class));
            }
        });
    }

    private void bicepsButtons() {

        Button biceps = (Button) findViewById(R.id.bicepsExercises);
        biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Arms.this, Biceps.class));
            }
        });

    }
}
