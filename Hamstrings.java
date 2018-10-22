package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Hamstrings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hamstring_exercises);
        cleanDeadliftButton();
    }

    private void cleanDeadliftButton() {

        Button calfRaise = (Button) findViewById(R.id.cleanDeadlift);
        calfRaise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hamstrings.this, l_hCleanDeadlift.class));
            }
        });
    }
}