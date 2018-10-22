package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Triceps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tricep_exercises);

        tricepDipsButton();
    }

    private void tricepDipsButton() {
        Button tricepDips = (Button) findViewById(R.id.tricepDips);
        tricepDips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Triceps.this, a_tTricepDips.class));
            }
        });
    }
}