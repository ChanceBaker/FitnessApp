package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exercise_Back extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back_exercises);
        pullupButton();
        chinupButton();
        latPullDownButton();
    }

    private void pullupButton() {
        Button pullup= (Button) findViewById(R.id.pullup);
        pullup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Back.this, Back_Pull_Ups.class));
            }
        });
    }

    private void chinupButton() {
        Button chinup= (Button) findViewById(R.id.chinup);
        chinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Back.this, Back_Chin_Ups.class));
            }
        });

    }

    private void latPullDownButton() {
        Button pulldown= (Button) findViewById(R.id.pulldown);
        pulldown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Exercise_Back.this, Back_Pull_Down.class));
            }
        });

    }
}
