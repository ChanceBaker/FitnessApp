package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Calves extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calves_exercises);
        calfRaiseButton();
    }

    private void calfRaiseButton() {

        Button calfRaise = (Button) findViewById(R.id.calfRaise);
        calfRaise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Calves.this, l_cCalfRaise.class));
            }
        });
    }
}