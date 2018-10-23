package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Biceps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bicep_exercises);

        spiderCurlButton();
        hammerCurlButton();
        cableCurlButton();
    }

    private void spiderCurlButton() {
        Button spiderCurl = (Button) findViewById(R.id.spiderCurl);
        spiderCurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Biceps.this, a_bSpiderCurl.class));
            }
        });
    }

    private void hammerCurlButton() {
        Button hammerCurl = (Button) findViewById(R.id.hammerCurls);
        hammerCurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Biceps.this, a_bHammerCurl.class));
            }
        });
    }

    private void cableCurlButton() {
        Button cableCurl = (Button) findViewById(R.id.cableCurl);
        cableCurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Biceps.this, a_bCableCurl.class));
            }
        });
    }
}