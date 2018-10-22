package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Quads extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quad_exercises);
        singleLegPressButton();
    }

    private void singleLegPressButton() {

        Button singleLegPress = (Button) findViewById(R.id.singleLegPress);
        singleLegPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quads.this, l_qSingleLegPress.class));
            }
        });
    }
}