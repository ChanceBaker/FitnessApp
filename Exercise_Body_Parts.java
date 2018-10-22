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
public class Exercise_Body_Parts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_body_parts);//Set view to exercise body parts list

        //Add OnClick listener to all buttons
        neckButton();
        trapsButton();
        chestButton();
        shouldersButton();
        armsButton();
        coreButton();
        backButton();
        legsButton();
    }

    /**
     * This method adds an OnClick listener to the legs button to open the leg exercises layout file
     * */
    private void legsButton() {

        Button legs = (Button) findViewById(R.id.legs);
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Body_Parts.this, Exercise_Legs.class));
            }
        });
    }

    /**
     * This method adds an OnClick listener to the back button to open the back exercises layout file
     * */
    private void backButton() {

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Body_Parts.this, Exercise_Back.class));
            }
        });
    }

    /**
     * This method adds an OnClick listener to the legs button to open the leg exercises layout file
     * */
    private void coreButton() {

        Button core = (Button) findViewById(R.id.core);
        core.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Body_Parts.this, CoreExercises.class));
            }
        });
    }

    /**
     * This method adds an OnClick listener to the arms button to open the arm exercises layout file
     * */
    private void armsButton() {
        Button arms = (Button) findViewById(R.id.arms);
        arms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Body_Parts.this, Arms.class));
            }
        });
    }

    /**
     * This method adds an OnClick listener to the shoulders button to open the shoulder exercises layout file
     * */
    private void shouldersButton() {
        Button shoulders = (Button) findViewById(R.id.shoulders);
        shoulders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Body_Parts.this, Shoulders.class));
            }
        });
    }

    /**
     * This method adds an OnClick listener to the chest button to open the chest exercises layout file
     * */
    private void chestButton() {
        Button chest = (Button) findViewById(R.id.chest);
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Body_Parts.this, Chest.class));
            }
        });
    }

    /**
     * This method adds an OnClick listener to the trap_exercises button to open the trap exercises layout file
     * */
    private void trapsButton() {
        Button traps = (Button) findViewById(R.id.traps);
        traps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Body_Parts.this, TrapExercises.class));
            }
        });
    }

    /**
     * This method adds an OnClick listener to the neck button to open the neck exercises layout file
     * */
    private void neckButton() {
        Button neck = (Button) findViewById(R.id.neck);
        neck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Body_Parts.this, NeckExercises.class));
            }
        });
    }
}
