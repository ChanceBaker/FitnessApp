package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This class sets the content view to the exercise body parts list layout and
 * add an OnClick listener to all buttons in the exercise_body_parts xml layout file.
 * */
public class Workouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.workouts);//Set view to exercise body parts list

        //Add OnClick listener to all buttons
        chestButton();
        shouldersButton();
        armsButton();
        coreButton();
        backButton();
        legsButton();
        wholeBodyButton();
        cardioButton();
    }

    private void cardioButton() {

        Button cardio = (Button) findViewById(R.id.cardio);
        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Workouts.this, CardioWorkouts.class));
            }
        });

    }

    private void wholeBodyButton() {

        Button body = (Button) findViewById(R.id.wholeBody);
        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Workouts.this, WholeBodyWorkouts.class));
            }
        });
    }

    /**
     * This method adds an OnClick listener to the legs button to open the leg workout layout file
     * */
    private void legsButton() {

        Button legs = (Button) findViewById(R.id.legs);
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Workouts.this, LegWorkouts.class));
            }
        });
    }

    private void backButton() {

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Workouts.this, BackWorkouts.class));
            }
        });
    }

    private void coreButton() {

        Button core = (Button) findViewById(R.id.core);
        core.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Workouts.this, CoreWorkouts.class));
            }
        });
    }

    private void armsButton() {

        Button arms = (Button) findViewById(R.id.arms);
        arms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Workouts.this, ArmWorkouts.class));
            }
        });
    }

    private void shouldersButton() {

        Button shoulders = (Button) findViewById(R.id.shoulders);
        shoulders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Workouts.this, ShoulderWorkouts.class));
            }
        });
    }

    private void chestButton() {

        Button chest = (Button) findViewById(R.id.chest);
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Workouts.this, ChestWorkouts.class));
            }
        });
    }
}
