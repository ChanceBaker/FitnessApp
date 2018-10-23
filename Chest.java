package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chest_exercises);
        flatButton();
        inclineButton();
        decline();
    }

    private void decline() {
        Button decline = (Button) findViewById(R.id.declinebenchPress);
        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Chest.this, DeclineBenchPress.class));
            }
        });
    }

    private void inclineButton() {
        Button incline = (Button) findViewById(R.id.inclinebenchPress);
        incline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Chest.this, InclineBenchPress.class));
            }
        });

    }

    private void flatButton() {
        Button flat = (Button) findViewById(R.id.benchPress);
        flat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Chest.this, FlatBenchPress.class));
            }
        });

    }
}
