package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Forearms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forearm_exercises);

        benchWristCurlButton();
    }

    private void benchWristCurlButton() {
        Button benchWristCurl = (Button) findViewById(R.id.benchWristCurl);
        benchWristCurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Forearms.this, a_fBenchWristCurl.class));
            }
        });
    }
}